package com.example.mynews.activity;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;

import com.example.mynews.R;
import com.example.mynews.activity.base.BaseActivity;
import com.example.mynews.widget.CustomVideoView;


public class WelcomeActivity extends BaseActivity {
    private Button welcome_button;
    private CustomVideoView welcome_videoview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_layout);
        initViews();
        initilizes();
    }

    /**
     * 初始化逻辑
     */
    private void initilizes() {

        //读取视频资源
        welcome_videoview.setVideoURI(Uri.parse("android.resource://" + this.getPackageName() + "/" + R.raw.kr36));

        //播放视屏
        welcome_videoview.start();

        /**
         * 实现视频的重复播放功能
         */
        welcome_videoview.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                welcome_videoview.start();

            }
        });
        //进行跳转功能
        welcome_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //在进行跳转的时候如果视频正在播放，就停止视频播放、释放资源
                if(welcome_videoview.isPlaying()){
                    welcome_videoview.stopPlayback();
                    welcome_videoview=null;
                }
                openActivity(MainActivity.class);
                WelcomeActivity.this.finish();
            }
        });
    }

    /**
     * 初始化布局控件
     */
    private void initViews() {
        welcome_button=(Button)this.findViewById(R.id.welcome_button);
        welcome_videoview = (CustomVideoView) this.findViewById(R.id.welcome_videoview);
    }

    private  String getAppVersionName(Context context) {
        String versionName = "";
        try {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(this.getPackageName(), 0);
            versionName = packageInfo.versionName;
            if (TextUtils.isEmpty(versionName)) {
                return "";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return versionName;
    }

}
