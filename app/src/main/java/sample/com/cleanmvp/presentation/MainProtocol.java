package sample.com.cleanmvp.presentation;

import java.util.List;

import sample.com.domain.base.Contact;

public interface MainProtocol {

    interface View {
        void loadContactList(List<Contact> contacts);
        void loadErrorList();
    }

    interface Presenter {
        void takeView(View view);
        void getContacts();
        void dropView(View view);
    }
}
