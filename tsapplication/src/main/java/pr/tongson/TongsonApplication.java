package pr.tongson;

import android.app.Application;

/**
 * <b>Project:</b> ${file_name}<br>
 * <b>Create Date:</b> 2017/6/13<br>
 * <b>Author:</b> mmc_Kongming_Tongson<br>
 * <b>Description:</b> 番茄<br>
 */
public class TongsonApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        new InitializeService(this);
        InitializeService.start(this);
    }

}
