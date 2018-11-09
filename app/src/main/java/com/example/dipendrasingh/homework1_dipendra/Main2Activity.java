package com.example.dipendrasingh.homework1_dipendra;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent received_intent = getIntent();


    }


    public void Ok(View view) {
        RadioGroup group = (RadioGroup) findViewById(R.id.radioGroup);
        RadioButton button = (RadioButton)findViewById( group.getCheckedRadioButtonId() );
        String color = button.getText().toString();

        Intent intent = new Intent();
        intent.putExtra( "color", color);

        setResult( RESULT_OK, intent );

        finish();

    }


    public void cancel(View view) {
        setResult(RESULT_CANCELED);
        finish() ;
    }
}
