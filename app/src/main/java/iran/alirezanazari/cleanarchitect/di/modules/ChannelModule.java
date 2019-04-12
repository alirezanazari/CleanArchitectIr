package iran.alirezanazari.cleanarchitect.di.modules;


import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import iran.alirezanazari.data.manager.net.DataManager;
import iran.alirezanazari.data.repository.ChannelRepositoryImpl;
import iran.alirezanazari.domain.repository.ChannelRepository;

@Module
public class ChannelModule {

    @Singleton
    @Provides
    ChannelRepository getChannelRepository(DataManager dataManager){
        return new ChannelRepositoryImpl(dataManager);
    }

    @Singleton
    @Provides
    DataManager getDataManager(){
        return new DataManager();
    }

    @Named("executor_thread")
    @Provides
    Scheduler provideExecutorThread() {
        return Schedulers.io();
    }

    @Named("ui_thread")
    @Provides
    Scheduler provideUiThread() {
        return AndroidSchedulers.mainThread();
    }
}
