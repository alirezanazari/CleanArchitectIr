package iran.alirezanazari.cleanarchitect.di.components;

import android.app.Activity;
import android.content.Context;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import iran.alirezanazari.cleanarchitect.App;
import iran.alirezanazari.cleanarchitect.di.modules.ChannelModule;
import iran.alirezanazari.cleanarchitect.di.modules.ImageLoaderModule;
import iran.alirezanazari.cleanarchitect.ui.activities.BaseActivity;
import iran.alirezanazari.cleanarchitect.ui.activities.channelVideo.ChannelPage;
import iran.alirezanazari.cleanarchitect.ui.activities.main.MainActivity;

@Singleton
@Component(modules = {ImageLoaderModule.class , ChannelModule.class})
public interface ApplicationComponent {

    void inject(MainActivity activity);
    void inject(ChannelPage activity);

    @Component.Builder
    interface Builder{

        ApplicationComponent build();

        @BindsInstance
        Builder setContext(Context context);

    }
}
