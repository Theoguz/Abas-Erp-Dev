package com.example.question.controller;

import com.example.question.entity.Order;
import com.example.question.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }


    @GetMapping                 // Tüm siparişlerin listelenmesi
    public List<Order> GetAll() {
        return orderService.findAll();
    }

    @PostMapping("/add")            // Sipariş eklenmesi
    public Order addOrder(@RequestBody Order order) {
        return orderService.save(order);
    }


    @PostMapping("/add-all")
    public ResponseEntity<String> addOrders() {    // verilen örnek taplonun eklenmesi - sample data

        try {
            orderService.addOrder(1000, 2000, 12, 100.51);
            orderService.addOrder(1000, 2001, 31, 200.0);
            orderService.addOrder(1000, 2002, 22, 150.86);
            orderService.addOrder(1000, 2003, 41, 250.0);
            orderService.addOrder(1000, 2004, 55, 244.0);
            orderService.addOrder(1001, 2001, 88, 44.531);
            orderService.addOrder(1001, 2002, 121, 88.11);
            orderService.addOrder(1001, 2004, 74, 211.0);
            orderService.addOrder(1001, 2002, 14, 88.11);
            orderService.addOrder(1002, 2003, 2, 12.1);
            orderService.addOrder(1002, 2004, 3, 22.3);
            orderService.addOrder(1002, 2003, 8, 12.1);
            orderService.addOrder(1002, 2002, 16, 94.0);
            orderService.addOrder(1002, 2005, 9, 44.1);
            orderService.addOrder(1002, 2006, 19, 90.0);

            return ResponseEntity.ok("Orders added successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error adding orders.");
        }
    }

        @GetMapping("/total-price")     // total price method
        public double totalPrice () {
            return orderService.totalPrice();
        }

        @GetMapping("/average-price")   // average price method
        public double averagePrice () {
            return orderService.averagePrice();
        }

        @GetMapping("/average-price/{malNumarasi}")   // average price by malNumarasi
        public double averagePriceBySiparis ( @PathVariable int malNumarasi){
            return orderService.averagePriceByMalNumarasi(malNumarasi);
        }

        @GetMapping("/newlist")           //grouped by MalNumarasi
        public Map<Integer, List<Order>> groupOrdersNewList () {
            return orderService.groupOrdersByMalNo();
        }

    }
