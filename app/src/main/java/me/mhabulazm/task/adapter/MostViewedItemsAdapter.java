package me.mhabulazm.task.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

import me.mhabulazm.task.R;
import me.mhabulazm.task.api.response.Result;

/**
 * Created by mhabulazm on 3/18/19.
 * mhabulazm@gmail.com
 */
public class MostViewedItemsAdapter extends RecyclerView.Adapter<MostViewedItemsAdapter.ViewHolder> {
    private List<Result> results;
    private MostViewedItemClickListener mostViewedItemClickListener;

    public MostViewedItemsAdapter(List<Result> results,
                                  MostViewedItemClickListener mostViewedItemClickListener) {
        this.results = results;
        this.mostViewedItemClickListener = mostViewedItemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.list_item_most_viewed, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.bind(results.get(i));
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        final TextView headerTextView;
        final TextView dateTextView;
        final ImageView articleImageView;
        final TextView sourceTextView;
        final TextView lineTextView;


        ViewHolder(@NonNull View v) {
            super(v);
            headerTextView = v.findViewById(R.id.title);
            articleImageView = v.findViewById(R.id.itemImageView);
            dateTextView = v.findViewById(R.id.date);
            sourceTextView = v.findViewById(R.id.source);
            lineTextView = v.findViewById(R.id.byLine);
        }

        void bind(final Result item) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mostViewedItemClickListener != null) {
                        mostViewedItemClickListener.onItemClick(item);
                    }
                }
            });

            bindTextViews(item);

            Glide.with(articleImageView.getContext()).
                    load(item.getMedia().get(0).getMediaMetadata().get(0).getUrl())
                    .thumbnail(0.3f)
                    .apply(RequestOptions.circleCropTransform())
                    .into(articleImageView);
        }

        private void bindTextViews(Result item) {
            headerTextView.setText(item.getTitle());
            dateTextView.setText(item.getPublishedDate());
            sourceTextView.setText(item.getSource());
            lineTextView.setText(item.getByline());
        }
    }

    public interface MostViewedItemClickListener {
        void onItemClick(Result item);
    }

}
