package sample.com.cleanmvp.presentation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.support.DaggerAppCompatActivity;
import sample.com.cleanmvp.R;
import sample.com.domain.base.Contact;

public class MainActivity extends DaggerAppCompatActivity implements MainProtocol.View {

    @BindView(R.id.rv)
    RecyclerView rv;

    @Inject
    MainPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        presenter.getContacts();
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.takeView(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.dropView(this);
    }

    @Override
    public void loadContactList(List<Contact> contacts) {
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(new ContactAdapter(contacts));
    }

    @Override
    public void loadErrorList() {

    }
}
