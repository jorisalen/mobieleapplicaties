package com.example.vasq.dekikkersprong;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.vasq.dekikkersprong.src.facade.Facade;


public class Register extends Activity {
    private Facade facade = Facade.getInstance();
    private EditText naam, voornaam;
    private Button register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        naam = (EditText) findViewById(R.id.naam);
        voornaam = (EditText) findViewById(R.id.voornaam);
        register = (Button) findViewById(R.id.register);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_register, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void registreer(View view){

        facade.addKind(this.naam.getText().toString() ,this.voornaam.getText().toString(),1);

    }
}
