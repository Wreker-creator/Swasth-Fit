package com.wreker.collegemajorproject.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.wreker.collegemajorproject.R
import com.wreker.collegemajorproject.databinding.FragmentNewsBinding

class NewsFragment : Fragment(R.layout.fragment_news) {

    private var _binding : FragmentNewsBinding?=null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentNewsBinding.bind(view)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}