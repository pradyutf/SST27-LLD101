package com.example.orders;

import java.util.ArrayList;
import java.util.List;

/**
 * Telescoping constructors + setters. Allows invalid states.
 */
public final class Order {
    private final String id;
    private final String customerEmail;
    private final List<OrderLine> lines = new ArrayList<>();
    private final Integer discountPercent; // 0..100 expected, but not enforced
    private final boolean expedited;
    private final String notes;

    // public Order(String id, String customerEmail) {
    //     this.id = id;
    //     this.customerEmail = customerEmail;
    // }

    // public Order(String id, String customerEmail, Integer discountPercent) {
    //     this(id, customerEmail);
    //     this.discountPercent = discountPercent;
    // }

    private Order (OrderBuilder OrderBuilder){
        this.id = OrderBuilder.id; // required
        this.customerEmail = OrderBuilder.customerEmail; // required
        this.lines.addAll(OrderBuilder.lines); // at least one required
        this.discountPercent = OrderBuilder.discountPercent;
        this.expedited = OrderBuilder.expedited;
        this.notes = OrderBuilder.notes;
    }

    public static class OrderBuilder{
        private String id;
        private String customerEmail;
        private final List<OrderLine> lines = new ArrayList<>();
        private Integer discountPercent; // 0..100 expected, but not enforced
        private boolean expedited;
        private String notes;
        

        public OrderBuilder (String id, String customerEmail,  List<OrderLine> lines){
            this.id = id;
            this.customerEmail = customerEmail;
            this.lines.addAll(lines);
        }
        public OrderBuilder discountPercent(Integer discountPercent){
            this.discountPercent = discountPercent;
            return this;
        }
        public OrderBuilder expedited(boolean expedited){
            this.expedited = expedited;
            return this;
        }
        public OrderBuilder notes(String notes){
            this.notes = notes;
            return this;
        }
        public Order build(){

            //validate if id, customerEmail and lines are not null
            if (PricingRules.isValidEmail(customerEmail) == false){
                throw new IllegalStateException("Invalid email format");
            }
            if (PricingRules.isValidDiscount(discountPercent) == false){
                throw new IllegalStateException("Invalid discount percent");
            }
            if (id == null || customerEmail == null || lines.isEmpty()){
                throw new IllegalStateException("id, customerEmail and at least one OrderLine are required");
            }
            return new Order(this);
        }
    }


    // should be externally immutable


   // public void addLine(OrderLine line) { lines.add(line); }
   // public void setDiscountPercent(Integer discountPercent) { this.discountPercent = discountPercent; }
   // public void setExpedited(boolean expedited) { this.expedited = expedited; }
   // public void setNotes(String notes) { this.notes = notes; }

    public String getId() { return id; }
    public String getCustomerEmail() { return customerEmail; }

    // Defensive copy to prevent external mutation
    // public List<OrderLine> getLines() { return lines; } // leaks internal list
    public List<OrderLine> getLines() { return new ArrayList<>(lines); } // defensive copy

    public Integer getDiscountPercent() { return discountPercent; }
    public boolean isExpedited() { return expedited; }
    public String getNotes() { return notes; }

    public int totalBeforeDiscount() {
        int sum = 0;
        for (OrderLine l : lines) sum += l.getQuantity() * l.getUnitPriceCents();
        return sum;
    }

    public int totalAfterDiscount() {
        int base = totalBeforeDiscount();
        if (discountPercent == null) return base;
        return base - (base * discountPercent / 100);
    }
}
