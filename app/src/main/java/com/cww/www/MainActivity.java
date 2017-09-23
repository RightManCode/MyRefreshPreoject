package com.cww.www;

import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.cww.www.refreshview.MaterialRefreshLayout;
import com.cww.www.refreshview.MaterialRefreshListener;

public class MainActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {

    private SwipeRefreshLayout refreshLayout;

    private TextView textView;

    private int i = 0;

    private Handler messageHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            switch (msg.what) {
                case 0: {
                    if (refreshLayout.isRefreshing()) {
                        i++;
                        textView.setText("刷新完成，次数：" + i);
                        refreshLayout.setRefreshing(false);
                        Log.e("cww", "hhahahaha");
                    }
                }
                break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        refreshLayout = (SwipeRefreshLayout) findViewById(R.id.refresh);
        textView = (TextView) findViewById(R.id.tv_text);
        initRefreshLayout();
    }

    private void initRefreshLayout() {
//        refreshLayout.post(new Runnable() {
//            @Override
//            public void run() {
//                refreshLayout.setRefreshing(true);
//            }
//        });
        refreshLayout.setColorSchemeColors(getResources().getColor(android.R.color.holo_blue_bright), getResources().getColor(android.R.color.holo_green_light),
                getResources().getColor(android.R.color.holo_orange_light), getResources().getColor(android.R.color.holo_red_light));
        refreshLayout.setOnRefreshListener(this);
    }

    @Override
    public void onRefresh() {
        Log.e("cww", "jejeje");
        Message msg = new Message();
        msg.what = 0;
        messageHandler.sendMessageDelayed(msg, 3000);
    }
}
