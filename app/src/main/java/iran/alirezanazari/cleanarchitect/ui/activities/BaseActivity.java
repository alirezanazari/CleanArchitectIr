package iran.alirezanazari.cleanarchitect.ui.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.ButterKnife;
import iran.alirezanazari.cleanarchitect.App;
import iran.alirezanazari.cleanarchitect.di.components.ApplicationComponent;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
    }

    protected abstract int getLayoutId() ;

    protected ApplicationComponent getComponent(){
        return ((App) getApplication() ).getComponent();
    }

}
