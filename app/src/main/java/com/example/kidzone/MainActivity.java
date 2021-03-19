package com.example.kidzone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Telephony;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private View decorView;
    private Button logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        logout = (Button) findViewById(R.id.signOut);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(MainActivity.this,register.class));
            }
        });
        decorView = getWindow().getDecorView();
        decorView.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() {
            @Override
            public void onSystemUiVisibilityChange(int visibility) {
                if (visibility == 0)
                    decorView.setSystemUiVisibility(hideSystemBars());
            }
        });
    }
    public void gmailbutton(View view){
        Intent intent = getPackageManager().getLaunchIntentForPackage("com.google.android.gm");
        if (intent != null){
            startActivity(intent);
        }

    }
    public void smsbutton(View view){
        Intent intent = getPackageManager().getLaunchIntentForPackage("com.google.android.gm");
        if (intent != null){
            startActivity(intent);
        }

    }
    public void settingdbutton(View view){
        Intent intent = getPackageManager().getLaunchIntentForPackage("com.google.android.gm");
        if (intent != null){
            startActivity(intent);
        }

    }
    public void photosbutton(View view){
        Intent intent = getPackageManager().getLaunchIntentForPackage("com.google.android.gm");
        if (intent != null){
            startActivity(intent);
        }

    }

    @Override
    public void onBackPressed() {
        //do nothing
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus){
            decorView.setSystemUiVisibility(hideSystemBars());
        }
    }
    private int hideSystemBars(){
        return View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                |View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                |View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                |View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                |View.SYSTEM_UI_FLAG_FULLSCREEN
                |View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION;

    }
}