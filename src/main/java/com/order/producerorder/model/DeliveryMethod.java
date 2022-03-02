package com.order.producerorder.model;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.UUID;

@Entity
@Data
public class DeliveryMethod {
    @Id
    private String id;
    private String type;

    @OneToOne(cascade = CascadeType.ALL)
    private Address shippingorpickup;

    public DeliveryMethod(){
        this.id= UUID.randomUUID().toString();
    }
}
