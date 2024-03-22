package com.example.meowbottomnavigationbar

import android.os.Bundle
import android.provider.ContactsContract.Profile
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.meowbottomnavigationbar.databinding.ActivityMainBinding
import com.example.meowbottomnavigationbar.fragments.HomeFragment
import com.example.meowbottomnavigationbar.fragments.ProfileFragment
import com.example.meowbottomnavigationbar.fragments.SettingsFragment
import com.qamar.curvedbottomnaviagtion.CurvedBottomNavigation

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.apply {
            bottomNavigation.add(CurvedBottomNavigation.Model(1, "Settings", R.drawable.ic_settings))
            bottomNavigation.add(CurvedBottomNavigation.Model(2, "Home", R.drawable.ic_home))
            bottomNavigation.add(CurvedBottomNavigation.Model(3, "Profile", R.drawable.ic_profile))

            bottomNavigation.setOnClickMenuListener {
                when (it.id) {
                    1 -> { replaceFragment(SettingsFragment()) }
                    2 -> { replaceFragment(HomeFragment()) }
                    3 -> { replaceFragment(ProfileFragment()) }
                }
            }

            // Default Bottom Tab Selected
            replaceFragment(HomeFragment())
            bottomNavigation.show(2)
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}