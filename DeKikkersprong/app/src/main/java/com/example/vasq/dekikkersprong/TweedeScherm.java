package com.example.vasq.dekikkersprong;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.vasq.dekikkersprong.src.MyAdaptor;
import com.example.vasq.dekikkersprong.src.domain.Verblijf;

import java.util.HashMap;


public class TweedeScherm extends Activity {
    private HashMap<String,Verblijf> kinderen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tweede_scherm);
        kinderen = (HashMap<String,Verblijf>) getIntent().getExtras().get("kinderen");

        ListView listviewKinderen =(ListView)findViewById(R.id.listviewKinderen);
        MyAdaptor adaptor = new MyAdaptor(kinderen);
        listviewKinderen.setAdapter(adaptor);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tweede_scherm, menu);
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


}
