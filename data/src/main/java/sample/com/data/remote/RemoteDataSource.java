package sample.com.data.remote;

import android.util.Log;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import io.reactivex.Flowable;
import sample.com.domain.base.Contact;
import sample.com.domain.base.DataSource;

public class RemoteDataSource implements DataSource {

    private Map<String, Contact> contactList;

    public RemoteDataSource() {
        contactList = new HashMap<>();
        contactList.put("1", new Contact("1", "Mr. A", "0011 1111"));
        contactList.put("2", new Contact("2", "Mr. B", "0011 2222"));
    }

    @Override
    public Flowable<List<Contact>> getContactList() {
        return Flowable.fromIterable(contactList.values())
                .delay(3, TimeUnit.SECONDS)
                .doOnNext(contacts -> Log.d("RemoteData", "200 OK"))
                .toList()
                .toFlowable();
    }
}
