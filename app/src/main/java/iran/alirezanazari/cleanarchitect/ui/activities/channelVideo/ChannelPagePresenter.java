package iran.alirezanazari.cleanarchitect.ui.activities.channelVideo;

import javax.inject.Inject;

import io.reactivex.observers.DisposableObserver;
import iran.alirezanazari.cleanarchitect.ui.activities.BasePresenter;
import iran.alirezanazari.cleanarchitect.ui.activities.BaseView;
import iran.alirezanazari.cleanarchitect.ui.activities.Presenter;
import iran.alirezanazari.domain.entity.ChannelsVideo;
import iran.alirezanazari.domain.entity.ChannelsVideoParam;
import iran.alirezanazari.domain.intractor.GetChannelsVideo;

public class ChannelPagePresenter
        extends BasePresenter<ChannelPagePresenter.View> implements Presenter {

    private String mChannelId ;
    private GetChannelsVideo mChannelsVideoUseCase ;

    @Inject
    public ChannelPagePresenter(GetChannelsVideo usecase) {
        this.mChannelsVideoUseCase = usecase;
    }

    public void setChannelId(String channelId) {
        this.mChannelId = channelId;
    }

    public void getVideoList(int maxCount , boolean isShowLoadMore) {

        if(isShowLoadMore)
            getView().showLoadMore();
        else
            getView().startLoader();

        ChannelsVideoParam param = new ChannelsVideoParam();
        param.setId(mChannelId);
        param.setCount(maxCount);

        mChannelsVideoUseCase.execute(new DisposableObserver<ChannelsVideo>() {
            @Override
            public void onNext(ChannelsVideo value) {
                getView().setVideoList(value);
            }

            @Override
            public void onError(Throwable e) {
                getView().stopLoader();
                getView().showMessage(e.getMessage());
            }

            @Override
            public void onComplete() {
                getView().stopLoader();
            }
        } , param);
    }

    @Override
    public void create() {


    }

    @Override
    public void destroy() {
        mChannelsVideoUseCase.clearDisposable();
        unbindView();
    }

    public interface View extends BaseView {

        void setVideoList(ChannelsVideo videoList);

        void showLoadMore();

    }
}
