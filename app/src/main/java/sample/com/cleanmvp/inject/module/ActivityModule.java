package sample.com.cleanmvp.inject.module;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import sample.com.cleanmvp.inject.scope.ActivityScope;
import sample.com.cleanmvp.presentation.MainActivity;

@Module
public abstract class ActivityModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = UseCaseModule.class)
    abstract MainActivity mainActivity();
}
