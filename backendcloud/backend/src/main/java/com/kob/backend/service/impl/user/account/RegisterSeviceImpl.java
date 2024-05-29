package com.kob.backend.service.impl.user.account;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kob.backend.mapper.UserMapper;
import com.kob.backend.pojo.User;
import com.kob.backend.service.user.account.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RegisterSeviceImpl implements RegisterService {
    //注入访问数据库的对象
    @Autowired
    private UserMapper userMapper;

    //注入加密对象
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Map<String, String> register(String username, String password, String confirmedPassword) {
        Map<String, String> map = new HashMap<>();

        if(username == null){
            map.put("error_message", "用户名不能为空");
            return map;
        }

        if (password == null || confirmedPassword == null)
        {
            map.put("error_message", "密码不能为空");
            return map;
        }

        username = username.trim();  //删掉首尾的空白字符
        if(username.length() == 0)
        {
            map.put("error_message", "用户名不能为空");
            return map;
        }

        if(username.length() > 100){
            map.put("error_message", "用户名长度不能大于100");
            return map;
        }

        if(password.length() > 100 || confirmedPassword.length() > 100)
        {
            map.put("error_message", "密码长度不能大于100！");
            return map;
        }

        if(password.length() == 0 || confirmedPassword.length() == 0){
            map.put("error_message", "密码不能为空！");
            return map;
        }

        if(!password.equals(confirmedPassword)){
            map.put("error_message", "两次密码不一致！");
            return map;
        }

        //查询用户名，保证不重名
        //查询数据库里是否有用户名等于username的用户
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();  //创建查询对象
        queryWrapper.eq("username", username);  //指定查询条件
        List<User> users = userMapper.selectList(queryWrapper);  //从数据库检索所有符合条件的用户记录以list的形式返回给users

        if(!users.isEmpty()){
            map.put("error_message", "用户名已存在");
            return map;
        }

        String encodedPassword = passwordEncoder.encode(password);
        String photo = "https://cdn.acwing.com/media/user/profile/photo/282107_lg_ae3a889ab4.jpg";
        User user = new User(null, username, encodedPassword, photo, 1500);  //将新用户的信息保存
        userMapper.insert(user);  //存入数据库

        map.put("error_message", "success");
        return map;
    }
}
