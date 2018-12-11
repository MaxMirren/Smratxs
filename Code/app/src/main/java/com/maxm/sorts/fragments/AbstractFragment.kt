package com.maxm.sorts.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

abstract class AbstractFragment : Fragment(){

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