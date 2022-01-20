package com.example.project01_background;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class FileDownLoadService extends Service {

    private static final String TAG = "filedown";

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate: ");
    }

    public FileDownLoadService() {
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand: 까지 옴 ");
        String value = intent.getStringExtra("key");
        //int progress = 1000;
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Log.d(TAG, "onStartCommand: " + value);
                for(int i = 1 ; i <= 100 ; i++){
                    Log.d(TAG, "onStartCommand:  " + i + "%진행");
                    MainActivity.pg_bar.setProgress(i);
                    try {
                        Thread.sleep(1000);//<- Thread 서비스에 잇는 쓰레드? , Main Thread .
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread.start();





        return super.onStartCommand(intent, flags, startId);
    }

    //iBinder <- 를 이용해서 화면이 바뀌거나 하는 처리들(ForeGround 보이는 화면 )
    //을 넣었으나 에러 발생률이 높고 빈번해서 많이 사용을 안한다.
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}