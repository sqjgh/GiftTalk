package com.example.dllo.gifttalk.secondlevel.secondprofile;

import android.graphics.Color;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dllo.gifttalk.R;
import com.example.dllo.gifttalk.base.BaseActivity;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

/**
 * Created by dllo on 16/11/9.
 */
public class LoginActivity extends BaseActivity implements View.OnClickListener {

    private EditText id;
    private EditText passWord;
    private Button btn;
    private String ID;
    private String PASSWORD;
    private TextView warnId;
    private TextView warnPassWord;
    private EditText idRegister;
    private Button btnRegister;
    private TextView registerTv;
    private boolean vis = false;
    private ImageView back;
    private boolean IDCheck;
    private boolean passWordCheck;

    @Override
    protected void initData() {
        editTextListener();
        vis = false;
        IDCheck = false;
        passWordCheck = false;
    }


    @Override
    protected void initViews() {
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        id = bindView(R.id.et_id_login);
        passWord = bindView(R.id.et_password_login);
        btn = bindView(R.id.btn_login);
        warnId = bindView(R.id.warn_id);
        warnPassWord = bindView(R.id.warn_password);
        back = bindView(R.id.back_login);
        idRegister = bindView(R.id.et_id_register);
        // 注册, 取消注册文字
        registerTv = bindView(R.id.code_login);
        // 注册按钮
        btnRegister = bindView(R.id.btn_register);

    }

    @Override
    protected int getLayout() {

        return R.layout.login;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_login:
                finish();
                break;

            case R.id.btn_login: // 登录

                BmobUser myUserTwo = new BmobUser();
                myUserTwo.setUsername(id.getText().toString().trim());
                myUserTwo.setPassword(passWord.getText().toString().trim());
                myUserTwo.login(new SaveListener<BmobUser>() {
                    @Override
                    public void done(BmobUser bmobUser, BmobException e) {
                        if (e == null) {
                            Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(LoginActivity.this, "登录失败", Toast.LENGTH_SHORT).show();
                            Log.d("MainActivity", e.getMessage());
                        }
                    }
                });

                break;

            case R.id.btn_register: // 注册
                if (IDCheck && passWordCheck) {
                    Toast.makeText(this, "注册", Toast.LENGTH_SHORT).show();
                    // 创建用户
                    BmobUser bmobUser = new BmobUser();
                    bmobUser.setUsername(id.getText().toString().trim()); // 用户名
                    bmobUser.setPassword(passWord.getText().toString().trim()); // 密码
                    bmobUser.signUp(new SaveListener<BmobUser>() { // 泛型手动变 BmobUser
                        @Override
                        public void done(BmobUser bmobUser, BmobException e) {
                            if (e == null) { // 注册成功
                                Toast.makeText(LoginActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
                            } else { // 注册失败
                                Toast.makeText(LoginActivity.this, "注册失败", Toast.LENGTH_SHORT).show();
                                Log.d("MainActivity", e.getMessage());
                            }
                        }
                    });
                }

                break;
            case R.id.code_login:
                IDCheck = false;
                passWordCheck = false;
                vis = !vis;
                id.setText("");
                passWord.setText("");
                if (vis) {
                    registerTv.setText("取消注册");
                    btn.setVisibility(View.INVISIBLE);
                    warnId.setVisibility(View.GONE);
                    warnPassWord.setVisibility(View.GONE);
                    btnRegister.setVisibility(View.VISIBLE);
                } else {
                    registerTv.setText("注册账号");
                    btn.setVisibility(View.VISIBLE);
                    btnRegister.setVisibility(View.INVISIBLE);


                    warnId.setVisibility(View.GONE);
                    warnPassWord.setVisibility(View.GONE);
                }
                break;
        }
    }

    private void editTextListener() {
        back.setOnClickListener(this);
        idRegister.setOnClickListener(this);
        registerTv.setOnClickListener(this);
        btn.setOnClickListener(this);
        btnRegister.setOnClickListener(this);

        id.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Log.d("LoginActivity", "i:" + i);
            }

            @Override
            public void afterTextChanged(Editable editable) {
                Log.d("LoginActivity", "editable:" + editable);
                ID = editable.toString().trim();
                // 判断输入的是否是数字
                for (int i = ID.length(); --i >= 0; ) {
                    int chr = ID.charAt(i);
                    if ((chr < 48 || chr > 57) || (ID.length() != 11)) {
                        warnId.setVisibility(View.VISIBLE);
                        btn.setBackgroundColor(Color.GRAY);
                        btnRegister.setBackgroundColor(Color.GRAY);
                        IDCheck = false;
                        break;
                    } else {
                        IDCheck = true;
                        if (IDCheck && passWordCheck) {
                            btnRegister.setBackgroundColor(Color.RED);
                            btn.setBackgroundColor(Color.RED);

                        }
                        warnId.setVisibility(View.GONE);
                    }
                }
            }
        });


        passWord.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                PASSWORD = editable.toString().trim();
                // 判断输入的是否是数字和字母
                for (int i = PASSWORD.length(); --i >= 0; ) {
                    int chr = PASSWORD.charAt(i);
                    if (chr < 48 || (65 > chr && chr > 57) || (97 > chr && chr > 90) || (chr > 122) || PASSWORD.length() < 6) {
                        warnPassWord.setVisibility(View.VISIBLE);
                        btn.setBackgroundColor(Color.GRAY);
                        btnRegister.setBackgroundColor(Color.GRAY);
                        passWordCheck = false;
                        break;
                    } else {
                        passWordCheck = true;
                        if (IDCheck && passWordCheck) {
                            btnRegister.setBackgroundColor(Color.RED);
                            btn.setBackgroundColor(Color.RED);
                        }
                        warnPassWord.setVisibility(View.GONE);
                    }
                }
            }
        });

    }


}
