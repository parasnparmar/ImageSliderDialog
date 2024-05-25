package com.example.imagesliderdialog;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btnImageSlider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnImageSlider= findViewById(R.id.btnImageSlider);
        btnImageSlider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<Integer> imageId = new ArrayList<>();
                imageId.add(R.drawable.dog1);
                imageId.add(R.drawable.dog2);
                imageId.add(R.drawable.dog3);
                imageId.add(R.drawable.dog4);
                imageId.add(R.drawable.cat1);
                imageId.add(R.drawable.cat2);
                imageId.add(R.drawable.cat3);
                imageId.add(R.drawable.cat4);

                ImageSliderDialog imageSliderDialog = new ImageSliderDialog(MainActivity.this,imageId,2000,true);
                imageSliderDialog.show();


            }
        });

    }
}