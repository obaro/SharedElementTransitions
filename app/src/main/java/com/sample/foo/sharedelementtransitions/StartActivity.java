package com.sample.foo.sharedelementtransitions;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
    }

    public void onClick(View view) {
        View imageView = findViewById(R.id.imageView);
        View textView = findViewById(R.id.textView);
        View button = findViewById(R.id.button);

        Intent intent = new Intent(this, EndActivity.class);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            textView.setTransitionName(getString(R.string.activity_text_trans));
            button.setTransitionName(getString(R.string.activity_mixed_trans));

            Pair<View, String> pair1 = Pair.create(imageView, imageView.getTransitionName());
            Pair<View, String> pair2 = Pair.create(textView, textView.getTransitionName());
            Pair<View, String> pair3 = Pair.create(button, button.getTransitionName());
            ActivityOptionsCompat options = ActivityOptionsCompat.
                    makeSceneTransitionAnimation(this, pair1, pair2, pair3);
            startActivity(intent, options.toBundle());
        }
        else {
            startActivity(intent);
        }
    }
}
