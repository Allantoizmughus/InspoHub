package com.moringaschool.inspohub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.moringaschool.inspohub.UI.QuotesListActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    @BindView(R.id.AppNameTextView)
    TextView mAppNameTextView;
    @BindView(R.id.ViewQuotesButton)
    Button mViewQuotesButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mViewQuotesButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v == mViewQuotesButton ){
           Intent intent = new Intent(MainActivity.this, QuotesListActivity.class);
           startActivity(intent);
        }

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}