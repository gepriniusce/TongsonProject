/*
 * Copyright (c) 2016. 广东灵机文化传播有限公司（本内容仅限于广东灵机文化传播有限公司内部传阅，禁止外泄以及用于其他的商业目的）
 */

package pr.tongson;

import android.app.Application;
import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;

import com.squareup.leakcanary.LeakCanary;

/**
 * onCreate
 * onStartCommand
 * onStart
 * onStartCommand
 * onStart
 * onHandleIntent
 * onDestroy
 * <b>Project:</b> ${file_name} <br>
 * <b>Create Date:</b> 2016/10/28 <br>
 * <b>Author:</b> mmc <br>
 * <b>Description:</b>  <br>
 */
public class InitializeService extends IntentService {

    private static final String ACTION_INIT_WHEN_APP_CREATE = "com.mmc.hellogit.action.INIT";
    private static final String NAME = "com.mmc.InitializeService.action.INIT";
    Application myApplication;

    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param application Used to name the worker thread, important only for debugging.
     */
    public InitializeService(Application application) {
        super(NAME);
        this.myApplication = application;
    }

    public InitializeService(String name) {
        super(name);
    }

    public InitializeService() {
        super(NAME);
    }


    @Override
    public IBinder onBind(Intent intent) {
        return super.onBind(intent);
        //        System.out.println("onBind");
    }


    @Override
    public void onCreate() {
        super.onCreate();
        //        System.out.println("onCreate");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
        //        System.out.println("onStartCommand");
    }


    public static void start(Context context) {
        Intent intent = new Intent(context, InitializeService.class);
        intent.setAction(ACTION_INIT_WHEN_APP_CREATE);
        context.startService(intent);
        //        System.out.println("onStart");
    }


    @Override
    public void setIntentRedelivery(boolean enabled) {
        super.setIntentRedelivery(enabled);
        //        System.out.println("setIntentRedelivery");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        //Intent是从Activity发过来的，携带识别参数，根据参数不同执行不同的任务
        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_INIT_WHEN_APP_CREATE.equals(action)) {
                performInit();
            }
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //        System.out.println("onDestroy");
    }


    private void performInit() {
        if (LeakCanary.isInAnalyzerProcess(getApplicationContext())) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(getApplication());
        // Normal app init code...

    }


}
