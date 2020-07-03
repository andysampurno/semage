package com.jc.semage;

import androidx.appcompat.app.AppCompatActivity;

//import android.content.Intent;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.app.Service;
import android.content.Intent;
import android.graphics.Bitmap;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class home extends AppCompatActivity{

    private static final int CAMERA_REQUEST = 1888;
    ImageView imageView;

//    SensorManager sensorManager;
//    Sensor sensor;

    Button btnCamera;
    Button btnSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        imageView = (ImageView)findViewById(R.id.qImage);
        btnCamera = (Button)findViewById(R.id.qBtnCamera);
        btnSearch = (Button)findViewById(R.id.qBtnSrc);

        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, camera.class);
//                startActivity(intent);
//                sensorManager = (SensorManager) getSystemService(Service.SENSOR_SERVICE);
//                sensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
//                Intent intentCamera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//                startActivityForResult(intentCamera, CAMERA_REQUEST);
//                Intent interntNotifFlash = new Intent(home.this, notifFlash.class);
//                startActivity(interntNotifFlash);
                    final Dialog dialog = new Dialog(home.this);
                    dialog.setContentView(R.layout.notification_flash);
                    dialog.setTitle("TWOH.Co");
                    TextView text = (TextView) dialog.findViewById(R.id.notifFlash);
                    text.setText("TWOH's Engineering custom dialog sample");
                    Button btnNotif = (Button) dialog.findViewById(R.id.qBtnNotif);
                    btnNotif.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                            Intent intentCamera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                            startActivityForResult(intentCamera, CAMERA_REQUEST);
                        }
                    });
                    dialog.show();
                }
            });


        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(home.this, viewImage.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CAMERA_REQUEST && resultCode == RESULT_OK) {
            Bitmap photoCamera = (Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(photoCamera);
        }
    }
}