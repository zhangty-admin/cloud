package com.web.cloud.dao;

import com.web.cloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

public interface PaymentDao {

    int createPayment(Payment payment);

    Payment getPaymentById(@Param("id") Long id);
}
