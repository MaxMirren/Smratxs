package com.maxm.algolearn.utils;

import android.widget.ImageView;
import androidx.annotation.DrawableRes;
import androidx.databinding.BindingAdapter;

public class DataBindingAdapters {

    @BindingAdapter("app:imgFromDrawableRes")
    public static void setPaddingLeft(ImageView imageView, @DrawableRes int drawableResource) {
        imageView.setImageDrawable(imageView.getContext().getDrawable(drawableResource));
    }

}
