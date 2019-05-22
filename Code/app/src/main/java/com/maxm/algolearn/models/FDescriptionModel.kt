package com.maxm.algolearn.models

import android.graphics.drawable.Drawable

data class FDescriptionModel(val description: String,
                             val characteristics: String,
                             val img: Drawable) {

    class Builder() {

    }
}