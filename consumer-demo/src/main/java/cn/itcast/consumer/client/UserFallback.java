package cn.itcast.consumer.client;

import cn.itcast.consumer.pojo.User;
import org.springframework.stereotype.Component;

@Component
public class UserFallback implements UserClient {
    @Override
    public User queryById(Long id) {
        User user = new User();
        user.setName("未知用户！");
        return user;
    }
}
