package com.zhang.person;

import android.graphics.Color;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.zhang.mvp_core.view.BaseActivity;

/**
 * @ClassName Person_Login
 * @Description TODO
 * @Author 张溢通
 * @Date 2021/9/16 9:10
 * @Version 1.0
 * Created by Android Studio.
 * User: 伊莎贝拉
 */
@Route(path=Person_Config.LOGIN)
public class Person_Login extends BaseActivity {
<<<<<<< HEAD

=======
>>>>>>> b37936ed3fefe935e74717968030892900a15fc2
    private TextView loginTv;
    private EditText loginUserName;
    private EditText loginUserPwd;
    private Button loginBtn;


    @Override
    protected void initData() {

        loginUserName.addTextChangedListener(new TextChanged());
        loginUserPwd.addTextChangedListener(new TextChanged());


        SpannableStringBuilder spannableStringBuilder=new SpannableStringBuilder( );
        spannableStringBuilder.append("还没有账户？立即注册");
        ForegroundColorSpan colorSpan = new ForegroundColorSpan(Color.parseColor("#FF0090FF"));
        spannableStringBuilder.setSpan(colorSpan,6,10, Spanned.SPAN_COMPOSING);

        ClickableSpan clickableSpan=new ClickableSpan( ) {
            @Override
            public void onClick(@NonNull View widget) {
                Toast.makeText(Person_Login.this, "我要跳转到注册页面", Toast.LENGTH_SHORT).show( );
            }
        };
        spannableStringBuilder.setSpan(clickableSpan,6,10, Spanned.SPAN_COMPOSING);
        loginTv.setText(spannableStringBuilder);
        loginTv.setHighlightColor(Color.TRANSPARENT);
        loginTv.setMovementMethod(LinkMovementMethod.getInstance());
    }

    @Override
    protected void initView() {
        loginTv = (TextView) findViewById(R.id.login_tv);
        loginUserName = (EditText) findViewById(R.id.login_user_name);
        loginUserPwd = (EditText) findViewById(R.id.login_user_pwd);
        loginBtn = (Button) findViewById(R.id.login_btn);
    }

    @Override
    protected int bindLayout() {
        return R.layout.login;
    }


    /**
     * 判断按钮是否可以点击
     */
    public class TextChanged implements TextWatcher{

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
           if(loginUserName.getText().toString().isEmpty()||loginUserPwd.getText().toString().isEmpty()){
               loginBtn.setEnabled(false);
           }else {
               loginBtn.setEnabled(true);
           }
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    }
}
