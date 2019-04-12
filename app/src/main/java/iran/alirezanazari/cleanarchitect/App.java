package iran.alirezanazari.cleanarchitect;

import android.app.Application;

import iran.alirezanazari.cleanarchitect.di.components.ApplicationComponent;
import iran.alirezanazari.cleanarchitect.di.components.DaggerApplicationComponent;


public class App extends Application {

    private ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerApplicationComponent.builder()
                .setContext(this)
                .build();

    }

    public ApplicationComponent getComponent() {
        return component;
    }
}
