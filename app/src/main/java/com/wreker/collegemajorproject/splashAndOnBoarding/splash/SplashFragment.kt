package com.wreker.collegemajorproject.splashAndOnBoarding.splash

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import com.wreker.collegemajorproject.R
import com.wreker.collegemajorproject.databinding.FragmentSplashBinding


class SplashFragment : Fragment(R.layout.fragment_splash) {

    private var _binding : FragmentSplashBinding?= null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentSplashBinding.bind(view)

        Handler(Looper.getMainLooper()).postDelayed({

            if(onBoardingFinished()){
                //show home screen
                findNavController().navigate(R.id.action_splashFragment_to_HomeFragment)
            }else{
                //show on boarding
                findNavController().navigate(R.id.action_splashFragment_to_viewPagerFragment)
            }

        }, 1000)

        (activity as AppCompatActivity).supportActionBar!!.hide()

    }

    private fun onBoardingFinished() : Boolean{
        val sharedPref = requireActivity().getSharedPreferences("onBoarding", Context.MODE_PRIVATE)
        return sharedPref.getBoolean("finished", false)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}