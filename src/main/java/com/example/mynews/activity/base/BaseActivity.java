package com.example.mynews.activity.base;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

public class BaseActivity extends FragmentActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //this.requestWindowFeature(Window.FEATURE_NO_TITLE);
    }

    /**
     * 打开另一个activity
     *
     * @param pClass
     */
    protected void openActivity(Class<?> pClass){
        Intent mIntent=new Intent(this,pClass);
        this.startActivity(mIntent);
    }
}
