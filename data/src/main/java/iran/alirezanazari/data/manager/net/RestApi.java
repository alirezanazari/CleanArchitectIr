package iran.alirezanazari.data.manager.net;


import io.reactivex.Observable;
import iran.alirezanazari.domain.entity.Channel;
import iran.alirezanazari.domain.entity.ChannelsVideo;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RestApi {


    @GET("profile/username/{id}/")
    Observable<Channel> getChannel(@Path("id") String id);

    @GET("videoByUser/username/{id}/perpage/{count}")
    Observable<ChannelsVideo> getChannelsVideo(@Path("id") String id , @Path("count") Integer count);

}
