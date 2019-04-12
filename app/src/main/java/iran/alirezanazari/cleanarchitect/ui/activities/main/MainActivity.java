package iran.alirezanazari.cleanarchitect.ui.activities.main;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.OnClick;
import iran.alirezanazari.cleanarchitect.R;
import iran.alirezanazari.cleanarchitect.ui.activities.BaseActivity;
import iran.alirezanazari.cleanarchitect.ui.activities.channelVideo.ChannelPage;
import iran.alirezanazari.cleanarchitect.utils.ImageLoader;
import iran.alirezanazari.domain.entity.Channel;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import javax.inject.Inject;

public class MainActivity extends BaseActivity implements MainActivityPresenter.View {

    private final String CHANNEL_ID = "ali_rezanazari";

    @Inject MainActivityPresenter presenter;
    @Inject ImageLoader imageLoader ;

    @BindView(R.id.home_channel_loader) ProgressBar loader ;
    @BindView(R.id.home_channel_name) TextView channelName ;
    @BindView(R.id.home_channel_avatar) ImageView channelAvatar ;
    @BindView(R.id.home_channel_retry) ImageView retryBtn ;
    @BindView(R.id.home_channel_layout) LinearLayout channelLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getComponent().inject(this);
        presenter.bindView(this);
        presenter.setChannelId(CHANNEL_ID);
        presenter.create();
    }

    @OnClick(R.id.home_channel_layout)
    public void openChannelPage(View view){

        Intent go = new Intent(MainActivity.this , ChannelPage.class);
        go.putExtra("id" , CHANNEL_ID);
        startActivity(go);

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void setChannelInfo(Channel channel) {
        channelName.setText(channel.getProfile().getName() + "\n More Details...");
        imageLoader.load(channel.getProfile().getPic_m() , channelAvatar);
    }

    @Override
    public void startLoader() {
        channelName.setVisibility(View.GONE);
        channelAvatar.setVisibility(View.GONE);
        loader.setVisibility(View.VISIBLE);
        retryBtn.setVisibility(View.GONE);
    }

    @Override
    public void stopLoader() {
        channelName.setVisibility(View.VISIBLE);
        channelAvatar.setVisibility(View.VISIBLE);
        loader.setVisibility(View.GONE);
    }

    @Override
    public void showMessage(String msg) {

        //show retry
        stopLoader();
        Toast.makeText(this , "Error in connecting to server!!" , Toast.LENGTH_SHORT).show();
        retryBtn.setVisibility(View.VISIBLE);

    }

    @Override
    protected void onDestroy() {
        presenter.destroy();
        super.onDestroy();
    }

    @OnClick(R.id.home_channel_retry)
    public void retryLoadChannel(){
        presenter.getChannelInfo();
    }

}
