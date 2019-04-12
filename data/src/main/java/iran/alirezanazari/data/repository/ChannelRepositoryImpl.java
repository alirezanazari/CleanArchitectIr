package iran.alirezanazari.data.repository;



import io.reactivex.Observable;
import iran.alirezanazari.data.manager.net.DataManager;
import iran.alirezanazari.domain.entity.Channel;
import iran.alirezanazari.domain.entity.ChannelsVideo;
import iran.alirezanazari.domain.repository.ChannelRepository;

public class ChannelRepositoryImpl implements ChannelRepository {


    private DataManager mDataManager;

    public ChannelRepositoryImpl(DataManager dataManager) {
        this.mDataManager = dataManager;
    }

    @Override
    public Observable<Channel> getChannel(String id) {
        return mDataManager.getChannel(id);
    }

    @Override
    public Observable<ChannelsVideo> getChannelVideoLst(String id , Integer count) {
        return mDataManager.getChannelsVideos(id , count);
    }

}
