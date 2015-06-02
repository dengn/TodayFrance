package dengn.todayfrance.application;

import android.app.Application;

import com.facebook.stetho.Stetho;

/**
 * Created by OLEDCOMM on 02/06/2015.
 */
public class MyApplication extends Application {


    public void onCreate() {
        super.onCreate();
        Stetho.initialize(
                Stetho.newInitializerBuilder(this)
                        .enableDumpapp(
                                Stetho.defaultDumperPluginsProvider(this))
                        .enableWebKitInspector(
                                Stetho.defaultInspectorModulesProvider(this))
                        .build());
    }
}
