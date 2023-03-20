package com.wreker.collegemajorproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.wreker.collegemajorproject.databinding.ActivityMainBinding
import com.wreker.collegemajorproject.viewModel.SwasthFitViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var appBarConfiguration : AppBarConfiguration

    val viewModel1 : SwasthFitViewModel by lazy {
        ViewModelProvider(this)[SwasthFitViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val navController = navHostFragment.navController

        appBarConfiguration = AppBarConfiguration(
            topLevelDestinationIds = setOf(
                R.id.SplashFragment,
                R.id.FragmentHome,
                R.id.FragmentMCQ,
                R.id.FragmentNews
            ),
            drawerLayout = binding.drawerLayout
        )
        setupActionBarWithNavController(navController = navController, configuration = appBarConfiguration)

        binding.navView.setupWithNavController(navController)

        binding.navView.setCheckedItem(
            R.id.FragmentHome
        )

    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.fragmentContainerView)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }

}