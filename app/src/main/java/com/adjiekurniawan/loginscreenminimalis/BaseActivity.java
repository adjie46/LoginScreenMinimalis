package com.adjiekurniawan.loginscreenminimalis;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

@SuppressLint("Registered")
public class BaseActivity extends AppCompatActivity {

    public void StartActivity(Activity intent){
        Intent activity = new Intent(this,intent.getClass());
        activity.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(activity);
    }

    public void ShowNotification(String message){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }

}
