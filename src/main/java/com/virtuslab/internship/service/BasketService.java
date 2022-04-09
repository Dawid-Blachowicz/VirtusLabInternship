package com.virtuslab.internship.service;

import com.virtuslab.internship.model.basket.Basket;
import com.virtuslab.internship.model.product.Product;
import com.virtuslab.internship.model.product.ProductDb;
import com.virtuslab.internship.model.receipt.Receipt;
import com.virtuslab.internship.model.receipt.ReceiptGenerator;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class BasketService {

    private Basket basket;
    private ProductDb productDb;

    public BasketService() {basket = new Basket(); productDb = new ProductDb();}

    public void addProduct(String productName) {
        basket.addProduct(productDb.getProduct(productName));
    }

    public List<Product> getBasket() {
        return basket.getProducts();
    }

    public Set<Product> getProductDb() {
        return productDb.getAllProducts();
    }

    public Receipt getReceipt() {
        ReceiptGenerator receiptGenerator = new ReceiptGenerator();
        return receiptGenerator.generate(basket);
    }

    public void removeProductFromBasket(String productName) {
        basket.remmoveProduct(productDb.getProduct(productName));
    }

}
