package sample.com.cleanmvp.inject.module;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import sample.com.cleanmvp.inject.qualifier.IO;
import sample.com.cleanmvp.inject.qualifier.Main;

@Module
public abstract class AppModule {

    @Binds
    abstract Context bindContext(Application application);

    @Provides
    @Singleton
    @IO
    static Scheduler ioScheduler() {
        return Schedulers.io();
    }

    @Provides
    @Singleton
    @Main
    static Scheduler mainScheduler() {
        return AndroidSchedulers.mainThread();
    }
}
