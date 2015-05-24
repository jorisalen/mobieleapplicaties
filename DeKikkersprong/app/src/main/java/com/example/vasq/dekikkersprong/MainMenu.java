package com.example.vasq.dekikkersprong;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.vasq.dekikkersprong.src.facade.Facade;

import java.util.HashMap;


public class MainMenu extends Activity {
    private Facade facade = Facade.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

       // Toast toast = Toast.makeText(getApplicationContext(),facade.isConnected() + "" ,Toast.LENGTH_LONG);
        //toast.show();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_menu, menu);
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
    public void toonOverzicht(View view){
        HashMap<String, String> kinderen = facade.toonOverzicht();
        Intent intent = new Intent(this,Overzicht.class);
        intent.putExtra("kinderen",kinderen);
        startActivity(intent);
    }

    public void klokIn(View view){
        Intent intent = new Intent(this,SimpleScannerActivity.class);
        intent.putExtra("functie", "klokin");
        startActivity(intent);
    }
    public void klokUit(View view){
        Intent intent = new Intent(this,SimpleScannerActivity.class);
        intent.putExtra("functie", "klokuit");
        startActivity(intent);
    }

    public void genereerFactuur(View v){
        Intent intent = new Intent(this,SimpleScannerActivity.class);
        intent.putExtra("functie", "factuur");
        startActivity(intent);
    }

    public void registreerKind(View view){
        Intent intent = new Intent(this, Register.class);
        startActivity(intent);
    }
}
