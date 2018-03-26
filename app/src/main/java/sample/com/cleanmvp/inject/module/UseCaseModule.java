package sample.com.cleanmvp.inject.module;

import dagger.Module;
import dagger.Provides;
import io.reactivex.Scheduler;
import sample.com.cleanmvp.inject.qualifier.IO;
import sample.com.cleanmvp.inject.qualifier.Main;
import sample.com.cleanmvp.inject.qualifier.Respository;
import sample.com.cleanmvp.inject.scope.ActivityScope;
import sample.com.domain.GetContacts;
import sample.com.domain.base.DataSource;

@Module
public class UseCaseModule {

    @Provides
    @ActivityScope
    GetContacts getContacts(@Respository DataSource respo,
                            @IO Scheduler ioScheduler,
                            @Main Scheduler mainScheduler) {
        return new GetContacts(respo, ioScheduler, mainScheduler);
    }
}
