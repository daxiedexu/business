package com.zhang.person;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.zhang.common.utils.back.SharedManger;
import com.zhang.mvp_core.view.BaseActivity;

/**
 * @ClassName Person_Register
 * @Description TODO
 * @Author 张溢通
 * @Date 2021/9/19 10:05
 * @Version 1.0
 * Created by Android Studio.
 * User: 伊莎贝拉
 */

@Route(path=Person_Config.REGISTER)
public class Person_Register extends BaseActivity {
    private EditText registerUserName;
    private EditText registerUserPwd;
    private Button registerBtn;

    @Override
    protected void initData() {
        SharedManger user=new SharedManger(this, "user");

        registerUserName.addTextChangedListener(new TextChanged());
        registerUserPwd.addTextChangedListener(new TextChanged());
        registerBtn.setOnClickListener(new View.OnClickListener( ) {
            @Override
            public void onClick(View v) {
                user.putValue("zh",registerUserName.getText().toString());
                user.putValue("mm",registerUserPwd.getText().toString());
                finish();
            }
        });
    }

    @Override
    protected void initView() {
        registerUserName = (EditText) findViewById(R.id.register_user_name);
        registerUserPwd = (EditText) findViewById(R.id.register_user_pwd);
        registerBtn = (Button) findViewById(R.id.register_btn);

    }

    @Override
    protected int bindLayout() {
        return R.layout.register;
    }


    /**
     * 判断按钮是否可以点击
     */
    public class TextChanged implements TextWatcher {

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if(registerUserName.getText().toString().isEmpty()||registerUserPwd.getText().toString().isEmpty()){
                registerBtn.setEnabled(false);
            }else {
                registerBtn.setEnabled(true);
            }
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    }
}
