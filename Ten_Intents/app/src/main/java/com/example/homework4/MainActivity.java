package com.example.homework4;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    static final int REQUEST_IMAGE_CAPTURE = 1;
    //static final Uri locationForPhotos;

    Button btn_i1;
    Button btn_i2;
    Button btn_i3;
    Button btn_i4;
    Button btn_i5;
    Button btn_i6;
    Button btn_i7;
    Button btn_i8;
    Button btn_i9;
    Button btn_i10;

    Intent intent;
    Intent chooser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_i1 = findViewById(R.id.btn_i1);
        btn_i2 = findViewById(R.id.btn_i2);
        btn_i3 = findViewById(R.id.btn_i3);
        btn_i4 = findViewById(R.id.btn_i4);
        btn_i5 = findViewById(R.id.btn_i5);
        btn_i6 = findViewById(R.id.btn_i6);
        btn_i7 = findViewById(R.id.btn_i7);
        btn_i8 = findViewById(R.id.btn_i8);
        btn_i9 = findViewById(R.id.btn_i9);
        btn_i10 = findViewById(R.id.btn_i10);

        intent = new Intent();

        // Send Message
        btn_i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.setAction(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT, "Assalam o Alaikum!");

                //chooser = Intent.createChooser(intent, "Show Intents");

                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });

        //
        btn_i2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
                intent.putExtra(MediaStore.EXTRA_OUTPUT,
                        Uri.withAppendedPath(locationForPhotos, targetFilename));
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivityForResult(intent, REQUEST_IMAGE_CAPTURE);
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


    }
}