package com.maxm.sorts.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

internal abstract class AbstractFragment : Fragment(){

    protected lateinit var thisObject: View
    protected abstract val layoutResInt: Int

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        thisObject = inflater.inflate(layoutResInt, container, false)
        initialize()
        return thisObject
    }

    internal abstract fun initialize()
    }