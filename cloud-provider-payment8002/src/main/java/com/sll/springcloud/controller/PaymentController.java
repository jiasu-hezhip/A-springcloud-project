package com.sll.springcloud.controller;

import com.sll.springcloud.entities.CommonResult;
import com.sll.springcloud.entities.Payment;
import com.sll.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment){

        int result = paymentService.create(payment);
        log.info("*********插入结果："+result);
        if (result > 0 ){
            return new CommonResult(200,"插入数据成功,serverport:"+serverPort,result);
        }else {
            return  new CommonResult(404,"插入数据库失败",null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("*********查询结果："+payment);
        if (payment != null ){
            return new CommonResult(200,"查询成功,serverport:"+serverPort,payment);
        }else {
            return  new CommonResult(404,"没有记录，ID："+id,null);
        }
    }

    @GetMapping(value = "/payment/lb")
    public String getPaymentLB(){
        return serverPort;
    }


}
