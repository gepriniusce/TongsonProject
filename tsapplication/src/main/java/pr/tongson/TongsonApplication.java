package pr.tongson;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

/**
 * <b>Project:</b> ${file_name}<br>
 * <b>Create Date:</b> 2017/6/13<br>
 * <b>Author:</b> mmc_Kongming_Tongson<br>
 * <b>Description:</b> <br>
 */
public class TongsonApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);
        // Normal app init code...
    }

}
