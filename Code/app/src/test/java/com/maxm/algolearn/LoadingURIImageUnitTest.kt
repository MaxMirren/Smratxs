package com.maxm.algolearn

import android.content.Context
import android.media.Image
import android.net.Uri
import android.widget.ImageView
import androidx.test.platform.app.InstrumentationRegistry
import com.bumptech.glide.Glide
import org.junit.Before
import org.junit.Test
import java.io.File
import java.net.URI


class LoadingURIImageUnitTest {

    lateinit var instrumentationContext: Context
    val assetPath = "///file/gifs/anim.gif"

    @Before
    fun setup() {
        instrumentationContext = InstrumentationRegistry.getInstrumentation().targetContext
    }

    @Test
    fun initAlgorithmsList_ResourcesFound() {
        val imageView = ImageView(instrumentationContext)
        val file = File(URI.create(assetPath).path)
        if (file.exists()) {
            Glide.with(imageView.context)
                .load(Uri.parse(assetPath))
                .into(imageView)
        }


    }
}