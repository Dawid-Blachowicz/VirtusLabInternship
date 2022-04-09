package com.virtuslab.internship.model.discount;

import com.virtuslab.internship.model.receipt.Receipt;

public class TotalDiscount {

    public Receipt apply(Receipt receipt) {
        var fifteenPercentDiscount = new FifteenPercentDiscount();
        var receiptAfter15PercentDiscount = fifteenPercentDiscount.apply(receipt);

        var tenPercentDiscount  = new TenPercentDiscount();

        return tenPercentDiscount.apply(receiptAfter15PercentDiscount);
    }
}
