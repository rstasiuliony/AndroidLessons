package com.hardfreedom.coffee;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int quantity;
    private int price = 2;
    private String addWhipped = "";
    private String addChocolate = "";
    private String name = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView initialQuantity = findViewById(R.id.quantity_text_view);
        quantity = Integer.parseInt(initialQuantity.getText().toString());
    }

    public void increment(View view) {
        quantity++;
        price = price + 2;
        displayQuantity(quantity);
    }

    public void decrement(View view) {
        if (quantity != 0) {
            quantity--;
            price = price - 2;
        }
        displayQuantity(quantity);
    }

    public void orderSummaryTextView(View view) {

        getNameAndAddings();

        if (addWhipped != "" && addChocolate != "") {
            displayMessage("Name: " + name + "\nBlack coffee\n" + addWhipped + "\n" + addChocolate +"\nQuantity: "
                    + quantity + "\nTotal: " + price + " EUR\nThank you!");
        } else if (addChocolate != "") {
            displayMessage("Name: " + name + "\nBlack coffee\n" + addChocolate +"\nQuantity: " + quantity +
                    "\nTotal: " + price + " EUR\nThank you!");
        } else if (addWhipped != "") {
            displayMessage("Name: " + name + "\nBlack coffee\n" + addWhipped +"\nQuantity: " + quantity +
                    "\nTotal: " + price + " EUR\nThank you!");
        } else {
            displayMessage("Name: " + name + "\nBlack coffee" +"\nQuantity: " + quantity +
                    "\nTotal: " + price + " EUR\nThank you!");
        }
    }

    private void getNameAndAddings() {
        EditText nameValue = findViewById(R.id.name);
        name = nameValue.getText().toString();

        CheckBox whipping = findViewById(R.id.check_whipped);
        if (whipping.isChecked()) {
            checkAddings("whipping");
            price = price + quantity;
        }
        CheckBox chocolate = findViewById(R.id.check_chocolate);
        if (chocolate.isChecked()) {
            checkAddings("chocolate");
            price = price + quantity;
        }
    }

    private void displayQuantity(int quantity) {
        TextView quantityTextView = findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + quantity);
    }

    private void displayMessage(String message) {
        TextView headerOrderSummary = findViewById(R.id.order_summary_text_view);
        headerOrderSummary.setVisibility(View.VISIBLE);
        TextView priceTextView = findViewById(R.id.order_summary);
        priceTextView.setVisibility(View.VISIBLE);
        priceTextView.setText(message);
    }

    private void checkAddings(String adding) {
        if (adding.equals("whipping")) {
            addWhipped = addWhipped + "Add whipped cream";
        } else {
            addChocolate = addChocolate + "Add chocolate";
        }
    }
}