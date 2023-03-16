package com.wreker.collegemajorproject.splashAndOnBoarding.viewPager

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.wreker.collegemajorproject.R
import com.wreker.collegemajorproject.databinding.FragmentViewPagerBinding
import com.wreker.collegemajorproject.splashAndOnBoarding.onBoarding.OnBoardingFragment1
import com.wreker.collegemajorproject.splashAndOnBoarding.onBoarding.OnBoardingFragment2
import com.wreker.collegemajorproject.splashAndOnBoarding.onBoarding.OnBoardingFragment3

class ViewPagerFragment : Fragment(R.layout.fragment_view_pager) {

    private var _binding : FragmentViewPagerBinding?=null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity as AppCompatActivity).supportActionBar!!.hide()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentViewPagerBinding.bind(view)

        val fragmentList = arrayListOf<Fragment>(
            OnBoardingFragment1(),
            OnBoardingFragment2(),
            OnBoardingFragment3()
        )

        val adapter = ViewPagerAdapter(fragmentList,
            requireActivity().supportFragmentManager,
            lifecycle
        )

        (activity as AppCompatActivity).supportActionBar!!.hide()

        binding.viewPager2.adapter = adapter
        binding.wormDotsIndicator.attachTo(binding.viewPager2)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}