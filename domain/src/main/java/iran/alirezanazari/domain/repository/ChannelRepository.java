package iran.alirezanazari.domain.repository;

import io.reactivex.Observable;
import iran.alirezanazari.domain.entity.Channel;
import iran.alirezanazari.domain.entity.ChannelsVideo;

public interface ChannelRepository {

    Observable<Channel> getChannel(String id);

    Observable<ChannelsVideo> getChannelVideoLst(String id , Integer page);
}
