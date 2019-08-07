package com.rishabhdeepsingh.metaapp.ui.chillzone

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.rishabhdeepsingh.metaapp.R

class ClassesFragment : Fragment() {
    private val LOG = ClassesFragment::class.toString()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.i(LOG, "[~~] onCreateView()")
        return inflater.inflate(R.layout.fragment_classes, container, false)
    }
}