package iran.alirezanazari.cleanarchitect.ui.activities.channelVideo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import iran.alirezanazari.cleanarchitect.R;
import iran.alirezanazari.cleanarchitect.ui.activities.BaseActivity;
import iran.alirezanazari.cleanarchitect.ui.adapter.ChannelVideoAdapter;
import iran.alirezanazari.domain.entity.ChannelsVideo;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import javax.inject.Inject;

public class ChannelPage extends BaseActivity implements ChannelPagePresenter.View {

    private String mChannelId = "";
    private int mPastVisibleItem, mVisibleItemCount, mTotalItemCount;
    private boolean isLoading = false;
    private boolean isEndOfList = false;
    private LinearLayoutManager mLayoutManager;

    @Inject
    ChannelPagePresenter presenter;
    @Inject
    ChannelVideoAdapter adapter;

    @BindView(R.id.channel_page_recycler)
    RecyclerView recyclerView;
    @BindView(R.id.channel_page_loader)
    ProgressBar loader;
    @BindView(R.id.channel_page_load_more)
    ProgressBar loadMore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getComponent().inject(this);
        getChannelIdFromIntent();
        setupRecyclerView();
        presenter.bindView(this);
        presenter.setChannelId(mChannelId);
        presenter.create();
        presenter.getVideoList(99 , false);

    }

    private void setupRecyclerView() {

        mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(adapter);
        setupLoadMore();

    }

    private void getChannelIdFromIntent() {
        try {
            mChannelId = getIntent().getExtras().getString("id");
        } catch (NullPointerException ex) {
            Toast.makeText(this , "No Id Received!!!" , Toast.LENGTH_SHORT).show();
            this.finish();
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_channel_page;
    }

    @Override
    public void setVideoList(ChannelsVideo videoList) {
        adapter.setData(videoList.getVideobyuser());
        stopLoader();
    }

    @Override
    public void startLoader() {
        isLoading = true;
        loader.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.GONE);
    }

    @Override
    public void stopLoader() {
        isLoading = false;
        loader.setVisibility(View.GONE);
        recyclerView.setVisibility(View.VISIBLE);
        loadMore.setVisibility(View.GONE);
    }

    @Override
    public void showLoadMore() {
        loadMore.setVisibility(View.VISIBLE);
    }

    @Override
    public void showMessage(String message) {
        stopLoader();
        Toast.makeText(this , message , Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        presenter.destroy();
        super.onDestroy();
    }

    private void setupLoadMore() {

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView , int dx , int dy) {

                if(dy > 0) {

                    if(isEndOfList) return;
                    if(isLoading) return; //check api was not in process

                    mVisibleItemCount = mLayoutManager.getChildCount();
                    mTotalItemCount = mLayoutManager.getItemCount();
                    mPastVisibleItem = mLayoutManager.findFirstVisibleItemPosition();

                    if((mVisibleItemCount + mPastVisibleItem) >= mTotalItemCount) {
                        Toast.makeText(ChannelPage.this , "End of list" , Toast.LENGTH_SHORT).show();
                        //Note : this api does not support pagination and this is just test
                        //presenter.getVideoList(99 , true);
                        isEndOfList = true ;
                    }
                }
            }
        });

    }
}
