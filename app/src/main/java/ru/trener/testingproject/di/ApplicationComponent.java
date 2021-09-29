package ru.trener.testingproject.di;

import javax.inject.Singleton;

import dagger.Component;
import ru.trener.testingproject.di.modules.AppModule;
import ru.trener.testingproject.di.modules.WebModule;
import ru.trener.testingproject.di.services.BaseService;
import ru.trener.testingproject.ui.main.MainActivity;
import ru.trener.testingproject.ui.video.PlayVideoActivity;

@Singleton
@Component(modules = {WebModule.class, AppModule.class})
interface ApplicationComponent {
    void inject(BaseService baseService);
    void inject(MainActivity mainActivity);
    void inject(PlayVideoActivity playVideoActivity);
}
