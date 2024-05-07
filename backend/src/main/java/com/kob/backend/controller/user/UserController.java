package com.kob.backend.controller.user;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kob.backend.mapper.UserMapper;
import com.kob.backend.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class UserController {

    @Autowired
    UserMapper userMapper;  //实例化mapper层的对象
    @GetMapping("/user/all/")
    public List<User> getAll(){
        return userMapper.selectList(null);  //查询所有用户
    }

    //查询某一个id的信息
    @GetMapping("/user/{userId}")
    public User getuser(@PathVariable int userId){  //将 URL 中的变量绑定到方法的参数上

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", userId);  //查询id为userid的信息
        return userMapper.selectOne(queryWrapper);

        //return userMapper.selectById(userId);
    }

    //插入信息
    @GetMapping("/user/add/{userId}/{username}/{password}/")
    public String addUser(
            @PathVariable int userId,
            @PathVariable String username,
            @PathVariable String password
    ){

        //加密
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(password);
        User user = new User(userId, username, encodedPassword);
        userMapper.insert(user);
        return "Insert Successfully!";
    }

    //删除用户
    @GetMapping("/user/delete/{userId}")
    public String deleteUser(@PathVariable int userId){
        userMapper.deleteById(userId);
        return "delete successfully";
    }

    //查询一个范围内的id信息
//    @GetMapping("/user/{userid}")
//    public List<User> getuser(@PathVariable int userid){
//        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
//        queryWrapper.le("id", 4).ge("id", 2);  //查询编号为2到4之间的信息
//        return userMapper.selectList(queryWrapper);
//    }
}
