package com.example.question.service;

import com.example.question.entity.Order;
import com.example.question.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrderService {

    private final OrderRepository orderRepository;      //@Autowired

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }


    public Order save(Order order) {   //save method
        return orderRepository.save(order);
    }

    public List<Order> findAll() {      // Listenin hepsini getirme
        return orderRepository.findAll();
    }

    public void addOrder(int siparis, int malNumarasi, int miktar, double birimFiyat) {  // verilen örnek taplonun eklenmesi
        Order order = new Order(siparis, malNumarasi, miktar, birimFiyat);
        orderRepository.save(order);
    }

    public double totalPrice() {            // Answer 1
        List<Order> orders = orderRepository.findAll();
        double totalPrice = 0;
        for (Order order : orders) {
            totalPrice += order.getBirimFiyat() * order.getMiktar();
        }

        return totalPrice;
    }

    public double averagePrice() {          // Answer 2
        List<Order> orders = orderRepository.findAll();
        double totalPrice = 0;
        double getMiktar = 0;
        for (Order order : orders) {
            totalPrice += order.getBirimFiyat() * order.getMiktar();
            getMiktar += order.getMiktar();

        }

        return totalPrice / getMiktar;
    }

    public double averagePriceByMalNumarasi(long malNumarasi) {         // Answer 3
        List<Order> orders = orderRepository.findAll();
        double totalPrice = 0;
        double miktar = 0;
        for (Order order : orders) {
            if (order.getMalNumarasi() == malNumarasi) {
                totalPrice += order.getBirimFiyat() * order.getMiktar();
                miktar += order.getMiktar();
            }
        }

        return totalPrice / miktar;
    }

    public Map<Integer, List<Order>> groupOrdersByMalNo() {         // Answer 4
        List<Order> orders = orderRepository.findAll();
        Map<Integer, List<Order>> malNumarasiGruplari = new HashMap<>();

        for (Order order : orders) {
            long malNumarasi = order.getMalNumarasi();
            malNumarasiGruplari.computeIfAbsent((int) malNumarasi, key -> new ArrayList<>()).add(order);
        }

        return malNumarasiGruplari;
    }

}
