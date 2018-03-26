package sample.com.cleanmvp.presentation;

import javax.inject.Inject;

import sample.com.cleanmvp.inject.scope.ActivityScope;
import sample.com.domain.GetContacts;

@ActivityScope
class MainPresenter implements MainProtocol.Presenter {

    private MainProtocol.View view;
    private final GetContacts getContacts;

    @Inject
    MainPresenter(GetContacts getContacts) {
        this.getContacts = getContacts;
    }

    @Override
    public void takeView(MainProtocol.View view) {
        this.view = view;
    }

    @Override
    public void dropView(MainProtocol.View view) {
        this.view = null;
    }

    @Override
    public void getContacts() {
        getContacts.execute(new GetContacts.Request())
                .subscribe(response -> {
                            if (view != null)
                                view.loadContactList(response.contacts());
                        },
                        throwable -> {
                            if (view != null)
                                view.loadErrorList();
                        });
    }
}
