package com.wreker.collegemajorproject.splashAndOnBoarding.onBoarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.wreker.collegemajorproject.R
import com.wreker.collegemajorproject.databinding.FragmentOnBoarding1Binding


class OnBoardingFragment1 : Fragment(R.layout.fragment_on_boarding1) {

    private var _binding : FragmentOnBoarding1Binding?=null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentOnBoarding1Binding.bind(view)



    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}