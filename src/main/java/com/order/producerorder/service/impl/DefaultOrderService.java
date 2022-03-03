package com.order.producerorder.service.impl;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.order.producerorder.model.Orders;
import com.order.producerorder.repo.OrderRepository;
import com.order.producerorder.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class DefaultOrderService implements OrderService {
    //List<Weather> list=new LinkedList<>();

    @Value("${url.to.consumer}")
    private String url;

    private OrderRepository orderRepository;
    private RestTemplate restTemplate;
    private ObjectMapper objectMapper;
    private List<Orders> ordersList;

    @Autowired
    public DefaultOrderService(OrderRepository orderRepository, RestTemplate restTemplate, ObjectMapper objectMapper, List<Orders> ordersList){
        this.orderRepository = orderRepository;
        this.restTemplate=restTemplate;
        this.objectMapper=objectMapper;
        this.ordersList=ordersList;
    }

    @Override
    public boolean createOrders(Orders orders) throws JsonProcessingException {

        return restTemplate.postForObject(url+"/createOrder", orders, boolean.class);

    }

    @Override
    public List<Orders> getAllOrders() {
        //List<Orders> ordersList= (List<Orders>) orderRepository.findAll();
        return restTemplate.getForObject(url+"/getOrder", ordersList.getClass());
    }

    @Override
    public Orders getOrdersById(String id) {
        return restTemplate.postForObject(url+"/getById", id,Orders.class);
    }

    @Override
    public List<Orders> getOrdersByZip(int zip) {
        return restTemplate.postForObject(url+"/getByzip", zip, ordersList.getClass());
    }

    @Override
    public Orders cancelOrder(String id) {
        return restTemplate.postForObject(url+"/cancel", id,Orders.class);
    }
}
