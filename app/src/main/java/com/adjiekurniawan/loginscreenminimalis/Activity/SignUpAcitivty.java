package com.adjiekurniawan.loginscreenminimalis.Activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.adjiekurniawan.loginscreenminimalis.BaseActivity;
import com.adjiekurniawan.loginscreenminimalis.R;

public class SignUpAcitivty extends BaseActivity implements View.OnClickListener {

    private TextView mSignInText;
    private Button mRegisterButton;
    private EditText mEmail,mPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_acitivty);

        initView();
        initInitialize();

    }

    private void initView() {
        mSignInText = findViewById(R.id.text_signin_text);
        mRegisterButton = findViewById(R.id.btn_sign_up);
        mEmail = findViewById(R.id.et_email_field);
        mPassword = findViewById(R.id.et_password_field);
    }

    private void initInitialize() {
        mSignInText.setOnClickListener(this);
        mRegisterButton.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.text_signin_text:
                StartActivity(new SignInActivity());
                break;
            case R.id.btn_sign_up:
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
            ShowNotification(getString(R.string.msg_register_success));
        }
    }
}
