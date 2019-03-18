package me.mhabulazm.task.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import me.mhabulazm.task.R;
import me.mhabulazm.task.api.response.Result;

/**
 * Created by mhabulazm on 3/19/19.
 * mhabulazm@gmail.com
 */
public class ItemDetailsFragment extends Fragment {
    private static final String KEY_RESULT = "RESULT";
    private Result result;
    private ImageView articleImageView;
    private TextView titleTextView, detailsTextView;

    public static ItemDetailsFragment newInstance(Result result) {
        Bundle args = new Bundle();
        ItemDetailsFragment fragment = new ItemDetailsFragment();
        args.putParcelable(KEY_RESULT, result);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item_details, container, false);
        articleImageView = view.findViewById(R.id.articleImageView);
        titleTextView = view.findViewById(R.id.titleTextView);
        detailsTextView = view.findViewById(R.id.articleTextView);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            result = getArguments().getParcelable(KEY_RESULT);
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (result != null) {
            String url = result.getMedia().get(0).getMediaMetadata().get(0).getUrl();
            Glide.with(this)
                    .load(url)
                    .thumbnail(0.3f)
                    .into(articleImageView);

            titleTextView.setText(result.getTitle());
            detailsTextView.setText(result.getAbstract());
        }
    }
}
