package com.rishabhdeepsingh.metaapp.ui.chillzone

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.rishabhdeepsingh.metaapp.R

class TodayFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.chillzone_today, container, false)
    }
}