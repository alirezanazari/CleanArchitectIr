package iran.alirezanazari.cleanarchitect.ui.activities.main;


import android.view.View;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import iran.alirezanazari.cleanarchitect.ui.activities.BasePresenter;
import iran.alirezanazari.cleanarchitect.ui.activities.BaseView;
import iran.alirezanazari.cleanarchitect.ui.activities.Presenter;
import iran.alirezanazari.domain.entity.Channel;
import iran.alirezanazari.domain.intractor.GetChannel;

public class MainActivityPresenter
        extends BasePresenter<MainActivityPresenter.View> implements Presenter {

    private GetChannel getChannelUseCase;
    private String mChannelId ;

    @Inject
    public MainActivityPresenter(GetChannel getChannelUseCase) {
        this.getChannelUseCase = getChannelUseCase;
    }

    public void setChannelId(String channelId) {
        this.mChannelId = channelId;
    }

    public void getChannelInfo() {

        getView().startLoader();
        getChannelUseCase.execute(new DisposableObserver<Channel>() {
            @Override
            public void onNext(Channel value) {getView().setChannelInfo(value);}

            @Override
            public void onError(Throwable e) {getView().showMessage(e.getMessage());}

            @Override
            public void onComplete() {getView().stopLoader();}

        } , mChannelId);

    }



    @Override
    public void create() {

        getChannelInfo();
    }

    @Override
    public void destroy() {

        unbindView();
        getChannelUseCase.clearDisposable();

    }

    public interface View extends BaseView {

        void setChannelInfo(Channel channelInfo);

    }

}
