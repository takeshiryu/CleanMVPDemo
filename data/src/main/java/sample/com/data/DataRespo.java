package sample.com.data;

import java.util.List;

import io.reactivex.Flowable;
import sample.com.domain.base.Contact;
import sample.com.domain.base.DataSource;

public class DataRespo implements DataSource {

    private DataSource remoteDataSource;
    private DataSource localDataSource;

    public DataRespo(DataSource localDataSource,
                     DataSource remoteDataSource) {
        this.remoteDataSource = remoteDataSource;
        this.localDataSource = localDataSource;
    }

    @Override
    public Flowable<List<Contact>> getContactList() {
        return Flowable.concat(localDataSource.getContactList(), remoteDataSource.getContactList());
    }
}
