package com.reso.coffeetime;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements
        AdapterView.OnItemSelectedListener {
    String[] coffee = { "Cappuccino", "Espresso", "Affogato", "Doubleespresso", "Freakshake", "IcedLatte", "LatteMacchiato", "Irishcoffee", "IcedMocha"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Getting the instance of Spinner and applying OnItemSelectedListener on it
        Spinner spin = (Spinner) findViewById(R.id.spinner);
        spin.setOnItemSelectedListener(this);

        //Creating the ArrayAdapter instance having the country list
        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,coffee);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spin.setAdapter(aa);


    } int quantity = 2;

    /**
     * This method is called when the plus button is clicked.
     */
    public void increment(View view) {

        //
        if (quantity == 100) {
            //show an error as a toast
            Toast.makeText(this,"You cannot have more than 100 Coffee", Toast.LENGTH_SHORT).show();
            //exit the method early because there is nothing left to
            return;
        }
        quantity = quantity + 1;
        display( quantity);

    }
    /**
     * This method is called when the minus button is clicked.
     */
    public void decrement(View view) {

        if (quantity == 1){
            //Show an Error as a toast
            Toast.makeText(this, "You cannot have less than 1 coffee", Toast.LENGTH_SHORT).show();
            //exit the method early because there is nothing left to do
            return;
        }
        quantity = quantity - 1;
        display( quantity);

    }
    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

int cost=0;
    int total=0;
    String totale;
    //Performing action onItemSelected and onNothing selected
    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
        EditText text = (EditText) findViewById(R.id.order_summary_text_view);
        switch (position){
            case 0:
               cost =2;
               total=(cost*quantity);
                 totale = String.valueOf(total);
                text.setText(totale);
                break;

            case 1:
                cost =3;
                total=(cost*quantity);
                 totale = String.valueOf(total);
                text.setText(totale);
                break;

            case 2:
                cost = 3;
                total=(cost*quantity);
                 totale = String.valueOf(total);
                text.setText(totale);
                break;

            case 3:
                cost =4;
                total=(cost*quantity);
                 totale = String.valueOf(total);
                text.setText(totale);
                break;
            case 4:
                cost =5;
                total=(cost*quantity);
                totale = String.valueOf(total);
                text.setText(totale);
                break;
            case 5:
                cost =5;
                total=(cost*quantity);
                totale = String.valueOf(total);
                text.setText(totale);
                break;
            case 6:
                cost =5;
                total=(cost*quantity);
                totale = String.valueOf(total);
                text.setText(totale);
                break;
            case 7:
                cost =10;
                total=(cost*quantity);
                totale = String.valueOf(total);
                text.setText(totale);
                break;
            case 8:
                cost =8;
                total=(cost*quantity);
                totale = String.valueOf(total);
                text.setText(totale);
                break;



        }

    }
    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }



    public void order(View view){
        Button send;
        EditText nameEditText = findViewById(R.id.til_name);
        String Name = nameEditText.getText().toString();
        send=(Button)findViewById(R.id.button);
        EditText addressEditText = findViewById(R.id.til_email);
        String address = addressEditText.getText().toString();

        EditText dateEditText = findViewById(R.id.til_psw);
        String date = dateEditText.getText().toString();

        EditText timeEditText = findViewById(R.id.tiedit_conpsw);
        String time = timeEditText.getText().toString();
        EditText text = (EditText) findViewById(R.id.order_summary_text_view);

        int Quantity = quantity;

        int totalPrice = total;

        String message = "Name: "+ Name +
                "\nAddress " + address +
                "\nDate ? " + date +
                "\nQuantity: " + Quantity +
                "\nTotal: " + NumberFormat.getCurrencyInstance(Locale.US)
                .format(totalPrice) +
                "\nThank you!";

        Log.i("Info", message);



    }


}



