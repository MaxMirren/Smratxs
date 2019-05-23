package com.maxm.algolearn.fragments

import androidx.fragment.app.DialogFragment
import android.os.Bundle
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import com.maxm.algolearn.R


class AboutDialog: DialogFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.about_dialog, container, false)
        dialog!!.setTitle("Simple Dialog")
        return rootView
    }

}