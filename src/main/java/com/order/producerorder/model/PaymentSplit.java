package com.order.producerorder.model;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.UUID;

@Data
@Entity
public class PaymentSplit {
    @Id
    private String id;
    private Double paid_amount;
    @OneToOne(cascade = CascadeType.ALL)
    private Payment payment;

    public PaymentSplit(){
        this.id= UUID.randomUUID().toString();
    }
}
