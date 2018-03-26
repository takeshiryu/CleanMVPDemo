package sample.com.cleanmvp;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import sample.com.cleanmvp.inject.component.DaggerAppComponent;

public class App extends DaggerApplication {

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerAppComponent.builder().application(this).build();
    }
}
