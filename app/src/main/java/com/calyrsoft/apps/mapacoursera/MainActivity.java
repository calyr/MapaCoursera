package com.calyrsoft.apps.mapacoursera;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showMap(View view) {
        Intent i = new Intent(this, MapsActivity.class);

        if( view.getId() == R.id.imageButton){
            i.putExtra("seleccion", 0);
        }else if( view.getId() == R.id.imageButton2){
            i.putExtra("seleccion", 3);
        }else if( view.getId() == R.id.imageButton3){
            i.putExtra("seleccion", 1);
        }else{
            i.putExtra("seleccion", 2);
        }
        startActivity(i);
    }
}
