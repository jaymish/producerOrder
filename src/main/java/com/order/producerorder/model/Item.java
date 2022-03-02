package com.order.producerorder.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Item {
    @Id
    private String id;
    private String item_name;
    private String item_qty;
}
