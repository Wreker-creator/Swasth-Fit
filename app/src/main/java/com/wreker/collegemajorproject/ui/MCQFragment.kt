package com.wreker.collegemajorproject.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.wreker.collegemajorproject.R
import com.wreker.collegemajorproject.databinding.FragmentMCQBinding


class MCQFragment : Fragment(R.layout.fragment_m_c_q) {

    private var _binding : FragmentMCQBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentMCQBinding.bind(view)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}