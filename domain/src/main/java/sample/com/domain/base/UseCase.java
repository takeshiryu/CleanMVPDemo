package sample.com.domain.base;

import io.reactivex.Observable;
import io.reactivex.Scheduler;

public abstract class UseCase<Q extends UseCase.Request, P extends UseCase.Response> {

    private Scheduler io, main;

    protected UseCase(Scheduler io, Scheduler main) {
        this.io = io;
        this.main = main;
    }

    public Observable<P> execute(Q request) {
        return run(request)
                .subscribeOn(io)
                .observeOn(main);
    }

    protected abstract Observable<P> run(Q request);

    public interface Request {

    }

    public interface Response {

    }
}
