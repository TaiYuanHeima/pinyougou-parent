package cn.itcast.dubboxdemo.service.impl;


import cn.itcast.dubboxdemo.service.UserService;
import com.alibaba.dubbo.config.annotation.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public String getName() {
        return "itcast";
    }
}
