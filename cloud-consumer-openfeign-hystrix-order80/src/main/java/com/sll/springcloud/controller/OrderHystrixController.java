package com.sll.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.sll.springcloud.service.PaymentHystrixSerive;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
@DefaultProperties(defaultFallback = "payment_timeoutGlobalHandler")
public class OrderHystrixController {

    @Resource
    private PaymentHystrixSerive paymentHystrixSerive;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String payment_ok(@PathVariable("id") Integer id){
        String result = paymentHystrixSerive.payment_ok(id);
        log.info("******result:"+result);
        return result;
    }
//    @HystrixCommand(fallbackMethod = "payment_timeoutHandler",commandProperties ={
//            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="1500")
//    })
    @HystrixCommand
    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    public String payment_timeout(@PathVariable("id") Integer id){
        String result = paymentHystrixSerive.payment_timeout(id);
        log.info("******result:"+result);
        return result;
    }

    public String payment_timeoutHandler(@PathVariable("id") Integer id){
        return  "80出错";
    }

    public String payment_timeoutGlobalHandler(@PathVariable("id") Integer id){
        return  "global出错";
    }
}
