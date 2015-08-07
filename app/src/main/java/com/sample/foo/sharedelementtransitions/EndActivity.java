package com.sample.foo.sharedelementtransitions;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class EndActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);

        View smallImageView = findViewById(R.id.textView);
        View editText = findViewById(R.id.editText);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            smallImageView.setTransitionName(getString(R.string.activity_text_trans));
            editText.setTransitionName(getString(R.string.activity_mixed_trans));
        }
    }

}
