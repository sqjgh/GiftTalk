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
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dllo.gifttalk.R;
import com.example.dllo.gifttalk.base.BaseActivity;
import com.example.dllo.gifttalk.tools.Values;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.QueryListener;
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
    private Button cancel;
    private RelativeLayout alreadyLogin;
    private RelativeLayout loginRl;
    private TextView alreadyID;
    private UserBean userBean;

    @Override
    protected void initData() {
        // 如果有默认账号 显示取消登录界面
        if (Values.USER_NAME != null) {
            alreadyLogin.setVisibility(View.VISIBLE);
            loginRl.setVisibility(View.INVISIBLE);
            alreadyID.setText(Values.USER_NAME);
        }
        editTextListener();
        vis = false;
        IDCheck = false;
        passWordCheck = false;
    }


    @Override
    protected void initViews() {
        // 注册主界面
        loginRl = bindView(R.id.login_login);
        // 注册成功后出的界面
        alreadyLogin = bindView(R.id.rl_allready_login);
        // 注册成功后出的切换账号btn
        cancel = bindView(R.id.btn_cancel_login);
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
        alreadyID = bindView(R.id.id_already_login);
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

                userBean = new UserBean();
                userBean.setUsername(id.getText().toString().trim());
                userBean.setPassword(passWord.getText().toString().trim());
                userBean.login(new SaveListener<UserBean>() {
                    @Override
                    public void done(UserBean bmobUser, BmobException e) {
                        if (e == null) {
                            Values.USER_NAME = id.getText().toString().trim();
                            alreadyID.setText(Values.USER_NAME);
                            alreadyLogin.setVisibility(View.VISIBLE);
                            loginRl.setVisibility(View.INVISIBLE);
                            Log.d("LoginActivity", userBean.getObjectId());
                            Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                            initUserData();
                        } else {
                            Toast.makeText(LoginActivity.this, "登录失败", Toast.LENGTH_SHORT).show();
                            Log.d("MainActivity", e.getMessage());
                        }
                    }
                });


                break;

            case R.id.btn_register: // 注册
                if (IDCheck && passWordCheck) {
                    // 创建用户
                    BmobUser bmobUser = new BmobUser();
                    bmobUser.setUsername(id.getText().toString().trim()); // 用户名
                    bmobUser.setPassword(passWord.getText().toString().trim()); // 密码
                    bmobUser.signUp(new SaveListener<BmobUser>() { // 泛型手动变 BmobUser
                        @Override
                        public void done(BmobUser bmobUser, BmobException e) {
                            if (e == null) { // 注册成功
                                // 清空本地收藏
                                Values.COLLECT_LIST = null;
                                vis = !vis;
                                registerTv.setText("注册账号");
                                btn.setVisibility(View.VISIBLE);
                                btnRegister.setVisibility(View.INVISIBLE);

                                warnId.setVisibility(View.GONE);
                                warnPassWord.setVisibility(View.GONE);
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
            case R.id.btn_cancel_login: // 取消登录并切换账号
                UserBean.logOut();   //清除缓存用户对象
                Values.USER_NAME = null;
//                BmobUser currentUser = BmobUser.getCurrentUser(); // 现在的currentUser是null了
                alreadyLogin.setVisibility(View.INVISIBLE);
                loginRl.setVisibility(View.VISIBLE);
                id.setText("");
                passWord.setText("");
                break;
        }
    }

    private void initUserData() {

            // 获取网络存取的性别
            BmobQuery<UserBean> query = new BmobQuery<UserBean>();
            query.getObject(userBean.getObjectId(), new QueryListener<UserBean>() {

                @Override
                public void done(UserBean object, BmobException e) {
                    if(e==null){
                        //获得playerName的信息
                        Log.d("M111", object.getSex());
                        Values.USER_SEX = object.getSex();
                        Log.d("M222", "设置网络性别" + object.getSex());
                    }else{
                        Log.i("bmob","失败："+e.getMessage()+","+e.getErrorCode());
                    }
                }

            });

    }
    private void editTextListener() {
        cancel.setOnClickListener(this);
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
