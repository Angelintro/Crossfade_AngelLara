package com.example.walmart.crossfade_angellara;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Crosfa extends AppCompatActivity {
    private View mContentView;
    private View mLoadingView;
    private int mShortAnimationDuration;
    private Button bonton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crosfa);

        mContentView = findViewById(R.id.content);

        mLoadingView = findViewById(R.id.cargar);




        mContentView.setVisibility(View.GONE);



        mShortAnimationDuration = getResources().getInteger(
                android.R.integer.config_shortAnimTime);


        bonton = findViewById(R.id.button);

        bonton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                crossfade();
            }
        });
    }

    private void crossfade() {

        mContentView.setAlpha(0f);
        mContentView.setVisibility(View.VISIBLE);

        // Tiempo en que aparecerá el texto
        mContentView.animate()
                .alpha(1f)
                .setDuration(4000)
                .setListener(null);



        mLoadingView.animate()

                .alpha(0f)

                .setDuration(mShortAnimationDuration)

                .setListener(new AnimatorListenerAdapter() {

                    @Override

                    public void onAnimationEnd(Animator animation) {

                        mLoadingView.setVisibility(View.GONE);

                    }

                });


    }


}
