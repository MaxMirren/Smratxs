package com.maxm.sorts.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

abstract class AbstractFragment() : Fragment(){

    lateinit var thisObject: View
    internal abstract val layoutResInt: Int

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        thisObject = inflater.inflate(layoutResInt, container, false)
        initialize()
        return thisObject
    }

    internal abstract fun initialize()
    }