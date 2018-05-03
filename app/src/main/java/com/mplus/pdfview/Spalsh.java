package com.mplus.pdfview;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import java.util.Random;

public class Spalsh extends Activity {
    Thread splashTread;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spalsh);
        imageView = (ImageView)findViewById(R.id.splash);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        int[] ids = new int[]{R.drawable.splash};
        Random randomGenerator = new Random();
        int r= randomGenerator.nextInt(ids.length);
        this.imageView.setImageDrawable(getResources().getDrawable(ids[r]));

        splashTread = new Thread() {
            @Override
            public void run() {
                try {
                    int waited = 0;
                    // Splash screen pause time
                    while (waited < 3500) {
                        sleep(100);
                        waited += 100;
                    }
                    Intent intent = new Intent(Spalsh.this,
                            ListPdfActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(intent);
                    Spalsh.this.finish();
                } catch (InterruptedException e) {
                    // do nothing
                } finally {
                    Spalsh.this.finish();
                }

            }
        };
        splashTread.start();
    }
}
