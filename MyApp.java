package uz.alm;

import android.app.Application;

import uz.alm.di.auth.AuthModule;
import uz.alm.di.auth.DaggerAuthComponent;

public class MyApp extends Application {

    private static MyApp instance;

    @Override
    public void onCreate() {
        super.onCreate();
        DaggerAuthComponent.builder().authModule(new AuthModule()).build();
    }

    public MyApp() {
        instance = this;
    }

    public static MyApp get() {
        return instance;
    }

}
