package com.amsa.shake;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Accelerometer accelerometer;
    private Gyroscope gyroscope;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        accelerometer =new Accelerometer(this);
        gyroscope = new Gyroscope(this);

        accelerometer.setListener(new Accelerometer.Listener() {
            @Override
            public void onTranslation(float tx, float ty, float tz) {

                if(tx > 1.0f)
                {
                    System.out.println("yyyyyyyyy");
                    getWindow().getDecorView().setBackgroundColor(Color.RED);
                    Toast.makeText(getApplicationContext(),"Right",Toast.LENGTH_LONG).show();
                }
                else if(tx < -1.0f)
                {
                    getWindow().getDecorView().setBackgroundColor(Color.BLUE);
                    System.out.println("yyyyyyyyy");
                    Toast.makeText(getApplicationContext(),"Left",Toast.LENGTH_LONG).show();

                }
            }
        });

        gyroscope.setListener(new Gyroscope.Listener() {
            @Override
            public void onRotation(float rx, float ry, float rz) {

                if(rz > 1.0f)
                {
                    getWindow().getDecorView().setBackgroundColor(Color.GREEN);
                    System.out.println("yyyyyyyyy");
                    Toast.makeText(getApplicationContext(),"Far",Toast.LENGTH_LONG).show();
                }
                else if(rz < -1.0f)
                {
                    getWindow().getDecorView().setBackgroundColor(Color.YELLOW);
                    System.out.println("yyyyyyyyy");
                    Toast.makeText(getApplicationContext(),"Near",Toast.LENGTH_LONG).show();

                }
            }
        });
    }

    protected void onResume(){
        super.onResume();

        accelerometer.register();
        gyroscope.register();

    }

    protected void onPause() {
        super.onPause();

        accelerometer.unregister();
        gyroscope.unregister();

    }
}
