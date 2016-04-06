package com.colt.android021_sqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText inputText;
    TextView displayText;
    DataBaseHandler dataBaseHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputText = (EditText) findViewById(R.id.inputText);
        displayText = (TextView) findViewById(R.id.displayText);
        dataBaseHandler = new DataBaseHandler(this, null, null, 1);
        printDatabase();
    }

    public void addButtonClicked(View view) {
        Products product = new Products(inputText.getText().toString());
        dataBaseHandler.addProduct(product);
        printDatabase();
    }

    public void deleteButtonClicked(View view) {
        String productToDelete = inputText.getText().toString();
        dataBaseHandler.deleteProduct(productToDelete);
        printDatabase();
    }

    public void printDatabase() {
        String dbString = dataBaseHandler.databaseToString();
        displayText.setText(dbString);
        inputText.setText("");
    }

}