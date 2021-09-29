package ru.trener.testingproject;

import android.app.Application;

import ru.trener.testingproject.di.DaggerApplicationComponent;
import ru.trener.testingproject.di.modules.AppModule;
import ru.trener.testingproject.di.modules.WebModule;

public class App extends Application {

    public static DaggerApplicationComponent applicationComponent;
    @Override
    public void onCreate() {
        super.onCreate();
        applicationComponent = (DaggerApplicationComponent) DaggerApplicationComponent.builder()
                .appModule(new AppModule(this))
                .webModule(new WebModule(this))
                .build();
    }
}
