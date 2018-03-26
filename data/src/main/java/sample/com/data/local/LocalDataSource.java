package sample.com.data.local;

import android.util.Log;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.Flowable;
import sample.com.domain.base.Contact;
import sample.com.domain.base.DataSource;

public class LocalDataSource implements DataSource {

    private Map<String, Contact> contactList;

    public LocalDataSource() {
        contactList = new HashMap<>();
        contactList.put("3", new Contact("3", "Mr. C", "1122 3333"));
        contactList.put("4", new Contact("4", "Mr. D", "1122 4444"));
    }

    @Override
    public Flowable<List<Contact>> getContactList() {
        return Flowable.fromIterable(contactList.values())
                .doOnNext(contacts -> Log.d("LocalData", "200 OK"))
                .toList()
                .toFlowable();
    }
}
