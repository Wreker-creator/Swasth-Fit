package com.wreker.collegemajorproject.splashAndOnBoarding.onBoarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator
import com.wreker.collegemajorproject.R
import com.wreker.collegemajorproject.databinding.FragmentOnBoarding2Binding


class OnBoardingFragment2 : Fragment(R.layout.fragment_on_boarding2) {

    private var _binding : FragmentOnBoarding2Binding?=null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentOnBoarding2Binding.bind(view)

    }

    override fun onResume() {
        super.onResume()
        activity?.findViewById<WormDotsIndicator>(R.id.worm_dots_indicator)?.visibility = View.VISIBLE
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}