package com.hardfreedom.coffee;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int quantity;
    private int price;
    private String addWhipped = "";
    private String addChocolate = "";

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
        CheckBox whipping = findViewById(R.id.check_whipped);
        if (whipping.isChecked()) {
            checkAddings("whipping");
        }
        CheckBox chocolate = findViewById(R.id.check_chocolate);
        if (chocolate.isChecked()) {
            checkAddings("chocolate");
        }
        if (addWhipped != "" && addChocolate != "") {
            displayMessage("Black coffee\n" + addWhipped + "\n" + addChocolate +"\nQuantity: "
                    + quantity + "\nTotal: " + price + " EUR\nThank you!");
        } else if (addChocolate != "") {
            displayMessage("Black coffee\n" + addChocolate +"\nQuantity: " + quantity +
                    "\nTotal: " + price + " EUR\nThank you!");
        } else if (addWhipped != "") {
            displayMessage("Black coffee\n" + addWhipped +"\nQuantity: " + quantity +
                    "\nTotal: " + price + " EUR\nThank you!");
        } else {
            displayMessage("Black coffee" +"\nQuantity: " + quantity +
                    "\nTotal: " + price + " EUR\nThank you!");
        }
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
        getPrice();
        displayPrice(price);
    }

    private int getPrice() {
        return price = quantity * price;
    }

    private void checkAddings(String adding) {
        if (adding.equals("whipping")) {
            addWhipped = addWhipped + "Add whipped cream";
        } else {
            addChocolate = addChocolate + "Add chocolate";
        }
        price = price + 1 * quantity;
    }
}