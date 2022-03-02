package com.order.producerorder.model;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.Date;
import java.util.UUID;

@Data
//@NoArgsConstructor
@Entity
public class Payment {
    @Id
    private String id;
    private String method;
    private Date date;
    private Double confirmation_number;
    @OneToOne(cascade = CascadeType.ALL)
    private Address billing;

    public Payment(){
        this.id= UUID.randomUUID().toString();
    }
}
