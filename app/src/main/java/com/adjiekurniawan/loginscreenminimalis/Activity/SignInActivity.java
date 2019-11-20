package com.adjiekurniawan.loginscreenminimalis.Activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.adjiekurniawan.loginscreenminimalis.BaseActivity;
import com.adjiekurniawan.loginscreenminimalis.R;

public class SignInActivity extends BaseActivity implements View.OnClickListener {

    private TextView mSignUptext;
    private ImageButton mFacebookButton,mGoogleButton;
    private Button mLoginButton;
    private EditText mEmail,mPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        initView();
        initInitialize();
    }

    private void initView(){
        mSignUptext = findViewById(R.id.text_no_have_account);
        mFacebookButton = findViewById(R.id.ib_sign_in_fb);
        mGoogleButton = findViewById(R.id.ib_sign_in_google);
        mLoginButton = findViewById(R.id.btn_sign_in);
        mEmail = findViewById(R.id.et_email_field);
        mPassword = findViewById(R.id.et_password_field);
    }

    private void initInitialize(){
        mSignUptext.setOnClickListener(this);
        mLoginButton.setOnClickListener(this);
        mFacebookButton.setOnClickListener(this);
        mGoogleButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.text_no_have_account:
                StartActivity(new SignUpAcitivty());
                break;
            case R.id.ib_sign_in_fb:
                ShowNotification(getString(R.string.msg_fb_btn_click));
                break;
            case R.id.ib_sign_in_google:
                ShowNotification(getString(R.string.msg_gg_btn_click));
                break;
            case R.id.btn_sign_in:
                validation();
                break;
        }
    }


    private void validation(){
        Animation shake = AnimationUtils.loadAnimation(this, R.anim.shake_animation);
        if (TextUtils.isEmpty(mEmail.getText()) && TextUtils.isEmpty(mPassword.getText())){
            ShowNotification(getString(R.string.msg_is_empty));
            mEmail.setHintTextColor(getResources().getColor(R.color.colorRed));
            mPassword.setHintTextColor(getResources().getColor(R.color.colorRed));
            mPassword.startAnimation(shake);
            mEmail.startAnimation(shake);
        }else if (TextUtils.isEmpty(mEmail.getText())){
            ShowNotification(getString(R.string.msg_email_empty));
            mEmail.setHintTextColor(getResources().getColor(R.color.colorRed));
            mEmail.startAnimation(shake);
        }else if (TextUtils.isEmpty(mPassword.getText())){
            ShowNotification(getString(R.string.msg_pwd_empty));
            mPassword.setHintTextColor(getResources().getColor(R.color.colorRed));
            mPassword.startAnimation(shake);
        }else{
            ShowNotification(getString(R.string.msg_login_success));
        }
    }
}
