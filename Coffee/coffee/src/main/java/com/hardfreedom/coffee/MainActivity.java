package com.hardfreedom.coffee;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int quantity = 1;
    private int price = 2;
    private String addWhipped = "";
    private String addChocolate = "";
    private String name = "";
    private EditText nameValue;
    private TextView headerOrderSummary;
    private TextView priceTextView;
    private CheckBox whipping;
    private CheckBox chocolate;
    private Button order;
    private Button reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void increment(View view) {
        quantity++;
        price = price + 2;
        displayQuantity(quantity);
    }

    public void decrement(View view) {
        if (quantity != 1) {
            quantity--;
            price = price - 2;
        }
        displayQuantity(quantity);
    }

    public void orderSummaryTextView(View view) {
        getNameAndAddings();
        if (!addWhipped.equals("") && !addChocolate.equals("")) {
            displayOrder(getString(R.string.user_name, name)
                    + "\n" + getString(R.string.black_coffee) + "\n"
                    + addWhipped + "\n" + addChocolate + "\n" + getString(R.string.quantity, quantity)
                    + "\n" + getString(R.string.total, price));
        } else if (!addChocolate.equals("")) {
            displayOrder(getString(R.string.user_name, name)
                    + "\n" + getString(R.string.black_coffee) + "\n"
                    + addChocolate + "\n" + getString(R.string.quantity, quantity)
                    + "\n" + getString(R.string.total, price));
        } else if (!addWhipped.equals("")) {
            displayOrder(getString(R.string.user_name, name)
                    + "\n" + getString(R.string.black_coffee) + "\n"
                    + addWhipped + "\n" + getString(R.string.quantity, quantity)
                    + "\n" + getString(R.string.total, price));
        } else {
            displayOrder(getString(R.string.user_name, name)
                    + "\n" + getString(R.string.black_coffee)
                    + "\n" + getString(R.string.quantity, quantity)
                    + "\n" + getString(R.string.total, price));
        }
    }

    public void resetOrder(View view) {
        quantity = 1;
        price = 2;
        addWhipped = "";
        addChocolate = "";
        nameValue.getText().clear();
        headerOrderSummary.setVisibility(View.GONE);
        priceTextView.setVisibility(View.GONE);
        if (whipping.isChecked()) {
            whipping.toggle();
        }
        if (chocolate.isChecked()) {
            chocolate.toggle();
        }
        order.setVisibility(View.VISIBLE);
        order.setEnabled(true);
        reset.setVisibility(View.INVISIBLE);
    }

    private void getNameAndAddings() {
        nameValue = findViewById(R.id.name);
        name = nameValue.getText().toString();
        whipping = findViewById(R.id.check_whipped);
        if (whipping.isChecked()) {
            checkAddings("whipping");
            price = price + quantity;
        }
        chocolate = findViewById(R.id.check_chocolate);
        if (chocolate.isChecked()) {
            checkAddings("chocolate");
            price = price + quantity;
        }
    }

    private void displayQuantity(int quantity) {
        TextView quantityTextView = findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + quantity);
    }

    private void displayOrder(String orderDetails) {
        showOrderVisuals();
        priceTextView.setText(orderDetails);
        Emailing e = new Emailing(this);
        e.sentEmailForOrder(orderDetails, "ivairus@group.lt", "Coffee Order");
    }

    private void showOrderVisuals() {
        headerOrderSummary = findViewById(R.id.order_summary_text_view);
        headerOrderSummary.setVisibility(View.VISIBLE);
        priceTextView = findViewById(R.id.order_summary);
        priceTextView.setVisibility(View.VISIBLE);
        order = findViewById(R.id.button_order);
        order.setEnabled(false);
        reset = findViewById(R.id.button_reset);
        reset.setVisibility(View.VISIBLE);
    }

    private void checkAddings(String adding) {
        if (adding.equals("whipping")) {
            addWhipped = addWhipped + getString(R.string.add_whipped);
        } else {
            addChocolate = addChocolate + getString(R.string.add_chocolate);
        }
    }
}