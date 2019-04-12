package iran.alirezanazari.domain.intractor;

import javax.inject.Inject;
import javax.inject.Named;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import iran.alirezanazari.domain.entity.ChannelsVideo;
import iran.alirezanazari.domain.entity.ChannelsVideoParam;
import iran.alirezanazari.domain.repository.ChannelRepository;

public class GetChannelsVideo extends UseCase<ChannelsVideo , ChannelsVideoParam> {

    private ChannelRepository mRepository ;

    @Inject
    public GetChannelsVideo(ChannelRepository repository,
                            @Named("executor_thread") Scheduler io ,
                            @Named("ui_thread") Scheduler ui) {
        super(io , ui );
        this.mRepository = repository;
    }

    @Override
    public Observable<ChannelsVideo> build(ChannelsVideoParam param) {
        return mRepository.getChannelVideoLst(param.getId() , param.getCount());
    }


}
