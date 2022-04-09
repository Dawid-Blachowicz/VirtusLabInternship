package com.virtuslab.internship.model.receipt;

import com.virtuslab.internship.model.basket.Basket;
import com.virtuslab.internship.model.discount.TotalDiscount;
import com.virtuslab.internship.model.product.Product;

import java.util.ArrayList;
import java.util.List;

public class ReceiptGenerator {

    public Receipt generate(Basket basket) {
        List<ReceiptEntry> receiptEntries = new ArrayList<>();

        ReceiptEntry newEntry;

        for(Product product : basket.getProducts()) {
            boolean isAlreadyInTheBasket = false;
            int multipliedProductIndex = 0;

            for(ReceiptEntry entry : receiptEntries){
                if(entry.product().equals(product)){
                    isAlreadyInTheBasket = true;
                    multipliedProductIndex = receiptEntries.indexOf(entry);
                    break;
                }
            }

            if(isAlreadyInTheBasket) {
                var quantity = receiptEntries.get(multipliedProductIndex).quantity();
                receiptEntries.remove(multipliedProductIndex);
                newEntry = new ReceiptEntry(product, quantity + 1);
            }
            else {
                newEntry = new ReceiptEntry(product, 1);
            }
            receiptEntries.add(newEntry);

        }

        var discount = new TotalDiscount();

        return discount.apply(new Receipt(receiptEntries));
    }
}
