package ru.trener.testingproject.ui.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import ru.trener.testingproject.R;
import ru.trener.testingproject.di.modules.VideoUrlsResponse;

public class VideosAdapter extends RecyclerView.Adapter<VideosAdapter.VideoViewHolder>{
    List<VideoUrlsResponse> videoUrlsResponseList = new ArrayList<>();
    VideoUrlsListener videoUrlsListener;

    public void setVideoUrlsResponseList(List<VideoUrlsResponse> videoUrlsResponseList) {
        this.videoUrlsResponseList = videoUrlsResponseList;
        notifyDataSetChanged();
    }

    public void setVideoUrlsListener(VideoUrlsListener videoUrlsListener) {
        this.videoUrlsListener = videoUrlsListener;
    }

    @NonNull
    @Override
    public VideoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_video,parent,false);
        return new VideoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VideoViewHolder holder, int position) {
        holder.bind(videoUrlsResponseList.get(position));
    }

    @Override
    public int getItemCount() {
        return videoUrlsResponseList.size();
    }

    class VideoViewHolder extends RecyclerView.ViewHolder {
        ImageView itemImage;
        public VideoViewHolder(@NonNull View itemView) {
            super(itemView);
            itemImage = itemView.findViewById(R.id.iv_video_item);
        }

        void bind(VideoUrlsResponse item){
            Glide.with(itemView).load(item.getUrl()).into(itemImage);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    videoUrlsListener.itemClickListener(item);
                }
            });
        }
    }

    interface VideoUrlsListener{
        void itemClickListener(VideoUrlsResponse item);
    }
}
