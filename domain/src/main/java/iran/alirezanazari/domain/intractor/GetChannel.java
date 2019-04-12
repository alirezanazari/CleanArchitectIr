package iran.alirezanazari.domain.intractor;

import javax.inject.Inject;
import javax.inject.Named;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import iran.alirezanazari.domain.entity.Channel;
import iran.alirezanazari.domain.repository.ChannelRepository;

public class GetChannel extends UseCase<Channel , String> {

    private ChannelRepository mRepository;

    @Inject
    public GetChannel(ChannelRepository repository ,
                      @Named("executor_thread")Scheduler io ,
                      @Named("ui_thread") Scheduler ui) {
        super(io , ui );
        this.mRepository = repository;
    }

    @Override
    public Observable<Channel> build(String id) {
        return mRepository.getChannel(id);
    }


}
