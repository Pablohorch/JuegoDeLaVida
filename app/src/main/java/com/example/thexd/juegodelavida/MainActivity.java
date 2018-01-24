package com.example.thexd.juegodelavida;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.LinearLayout;

import static android.view.ViewGroup.LayoutParams.FILL_PARENT;
import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;
import static android.widget.LinearLayout.HORIZONTAL;

public class MainActivity extends AppCompatActivity {
    LinearLayout layoVerti;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layoVerti=(LinearLayout) findViewById(R.id.layoVerti);
        layoVerti.setOrientation(LinearLayout.VERTICAL);

        for (int i=0;i<10;i++){
            LinearLayout layoHori=new LinearLayout(this);
            layoHori.setOrientation(HORIZONTAL);
            layoHori.setLayoutParams(new LinearLayout.LayoutParams(MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));

            for (int e=0;e<10;e++){
                Button btnTag = new Button(this);
                btnTag.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
                btnTag.setText("");
                btnTag.setId((e*i));
                layoHori.addView(btnTag);
                setTitle("Pene"+(e*i));
                Log.e("Variables","Ocurre algo :" +i+ "-o a lo mejor ocurre algo en la e:"+e);
            }
            layoVerti.addView(layoHori);
        }
    }
}
