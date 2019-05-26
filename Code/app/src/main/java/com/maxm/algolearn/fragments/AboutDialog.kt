package com.maxm.algolearn.fragments

import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.maxm.algolearn.R
import androidx.appcompat.app.AlertDialog
import android.content.Intent
import android.net.Uri
import com.google.android.material.button.MaterialButton


class AboutDialog: DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(activity!!)
        val inflater = activity!!.layoutInflater
        val thisObject = inflater.inflate(R.layout.about_dialog, null)
        builder
            .setView(thisObject)
            .setIcon(R.mipmap.ic_launcher_algolearn_round)
            .setTitle(resources.getString(R.string.f_about_title))
        thisObject.findViewById<MaterialButton>(R.id.f_about_v_material_btn_close)!!.setOnClickListener {
            val uri = Uri.parse("https://play.google.com/store")
            this@AboutDialog.context!!.startActivity(Intent(Intent.ACTION_VIEW, uri))
        }
        thisObject.findViewById<MaterialButton>(R.id.f_about_v_material_btn_close)!!.setOnClickListener {
            this@AboutDialog.dialog!!.dismiss()
        }
        return builder.create()
    }
}