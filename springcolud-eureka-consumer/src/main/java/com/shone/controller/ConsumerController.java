package com.shone.controller;

//消费服务者，调用提供服务模块的服务

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/Hello")
public class ConsumerController {

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/Consumer")
    public String helloWorld(String s){
        System.out.println("消费服务模块，传入的值为：" + s);

        //第一种调用服务方式：
        //String forObject1 = new RestTemplate().getForObject("http://localhost:8701/Hello/World?s=" + s,String.class);

        //第二种调用方式：
        //注入LoadBalancerClient
        //根据服务名称获取服务列表，根据算法选取某个服务，并访问某个服务的网络位置
        /*ServiceInstance serviceInstance = loadBalancerClient.choose("EUREKA-SERVICE");
        String forObject2 = new RestTemplate().getForObject("http://"+serviceInstance.getHost()+":"+serviceInstance.getPort()+"/Hello/World?s="+s,String.class);
*/
        //第三种，需要restTemplate注入的方式，需要使用一个Bean类来获取restTemplate
        String forObject3 = restTemplate.getForObject("http://EUREKA-SERVICE/Hello/World?s=" + s,String.class);

        return forObject3;
    }
}
