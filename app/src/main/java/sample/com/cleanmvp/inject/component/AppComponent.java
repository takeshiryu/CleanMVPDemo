package sample.com.cleanmvp.inject.component;

import android.app.Application;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;
import sample.com.cleanmvp.App;
import sample.com.cleanmvp.inject.module.ActivityModule;
import sample.com.cleanmvp.inject.module.AppModule;
import sample.com.cleanmvp.inject.module.RespoModule;

@Singleton
@Component(modules = {
        AppModule.class,
        ActivityModule.class,
        RespoModule.class,
        AndroidSupportInjectionModule.class})
public interface AppComponent extends AndroidInjector<App> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        AppComponent.Builder application(Application application);

        AppComponent build();
    }
}
