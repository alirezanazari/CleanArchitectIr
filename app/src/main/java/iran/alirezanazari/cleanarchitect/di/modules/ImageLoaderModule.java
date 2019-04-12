package iran.alirezanazari.cleanarchitect.di.modules;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import iran.alirezanazari.cleanarchitect.utils.ImageLoader;

@Module
public class ImageLoaderModule {

    @Singleton
    @Provides
    public ImageLoader imageLoader(Context context){
        return new ImageLoader(context);
    }
}
