package sample.com.domain;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import sample.com.domain.base.Contact;
import sample.com.domain.base.DataSource;
import sample.com.domain.base.UseCase;

public class GetContacts extends UseCase<GetContacts.Request, GetContacts.Response> {

    private final DataSource dataSource;

    public GetContacts(DataSource dataSource, Scheduler io, Scheduler main) {
        super(io, main);
        this.dataSource = dataSource;
    }

    @Override
    public Observable<Response> run(Request request) {
        return dataSource.getContactList().map(Response::new).toObservable();
    }

    public static final class Request implements UseCase.Request {

    }

    public static final class Response implements UseCase.Response {
        private final List<Contact> contacts;

        Response(List<Contact> contacts) {
            this.contacts = contacts;
        }

        public List<Contact> contacts() {
            return contacts;
        }
    }
}
