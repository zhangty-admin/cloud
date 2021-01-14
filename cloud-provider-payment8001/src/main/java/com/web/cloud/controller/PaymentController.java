package com.web.cloud.controller;

import com.web.cloud.entities.CommonResult;
import com.web.cloud.entities.Payment;
import com.web.cloud.enums.Code;
import com.web.cloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/create")
    public CommonResult createPayment(@RequestBody Payment payment) {
        int paramId = paymentService.createPayment(payment);
        if (!StringUtils.isEmpty(paramId)) {
            return new CommonResult(Code.SUCCESS.value(), "创建成功", paramId);
        }
        return new CommonResult(Code.ERROR.value(), "创建失败");
    }

    @GetMapping("/getPayment/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        if (!StringUtils.isEmpty(payment)) {
            return new CommonResult(Code.SUCCESS.value(), "查询成功", payment);
        }
        return new CommonResult(Code.ERROR.value(), "查询失败,当前id不存在");
    }

}
