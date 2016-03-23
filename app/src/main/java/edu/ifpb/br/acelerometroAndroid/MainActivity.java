package edu.ifpb.br.acelerometroAndroid;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

public class MainActivity extends Activity implements SensorEventListener{


      private Sensor sensor;

      private SensorManager SensorMovimento;

      private TextView Textox;

      private TextView Textoy;

      private TextView Textoz;

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);


            SensorMovimento = (SensorManager) getSystemService(SENSOR_SERVICE);


            sensor = SensorMovimento.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);


            SensorMovimento.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL);


            Textox = (TextView) findViewById(R.id.xTextView);

            Textoy = (TextView) findViewById(R.id.yTextView);

            Textoz = (TextView) findViewById(R.id.zTextView);

    }

    @Override

        public void onSensorChanged(SensorEvent event) {

            Textox.setText("X : " + event.values[0]);

            Log.i("Accelerometer", "onSensorChanged" + event.values[0]);

             Textoy.setText("Y : " + event.values[1]);

             Log.i("Accelerometer", "onSensorChanged" + event.values[1]);

             Textoz.setText("Z : " + event.values[2]);

             Log.i("Accelerometer", "onSensorChanged" + event.values[2]);
    }

    @Override

    public void onAccuracyChanged(Sensor sensor, int accuracy) {


        Log.i("Accelerometer", "onSensorChanged");

    }
}
