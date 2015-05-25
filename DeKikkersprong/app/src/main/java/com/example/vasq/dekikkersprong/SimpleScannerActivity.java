package com.example.vasq.dekikkersprong;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.vasq.dekikkersprong.src.facade.Facade;
import com.google.zxing.Result;

import java.io.InputStream;
import java.util.Scanner;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class SimpleScannerActivity extends Activity implements ZXingScannerView.ResultHandler {
    private ZXingScannerView mScannerView;
    private Facade facade = Facade.getInstance();
    @Override
    public void onCreate(Bundle state) {
        super.onCreate(state);
        mScannerView = new ZXingScannerView(this);   // Programmatically initialize the scanner view
        setContentView(mScannerView);                // Set the scanner view as the content view
    }

    @Override
    public void onResume() {
        super.onResume();
        mScannerView.setResultHandler(this); // Register ourselves as a handler for scan results.
        mScannerView.startCamera();          // Start camera on resume
    }

    @Override
    public void onPause() {
        super.onPause();
        mScannerView.stopCamera();           // Stop camera on pause
    }

    @Override
    public void handleResult(Result rawResult) {
        // Do something with the result here
        //Toast toast = new Toast(rawResult.getText());
        Context context = getApplicationContext();
        CharSequence text = rawResult.getText();
        int duration = Toast.LENGTH_LONG;
        Scanner stream = new Scanner(text.toString());
        stream.useDelimiter(";");
        String kindId = stream.next();
        String naam = stream.next();
        Intent intent = new Intent(this, MainMenu.class);
        if(getIntent().getExtras().get("functie").equals("klokin")){
            String welkom = getString(R.string.welkom) + " " +  naam;
            boolean succes = facade.klokIn(Integer.parseInt(kindId));

            if(succes){
                Toast toast = Toast.makeText(context,welkom ,duration);
                toast.show();

            } else {
                Toast toast = Toast.makeText(context,naam + " " + getString(R.string.nietWelkom)  ,duration);
                toast.show();

            }

        } else if (getIntent().getExtras().get("functie").equals("klokuit")){
            String dag = getString(R.string.dag) + " " +  naam;
            boolean succes = facade.klokUit(Integer.parseInt(kindId));

            if(succes){
                Toast toast = Toast.makeText(context,dag ,duration);
                toast.show();

            } else {
                Toast toast = Toast.makeText(context,naam + " " + getString(R.string.alUit)  ,duration);
                toast.show();

            }
        } else if (getIntent().getExtras().get("functie").equals("factuur")){
            if (Integer.parseInt(kindId) < 0){
                Toast toast = Toast.makeText(context,"Genereren",duration);
                toast.show();
            }else{
                Toast toast = Toast.makeText(context,"Je hebt de machtigingen niet !",duration);
                toast.show();
            }
        } else if (getIntent().getExtras().get("functie").equals("overzichtAanwezigheden")){
            intent = new Intent(this,Overzicht.class);
            intent.putExtra("overzicht",facade.toonOverzicht(Integer.parseInt(kindId)));
        }
        stream.close();
        startActivity(intent);
    }
}