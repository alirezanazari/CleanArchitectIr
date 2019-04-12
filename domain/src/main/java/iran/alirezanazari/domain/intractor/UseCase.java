package iran.alirezanazari.domain.intractor;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;

public abstract class UseCase<T , P> {

    CompositeDisposable disposable ;
    Scheduler IoThread , UiThread ;

    public UseCase(Scheduler io , Scheduler ui) {
        this.IoThread = io ;
        this.UiThread = ui ;
        this.disposable = new CompositeDisposable();
    }

    public abstract Observable<T> build(P param);

    public void execute(DisposableObserver<T> observer , P param){

        Observable<T> observable = this.build(param)
                .subscribeOn(IoThread)
                .observeOn(UiThread);
        addDisposable(observable.subscribeWith(observer));

    }

    private void addDisposable(Disposable dispos){
        disposable.add(dispos);
    }

    public void clearDisposable(){
        if(!disposable.isDisposed()) disposable.dispose();
    }

}
