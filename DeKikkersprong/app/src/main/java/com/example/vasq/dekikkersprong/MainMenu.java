package com.example.vasq.dekikkersprong;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.vasq.dekikkersprong.src.facade.Facade;

import java.util.HashMap;


public class MainMenu extends Activity {
    private Facade facade = Facade.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

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
        Intent intent = new Intent(this,TweedeScherm.class);
        intent.putExtra("kinderen",kinderen);
        startActivity(intent);
    }

    public void klokIn(View view){
        Intent intent = new Intent(this,SimpleScannerActivity.class);
        startActivity(intent);
    }
}
