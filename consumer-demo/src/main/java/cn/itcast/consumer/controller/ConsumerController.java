package cn.itcast.consumer.controller;

import cn.itcast.consumer.client.UserClient;
import cn.itcast.consumer.pojo.User;
//import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
//import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
//import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonLoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("consumer")
//@DefaultProperties(defaultFallback = "defaultFallback")
public class ConsumerController {

//    @Autowired
//    private RestTemplate restTemplate;

    @Autowired
    private UserClient userClient;

//    @Autowired
//    private DiscoveryClient discoveryClient;

//    @Autowired
//    private RibbonLoadBalancerClient client;

//    @GetMapping("{id}")
//    public User queryById(@PathVariable("id") Long id){
//        //根据服务id获取实例
////        List<ServiceInstance> instances = discoveryClient.getInstances("user-service");
////        ServiceInstance serviceInstance = client.choose("user-service");
//        //从实例中取出ip和端口
////        ServiceInstance serviceInstance = instances.get(0);
//        // 随机、轮询、hash
////        String url = "http://"+ serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/user/" + id;
////        System.out.println("url = " + url);
//
//        String url = "http://user-service/user/" + id;
//        User user = restTemplate.getForObject(url, User.class);
//        return user;
//    }

//    @GetMapping("{id}")
//    @HystrixCommand(fallbackMethod = "queryByIdFallback" )
//    @HystrixCommand(commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
//    })

    @GetMapping("{id}")
    public User queryById(@PathVariable("id") Long id){
        return userClient.queryById(id);
    }

//    @HystrixCommand(
//            commandProperties = {
//                @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),
//                @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),
//                @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60")
//            }
//    )
//    public String queryById(@PathVariable("id") Long id){
//        if(id % 2 == 0){
//            throw new RuntimeException("");
//        }
//        String url = "http://user-service/user/" + id;
//        String user = restTemplate.getForObject(url, String.class);
//        return user;
//    }

    public String queryByIdFallback(Long id) {
        return "不好意思，服务器太拥挤了！";
    }

    public String defaultFallback() {
        return "不好意思，服务器太拥挤了！";
    }
}
