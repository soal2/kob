package com.kob.backend.service.impl.user.bot;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kob.backend.mapper.BotMapper;
import com.kob.backend.pojo.Bot;
import com.kob.backend.pojo.User;
import com.kob.backend.service.impl.utils.UserDetailsImpl;
import com.kob.backend.service.user.bot.AddService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

@Service
public class AddServiceImpl implements AddService {

    //把bot加入到数据库
    @Autowired
    private BotMapper botMapper;
    @Override
    public Map<String, String> add(Map<String, String> data) {
        //获取当前认证的用户信息
        UsernamePasswordAuthenticationToken authenticationToken =
                (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        //提取用户详细信息
        UserDetailsImpl loginUser = (UserDetailsImpl) authenticationToken.getPrincipal();
        User user = loginUser.getUser();  //获取用户信息

        String title = data.get("title");
        String description = data.get("description");
        String content = data.get("content");

        Map<String, String> map = new HashMap<>();

        if(title == null || title.length() == 0){
            map.put("error_message", "标题不能为空");
            return map;
        }

        if(title.length() > 100){
            map.put("error_message", "标题长度不能大于100");
            return map;
        }

        if(description == null && description.length() == 0)
        {
            map.put("error_message", "这个用户很懒，什么也没有留下~");
            return map;
        }
        if(description.length() > 300){
            map.put("error_message", "Bot的描述长度不能大于300");
            return map;
        }

        if(content.length() == 0 || content == null)
        {
            map.put("error_message", "代码不能为空");
            return map;
        }

        if(content.length() > 10000){
            map.put("error_message", "代码长度不能超过10000");
            return map;
        }

        QueryWrapper<Bot> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", user.getId());
        if(botMapper.selectCount(queryWrapper) >= 10) {
            map.put("error_message", "每个用户最多只能创建10个Bot! ");
            return map;
        }

        Date now = new Date();   //获取当前时间
        //都合法则新建bot将输入参数写入
        Bot bot = new Bot(null, user.getId(), title, description, content, now, now);

        //把bot加入到数据库中
        botMapper.insert(bot);
        map.put("error_message", "success");
        return map;
    }
}
