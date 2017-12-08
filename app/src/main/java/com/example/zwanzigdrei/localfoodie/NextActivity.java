package com.example.zwanzigdrei.localfoodie;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by User on 3/12/2017.
 */

public class NextActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);
    }

    public void function2Click(View view){
        Intent f2intent = new Intent(NextActivity.this, Function2Activity.class);
        startActivity(f2intent);
    }

    public void function3Click(View view){
        Intent f3intent = new Intent(NextActivity.this, Function3Activity.class);
        startActivity(f3intent);
    }


}
