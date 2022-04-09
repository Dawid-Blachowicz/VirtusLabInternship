package com.virtuslab.internship.controller;

import com.virtuslab.internship.model.product.Product;
import com.virtuslab.internship.model.receipt.Receipt;
import com.virtuslab.internship.service.BasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
public class BasketController {

    @Autowired
    private BasketService basketService;

    @PostMapping("/baskets/1/products")
    public void addProduct(@RequestBody String productName) {
        basketService.addProduct(productName);
    }

    @GetMapping("/baskets")
    public List<Product> getBasket() {
        return basketService.getBasket();
    }

    @GetMapping("/products")
    public Set<Product> getProductDb() {
        return basketService.getProductDb();
    }

    @GetMapping("/receipts")
    public Receipt getReceipt() {
        return basketService.getReceipt();
    }

    @DeleteMapping("/baskets/1")
    public void removeProductFromBasket(@RequestBody String productName) {
        basketService.removeProductFromBasket(productName);
    }

}
