package com.hardfreedom.coffee;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int quantity;
    private int price;
    private int finalPrice = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView initialQuantity = findViewById(R.id.quantity_text_view);
        quantity = Integer.parseInt(initialQuantity.getText().toString());

        TextView pricePerOne = findViewById(R.id.price_text_view);
        price = Integer.parseInt(pricePerOne.getText().toString());
    }

    public void increment(View view) {
        quantity++;
        displayDefaults();
    }

    public void decrement(View view) {
        if (quantity != 0) {
            quantity--;
        }
        displayDefaults();
    }

    public void orderSummaryTextView(View view) {
        displayMessage("Name: Renata\nQuantity: " + quantity +
                "\nTotal: " + finalPrice + " EUR\nThank you!");
    }

    private void displayQuantity(int quantity) {
        TextView quantityTextView = findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + quantity);
    }

    private void displayPrice(int price) {
        TextView priceTextView = findViewById(R.id.price_text_view);
        priceTextView.setText("" + price);
    }

    private void displayMessage(String message) {
        LinearLayout priceView = findViewById(R.id.price);
        priceView.setVisibility(View.GONE);
        TextView headerOrderSummary = findViewById(R.id.order_summary_text_view);
        headerOrderSummary.setVisibility(View.VISIBLE);
        TextView priceTextView = findViewById(R.id.order_summary);
        priceTextView.setVisibility(View.VISIBLE);
        priceTextView.setText(message);
    }

    private void displayDefaults() {
        displayQuantity(quantity);
        getFinalPrice();
        displayPrice(finalPrice);
    }

    private int getFinalPrice() {
        return finalPrice = quantity * price;
    }
}