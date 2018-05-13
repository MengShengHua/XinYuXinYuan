package com.example.xinyuxinyuan.view.activity.univ;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.xinyuxinyuan.R;
import com.example.xinyuxinyuan.view.activity.register.RegisterActivity;

public class UnivStarActivity extends AppCompatActivity {

    private ImageView univActivity_return;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_univ_star);
        initView();
    }

    private void initView() {
        Intent intent = getIntent();
        String setUnivStar = intent.getStringExtra("SetUnivStar");
        univActivity_return = (ImageView) findViewById(R.id.univActivity_return);
        univActivity_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UnivStarActivity.this, RegisterActivity.class));
                finish();
            }
        });
    }
}
