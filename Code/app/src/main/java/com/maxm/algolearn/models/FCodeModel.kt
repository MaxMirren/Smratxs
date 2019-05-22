package com.maxm.algolearn.models

import android.text.Spanned
import com.maxm.algolearn.utils.fromHtml

data class FCodeModel(val code: Spanned? = null,
                      val debug: Spanned? = null) {

    class Builder(var code: Spanned? = null,
                  var debug: Spanned? = null) {

        fun code(code: String) = apply { this@Builder.code = fromHtml(code) }


        fun debug(debug: String) = apply { this@Builder.debug = fromHtml(debug) }


        fun build() = FCodeModel(code, debug)

        @Suppress("unused")
        fun getModelInfo() = "code = $code, debug = $debug"
    }
}