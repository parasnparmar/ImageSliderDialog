package com.example.imagesliderdialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class ImageSliderDialog extends Dialog {

    Context context;
    ArrayList<Integer> imageId;
    int delay;
    boolean shouldLoop;
    ImageView imageSlider,imgCancel;
    int currentIndex = 0;
    Handler handler;
    Runnable imageSwitcher;
    TextView txtCurrentImage;

    public ImageSliderDialog(@NonNull Context context, ArrayList<Integer> imageId, int delay, boolean shouldLoop) {
        super(context);
       setContentView(R.layout.activity_image_slider_dialog);
        this.context=context;
        this.imageId=imageId;
        this.delay=delay;
        this.shouldLoop=shouldLoop;
        initViews();
        imgCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
    }

    private void initViews(){
        imageSlider = findViewById(R.id.imgSlider);
        imgCancel = findViewById(R.id.imgCancel);
        txtCurrentImage = findViewById(R.id.txtImgCount);

        handler = new Handler();
        imageSwitcher = new Runnable() {
            @Override
            public void run() {
                imageSlider.setImageResource(imageId.get(currentIndex));
                txtCurrentImage.setText((currentIndex+1)+ " of " + imageId.size());
                currentIndex++;
                if (currentIndex>=imageId.size()){
                    if (shouldLoop){
                        currentIndex=0;
                    }else {
                        return;
                    }
                }
                handler.postDelayed(this,delay);
            }
        };
    }
    public void show(){
        super.show();
        currentIndex=0;
        handler.post(imageSwitcher);
    }
    public void dismiss(){
        super.dismiss();
        handler.removeCallbacks(imageSwitcher);
    }
}