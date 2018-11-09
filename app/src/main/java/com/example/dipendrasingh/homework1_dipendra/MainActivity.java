package com.example.dipendrasingh.homework1_dipendra;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {
    public static final int BUTTON_REQUEST = 1;
    private MediaPlayer makePlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setImageDrawable( getResources().getDrawable( android.R.drawable.ic_media_pause ) );
        fab.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ( makePlayer.isPlaying() ) {
                    ((FloatingActionButton)view).setImageDrawable( getResources().getDrawable( android.R.drawable.ic_media_play ) );
                    makePlayer.pause();
                }
                else {
                    ((FloatingActionButton)view).setImageDrawable( getResources().getDrawable( android.R.drawable.ic_media_pause ) );
                    makePlayer.start();
                }
            }
        });
        Button button1 = (Button)findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Main2Activity.class);
                startActivityForResult(intent, 1);

            }
        });

        Button button2 = (Button)findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Main2Activity.class);
                startActivityForResult(intent,2);

            }
        });
        Button button3 = (Button)findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Main2Activity.class);
                startActivityForResult(intent, 3);

            }
        });



    }


    @Override
    protected void onPause() {
        super.onPause();
        makePlayer.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        makePlayer = MediaPlayer.create( this, R.raw.theme );
        makePlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
                mp.start();
            }});
        ((FloatingActionButton)findViewById(R.id.fab)).setImageDrawable( getResources().getDrawable( android.R.drawable.ic_media_pause ) );
    }

    @Override
    protected void onStop() {
        super.onStop();
        makePlayer.release();
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

            if (resultCode == RESULT_OK) {
                switch (requestCode) {
                    case 1:
                        RelativeLayout  relativelayout= findViewById(R.id.Relativelayout);
                        relativelayout.setBackgroundColor(Color.parseColor(data.getStringExtra("color")));
                        break;
                    case 2:
                        Button but1= findViewById(R.id.button1);
                       but1.setBackgroundColor(Color.parseColor(data.getStringExtra("color")));
                       Button  but2= findViewById(R.id.button2);
                        but2.setBackgroundColor(Color.parseColor(data.getStringExtra("color")));
                        Button but3= findViewById(R.id.button3);
                        but3.setBackgroundColor(Color.parseColor(data.getStringExtra("color")));
                        break;
                    case 3:
                        Button butt1= findViewById(R.id.button1);
                        butt1.setTextColor((Color.parseColor(data.getStringExtra("color"))));

                        Button butt2= findViewById(R.id.button2);
                        butt2.setTextColor((Color.parseColor(data.getStringExtra("color"))));


                        Button butt3= findViewById(R.id.button3);
                        butt3.setTextColor((Color.parseColor(data.getStringExtra("color"))));
                        break;
                }

            } else if(resultCode == RESULT_CANCELED){

            }
    }

}
