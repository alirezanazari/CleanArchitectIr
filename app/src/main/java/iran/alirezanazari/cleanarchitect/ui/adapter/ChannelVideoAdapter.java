package iran.alirezanazari.cleanarchitect.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import iran.alirezanazari.cleanarchitect.R;
import iran.alirezanazari.cleanarchitect.utils.ImageLoader;
import iran.alirezanazari.domain.entity.ChannelsVideo;

public class ChannelVideoAdapter extends RecyclerView.Adapter<ChannelVideoAdapter.ViewHolder >{

    private List<ChannelsVideo.VideoByUser> items =  new ArrayList<>();
    private Context mContext ;
    private ImageLoader mImageLoader ;

    @Inject
    public ChannelVideoAdapter(Context context , ImageLoader imageLoader) {
        this.mContext = context ;
        this.mImageLoader = imageLoader ;
    }

    public void setData(List<ChannelsVideo.VideoByUser> items) {
        this.items.addAll(items);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent , int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.row_channel_video , parent , false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder , int position) {

        holder.bind(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.row_video_list_video_cover) ImageView cover ;
        @BindView(R.id.row_video_list_video_title) TextView title ;
        @BindView(R.id.row_video_list_video_item) CardView item ;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this , itemView);
        }

        public void bind(ChannelsVideo.VideoByUser video){

            title.setText(video.getTitle());
            mImageLoader.load(video.getSmall_poster() , cover);
            item.setOnClickListener(v -> {
                Toast.makeText(mContext , "visited count : " + video.getVisit_cnt() , Toast.LENGTH_SHORT).show();
            });
        }

    }
}
