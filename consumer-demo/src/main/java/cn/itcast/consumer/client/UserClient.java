package cn.itcast.consumer.client;

import cn.itcast.consumer.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "user-service", fallback = UserFallback.class)
public interface UserClient {


    @GetMapping("/user/{id}")
    public User queryById(@PathVariable("id") Long id);

}
