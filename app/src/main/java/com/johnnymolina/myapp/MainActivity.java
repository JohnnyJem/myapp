package com.johnnymolina.myapp;

import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import icepick.Icepick;


public class MainActivity extends ActionBarActivity {

    //Views
    @Bind(R.id.title1) Button title1;
    @Bind(R.id.title2) Button title2;
    @Bind(R.id.title3) Button title3;
    @Bind(R.id.title4) Button title4;
    @Bind(R.id.title5) Button title5;

    private Button last;
    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Icepick.restoreInstanceState(this, savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause(){
        super.onPause();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        // Always call the superclass so it can save the view hierarchy stat
        super.onSaveInstanceState(outState);
        Icepick.saveInstanceState(this, outState);
     ///  savedInstanceState.putString(butterButtonState, butterButtonString);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }

    //Buttons animation change and Toast OnClick.
    @OnClick({R.id.title1,R.id.title2,R.id.title3,R.id.title4,R.id.title5})
    public void buttonClick(View view){
        button = (Button) view;

        if (last !=null) {
                last.setBackgroundColor(Color.parseColor("#F08C35"));
                last.setTextColor(Color.parseColor("#FFFFFF"));
            }

        button.setBackgroundColor(Color.RED);
        button.setTextColor(Color.parseColor("#000000"));

        last=button;

        String title = button.getText().toString();
        Toast.makeText(this, "This button will launch my " + title + " App.", Toast.LENGTH_SHORT).show();
    }


}
