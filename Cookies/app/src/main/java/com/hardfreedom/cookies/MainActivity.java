package com.hardfreedom.cookies;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void eatCookie(View view) {
        ImageView image = findViewById(R.id.android_cookie_image_view);
        TextView text = findViewById(R.id.status_text_view);
        if (text.getText().equals("I'm so hungry")) {
            image.setImageResource(R.drawable.after_cookie);
            text.setText("I'm so full");
        } else {
            image.setImageResource(R.drawable.before_cookie);
            text.setText("I'm so hungry");
        }
    }
}
