package com.kob.backend.service.impl.user.bot;

import com.kob.backend.mapper.BotMapper;
import com.kob.backend.pojo.Bot;
import com.kob.backend.pojo.User;
import com.kob.backend.service.impl.utils.UserDetailsImpl;
import com.kob.backend.service.user.bot.RemoveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class RemoveServiceImpl implements RemoveService {
    @Autowired
    private BotMapper botMapper;
    @Override
    public Map<String, String> remove(Map<String, String> data) {
        //获取当前认证的用户信息token
        UsernamePasswordAuthenticationToken authenticationToken =
                (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();

        //返回用户主体
        UserDetailsImpl loginUser = (UserDetailsImpl) authenticationToken.getPrincipal();
        //获取用户对象实例
        User user = loginUser.getUser();


        int bot_id = Integer.parseInt(data.get("bot_id"));
        //使用了MyBatis框架的Mapper接口方法，用于从数据库中查询特定ID的Bot对象
        Bot bot = botMapper.selectById(bot_id);

        Map<String, String> map = new HashMap<>();

        if(bot == null){
            map.put("error_message", "Bot不存在或已被删除");
            return map;
        }

        if(!bot.getUserId().equals(user.getId()))
        {
            map.put("error_message", "没有权限删除该Bot");
            return map;
        }

        botMapper.deleteById(bot_id);

        map.put("error_message", "success");
        return map;
    }
}
