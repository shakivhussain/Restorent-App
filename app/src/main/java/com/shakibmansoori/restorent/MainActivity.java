package com.shakibmansoori.restorent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    int quantity = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitButton(View view) {

//        EditText nameField = findViewById(R.id.userInput);
//        String name = nameField.getText().toString();
//
//        CheckBox whipedCrreame = findViewById(R.id.chechBoxWiped);
//        boolean hasWippedCreame = whipedCrreame.isChecked();
//
//        CheckBox chocolate = findViewById(R.id.chechBoxChocolate);
//        boolean hasChocolate = chocolate.isChecked();
//
//        int price = priceCal(hasWippedCreame, hasChocolate);
//
//        String emailBody = orderSummary(name, price, hasChocolate, hasWippedCreame);
//
//        Intent intent = new Intent(Intent.ACTION_SENDTO);
//        intent.setData(Uri.parse("mailto:"));
//        intent.putExtra(Intent.EXTRA_SUBJECT, "Send By Shakib ");
//        intent.putExtra(Intent.EXTRA_TEXT, emailBody);
//        if (intent.resolveActivity(getPackageManager()) != null){
//            startActivity(intent);
//        }
//        displayMessag(orderSummary(name, price, hasChocolate, hasWippedCreame));

        String fs = summary();
        displayMessag(fs);
    }

    public void summaryButton(View view) {

        String bodyText = summary();

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_SUBJECT, "Send By Shakib ");
        intent.putExtra(Intent.EXTRA_TEXT, bodyText);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    private String summary() {

        EditText nameField = findViewById(R.id.userInput);
        String name = nameField.getText().toString();

        CheckBox whipedCrreame = findViewById(R.id.chechBoxWiped);
        boolean hasWippedCreame = whipedCrreame.isChecked();

        CheckBox chocolate = findViewById(R.id.chechBoxChocolate);
        boolean hasChocolate = chocolate.isChecked();

        int price = priceCal(hasWippedCreame, hasChocolate);

        return orderSummary(name, price, hasChocolate, hasWippedCreame);
    }


    private String orderSummary(String name, int price, boolean hasChocolate,
                                boolean hasWippedCreame) {

        String priceStr = getString(R.string.order_summary_name, name);
        priceStr += getString(R.string.order_summary_addwipped, hasWippedCreame);
        priceStr += getString(R.string.order_summary_addchocolate, hasChocolate);
        priceStr += getString(R.string.order_summary_quantity, quantity);
        priceStr += getString(R.string.order_summary_price, price);
        priceStr += getResources().getString(R.string.thank_you);

        return priceStr;

    }

    private void displayMessag(String str) {
        TextView textView = findViewById(R.id.orderSummaryTextView);
        textView.setText(str);
    }

    private void displayQuantity(int number) {
        TextView textView = (TextView) findViewById(R.id.quantity_text);
        textView.setText(String.valueOf(number));
    }

    public void increament(View view) {
        if (quantity == 12) {
            Toast.makeText(this, "Can't Order More Then 12 Coffee.", Toast.LENGTH_SHORT).show();
            return;
        }
        quantity += 1;
        displayQuantity(quantity);
    }

    public void decreament(View view) {
        if (quantity == 0) {
            Toast.makeText(this, "Can't Order Less Then 1 Coffee.", Toast.LENGTH_SHORT).show();
            return;
        }
        quantity -= 1;
        displayQuantity(quantity);
    }

    private int priceCal(boolean hasWippedCreame, boolean hasChocolate) {
//        int rs = quantity * todayprice;
//        return rs;
        int basePrice = 5;

        if (hasChocolate) {
            basePrice += 2;
        }
        if (hasWippedCreame) {
            basePrice += 1;
        }
        return quantity * basePrice;

    }

    public void next1(View view) {
        Intent intent = new Intent(getApplicationContext(),
                MainActivity2.class);
        startActivity(intent);
    }


}