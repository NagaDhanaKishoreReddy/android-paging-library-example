package net.simplifiedcoding.androidpagingexample.Adapter;

import android.arch.paging.PagedListAdapter;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import net.simplifiedcoding.androidpagingexample.Model.PhotoItem;
import net.simplifiedcoding.androidpagingexample.R;

public class ItemAdapter extends PagedListAdapter<PhotoItem, ItemAdapter.ItemViewHolder> {

    private static final String BASE_URL = "https://farm5.staticflickr.com/";
    private static final String SLASH = "/";
    private static final String UNDER_SCORE = "_";
    private static final String DOT_JPG = ".jpg";
    private static DiffUtil.ItemCallback<PhotoItem> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<PhotoItem>() {
                @Override
                public boolean areItemsTheSame(PhotoItem oldItem, PhotoItem newItem) {
                    return oldItem.getId() == newItem.getId();
                }

                @Override
                public boolean areContentsTheSame(PhotoItem oldItem, PhotoItem newItem) {
                    return oldItem.equals(newItem);
                }
            };
    private Context mCtx;

    public ItemAdapter(Context mCtx) {
        super(DIFF_CALLBACK);
        this.mCtx = mCtx;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mCtx).inflate(R.layout.recyclerview_users, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        PhotoItem item = getItem(position);

        if (item != null) {
            holder.textView.setText(item.getTitle());
            String imageUrl = BASE_URL + item.getServer() + SLASH + item.getId() + UNDER_SCORE + item.getSecret() + DOT_JPG;
            Glide.with(mCtx)
                    .load(imageUrl)
                    .into(holder.imageView);
        } else {
            Toast.makeText(mCtx, "Item is null", Toast.LENGTH_LONG).show();
        }
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {

        TextView textView;
        ImageView imageView;

        public ItemViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textViewName);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }
}
