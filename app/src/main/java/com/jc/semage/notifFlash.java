//package com.jc.semage;
//
//import android.app.Dialog;
//import android.app.Service;
//import android.content.Intent;
//import android.hardware.Sensor;
//import android.hardware.SensorEvent;
//import android.hardware.SensorEventListener;
//import android.hardware.SensorManager;
//import android.os.Bundle;
//import android.provider.MediaStore;
//import android.view.View;
//import android.widget.Button;
//import android.widget.TextView;
//
//import androidx.annotation.ContentView;
//import androidx.annotation.Nullable;
//import androidx.appcompat.app.AppCompatActivity;
//
//public class notifFlash extends AppCompatActivity implements SensorEventListener {
//
//    private static final int CAMERA_REQUEST = 1888;
//
//    TextView light;
//    SensorManager sensorManager;
//    Sensor sensor;
//
//
//
//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_home);
//
//
//        sensorManager = (SensorManager) getSystemService(Service.SENSOR_SERVICE);
//        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
//
//        light = (TextView)findViewById(R.id.lightN);
//
//        final Dialog dialog = new Dialog(notifFlash.this);
//        dialog.setContentView(R.layout.notification_flash);
//        TextView text = (TextView) dialog.findViewById(R.id.notifFlash);
////                    text.setText("TWOH's Engineering custom dialog sample");
//
//        Button btnNotif = (Button) dialog.findViewById(R.id.qBtnNotif);
//        btnNotif.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialog.dismiss();
//                Intent intentCamera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//                startActivityForResult(intentCamera, CAMERA_REQUEST);
//            }
//        });
//        dialog.show();
//
//    }
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//        sensorManager.unregisterListener(this);
//    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//        sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL);
//    }
//
//    @Override
//    public void onSensorChanged(SensorEvent event) {
//        if (event.sensor.getType() == Sensor.TYPE_LIGHT){
//            if (event.values[0] <= 10){
//                light.setText("Karena Cahaya Redup Perlu mengaktifkan Flash untuk mengambil gambar");
//            }else{
//                light.setText("Karena cahaya terang tidak perlu mengaktifkan Flash saat mengambi gambar");
//            }
////            light.setText(""+event.values[0]);
//        }
//
//    }
//
//    @Override
//    public void onAccuracyChanged(Sensor sensor, int accuracy) {
//
//    }
//}
