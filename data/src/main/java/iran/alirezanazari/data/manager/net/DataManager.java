package iran.alirezanazari.data.manager.net;

import javax.inject.Inject;

import io.reactivex.Observable;
import iran.alirezanazari.domain.entity.Channel;
import iran.alirezanazari.domain.entity.ChannelsVideo;

public class DataManager {

    //private static DataManager INSTANCE = new DataManager();
    private RestApi mRestApi;

    public DataManager() {

        ApiConfig apiConfig = new ApiConfig();
        mRestApi = apiConfig.getApi();
    }

    /*public static DataManager getInstance() {
        return INSTANCE;
    }*/

    public Observable<Channel> getChannel(String id){
        //check db , cache if exists
        return mRestApi.getChannel(id);
    }

    public Observable<ChannelsVideo> getChannelsVideos(String id , Integer count){
        //check db , cache if exists
        return mRestApi.getChannelsVideo(id , count);
    }


}
