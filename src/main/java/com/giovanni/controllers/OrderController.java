package com.giovanni.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.giovanni.entities.OrderEntity;
import com.giovanni.repositories.OrderRepository;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @PostMapping
    public ResponseEntity<OrderEntity> createOrder(@RequestBody OrderEntity order) {
        OrderEntity savedOrder = orderRepository.save(order);
        return new ResponseEntity<>(savedOrder, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<OrderEntity>> getAllOrder() {
        List<OrderEntity> orders = orderRepository.findAll();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderEntity> getItemById(@PathVariable Long id) {
        OrderEntity order = orderRepository.findById(id).orElse(null);
        if (order == null) {
            return new ResponseEntity<OrderEntity>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<OrderEntity>(order, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderEntity> updateOrder(@PathVariable Long id, @RequestBody OrderEntity updatedOrder) {
        OrderEntity order = orderRepository.findById(id).orElse(null);
        if (order == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        order.setName(updatedOrder.getName());
        order.setProductList(updatedOrder.getProductList());
        order.setCalories(updatedOrder.getCalories());

        OrderEntity savedOrder = orderRepository.save(order);
        return new ResponseEntity<OrderEntity>(savedOrder, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long id) {
        OrderEntity order = orderRepository.findById(id).orElse(null);
        if(order == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        orderRepository.delete(order);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}