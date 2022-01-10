package com.ford.anrtest;

import android.os.Handler;
import android.os.Message;

import androidx.annotation.NonNull;

public class ANRWatchDog extends Thread {

    private int count = 0;

    private int last_count = 0;

    private  Handler H = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if (msg.what == 100) {

                count++;
            }
        }
    };

    @Override
    public void run() {
        super.run();
        while (true) {
            try {

                H.sendEmptyMessage(100);

                Thread.sleep(5 * 1000);

                //5秒钟后如果程序的计数器还没有更新数值则说明消息轮询器没有处理到消息
                //此时程序卡住无响应.
                if (count == last_count) {
                    //说明消息没有到达
                    throw new ANRException("程序ANR了......");
                } else {
                    last_count = count;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
