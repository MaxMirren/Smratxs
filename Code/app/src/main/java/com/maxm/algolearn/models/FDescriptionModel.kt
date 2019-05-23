package com.maxm.algolearn.models

import android.text.Spanned
import com.maxm.algolearn.utils.fromHtml


data class FDescriptionModel(val description: String? = null,
                             val characteristics: Spanned? = null,
                             val imgAssetPath: String? = null) {

    class Builder(private var description: String? = null,
                  private var characteristics: Spanned? = null,
                  private var imgAssetPath: String? = null) {

        fun description(description: String) = apply { this@Builder.description = description }


        fun characteristics(characteristics: String) = apply { this@Builder.characteristics = fromHtml(characteristics) }

        fun imgAssetPath(imgAssetPath: String) = apply { this@Builder.imgAssetPath = imgAssetPath }

        fun build() = FDescriptionModel(description, characteristics, imgAssetPath)

        @Suppress("unused")
        fun getModelInfo() = "description = $description, characteristics = $characteristics, imgAssetPath = $imgAssetPath"

    }
}