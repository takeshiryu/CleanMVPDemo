package sample.com.cleanmvp.inject.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import sample.com.cleanmvp.inject.qualifier.Local;
import sample.com.cleanmvp.inject.qualifier.Remote;
import sample.com.cleanmvp.inject.qualifier.Respository;
import sample.com.data.DataRespo;
import sample.com.data.local.LocalDataSource;
import sample.com.data.remote.RemoteDataSource;
import sample.com.domain.base.DataSource;

@Module
public class RespoModule {

    @Provides
    @Singleton
    @Respository
    DataSource getDataSource(@Local DataSource localDataSource,
                           @Remote DataSource remoteDataSource) {
        return new DataRespo(localDataSource, remoteDataSource);
    }

    @Provides
    @Singleton
    @Remote
    DataSource getRemoteDataSource() {
        return new RemoteDataSource();
    }

    @Provides
    @Singleton
    @Local
    DataSource getLocalDataSource() {
        return new LocalDataSource();
    }
}
