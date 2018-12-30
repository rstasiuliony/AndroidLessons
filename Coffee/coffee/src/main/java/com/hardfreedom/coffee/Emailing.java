package com.hardfreedom.coffee;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

public class Emailing {

    private Context context;

    public Emailing(Context context) {
        this.context = context;
    }

    public void sentEmailForOrder(String message, String email, String subject) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.fromParts("mailto", email, null));
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, message);
        try {
            context.startActivity(Intent.createChooser(intent, "Choose an Email client:"));
        } catch (ActivityNotFoundException ex) {
            Toast.makeText(context, "No email clients installed.", Toast.LENGTH_SHORT).show();
        }
    }
}
