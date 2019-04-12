package iran.alirezanazari.cleanarchitect.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import javax.inject.Inject;

public class ImageLoader {

    private Context mContext;

    @Inject
    public ImageLoader(Context context) {
        this.mContext = context ;
    }

    public void load(String url , ImageView img){
        Glide.with(mContext).load(url).into(img);
    }
}
