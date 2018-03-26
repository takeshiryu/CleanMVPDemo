package sample.com.domain.base;

import java.util.List;

import io.reactivex.Flowable;

public interface DataSource {

    Flowable<List<Contact>> getContactList();
}
