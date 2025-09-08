package com.example.payments;

public class FastPayAdapter implements PaymentGateway{
    FastPayClient client;

    public FastPayAdapter(FastPayClient client) {
        this.client = client;
    }

    @Override
    public String charge(String customerId, int amountCents) {
        // Adapt the method call to the FastPayClient's method
        return client.payNow(customerId, amountCents);
        
    }

    
}
