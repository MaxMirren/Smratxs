package com.maxm.sorts.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

abstract class AbstractFragment : androidx.fragment.app.Fragment(){

    // Stores the link of current object to be used as this
    protected lateinit var thisObject: View
    // Stores layout resource id
    protected abstract val layoutResInt: Int

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        thisObject = inflater.inflate(layoutResInt, container, false)
        initialize()
        return thisObject
    }

    /**
     * Initializes fragment views data and behaviour
     */
    internal abstract fun initialize()
    }