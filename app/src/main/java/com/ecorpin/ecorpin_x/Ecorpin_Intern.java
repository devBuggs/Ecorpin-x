package com.ecorpin.ecorpin_x;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Ecorpin_Intern extends AppCompatActivity {
    //public static Button internButton;

    public static TextView internData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ecorpin__intern);

        InternFetch jsonProcess = new InternFetch();
        jsonProcess.execute();

        //internButton = (Button)findViewById(R.id.getInternButton);
        internData = (TextView)findViewById(R.id.dataPannel);
        /*
        internButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                InternFetch jsonProcess = new InternFetch();
                jsonProcess.execute();
            }
        });
        */
    }
}
