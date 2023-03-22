package com.wreker.collegemajorproject.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.wreker.collegemajorproject.R
import com.wreker.collegemajorproject.databinding.FragmentHomeBinding
import com.wreker.collegemajorproject.databinding.FragmentOCRBinding

class OCRFragment : Fragment(R.layout.fragment_o_c_r) {

    private var _binding : FragmentOCRBinding?= null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentOCRBinding.bind(view)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}