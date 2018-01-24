package com.example.thexd.juegodelavida;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.GridLayout;
import android.widget.LinearLayout;

import java.util.ArrayList;

import static android.view.ViewGroup.LayoutParams.FILL_PARENT;
import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;
import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;
import static android.widget.LinearLayout.HORIZONTAL;

public class MainActivity extends AppCompatActivity {
    GridLayout layout;
    ArrayList<CheckBox> almacen=new ArrayList<CheckBox>();
    Boolean juegoComineza=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layout=(GridLayout) findViewById(R.id.layo);

            for (int e=0;e<(layout.getColumnCount()*layout.getRowCount());e++){
                CheckBox chec = new CheckBox(this);
                chec.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
                chec.setText("");
                chec.setId((e));
                almacen.add(chec);
                layout.addView(chec);
            }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.start) {
            juegoComineza=true;


                for (int i =1;i<almacen.size()-1;i++) {
                    int con=0;
                    if (almacen.get(i-1).isChecked())
                        con++;
                    if (almacen.get(i+1).isChecked())
                        con++;
                    if (layout.getColumnCount()<i){
                    if (almacen.get(i-layout.getColumnCount()).isChecked())
                        con++;}
                    if(i<(almacen.size()-layout.getColumnCount())){
                    if (almacen.get(i+layout.getColumnCount()).isChecked())
                        con++;}

                    if (!(almacen.get(i).isChecked()) && con>=3){
                        almacen.get(i).setChecked(true);
                    }else if(almacen.get(i).isChecked() && con>=2){}else{almacen.get(i).setChecked(false);}


            }
        }

        if (id == R.id.stop) {
            juegoComineza=false;
        }

        if (id == R.id.limpi) {
            for (int i =0;i<almacen.size();i++){
                almacen.get(i).setChecked(false);
            }
        }
        return super.onOptionsItemSelected(item);
    }

}
