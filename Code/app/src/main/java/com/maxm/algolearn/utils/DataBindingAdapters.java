package com.maxm.algolearn.utils;

import android.net.Uri;
import android.widget.ImageView;
import androidx.databinding.BindingAdapter;
import com.bumptech.glide.Glide;

public class DataBindingAdapters {

    @BindingAdapter("app:imgFromAssetPath")
    public static void imgFromAssetPath(ImageView imageView, String assetPath) {
        Glide.with(imageView.getContext())
                .load(Uri.parse(assetPath))
                .into(imageView);
    }

}
