package com.irfanirawansukirman.savingfragmentstatewithbnv

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val homeFragment = HomeFragment()
    private val checkoutFragment = OtherFragment()
    private val profileFragment = OtherFragment()
    private var activeFragment: Fragment = homeFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager
            .beginTransaction().apply {
            add(R.id.container, profileFragment, profileFragment::class.java.simpleName).hide(
                profileFragment
            )
            add(R.id.container, checkoutFragment, checkoutFragment::class.java.simpleName).hide(
                checkoutFragment
            )
            add(R.id.container, homeFragment, homeFragment::class.java.simpleName)
        }.commit()
        initListeners()
        bottomNavigationView.itemIconTintList = null
    }

    private fun initListeners() {
        bottomNavigationView.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.navigation_mindorks -> {
                    supportFragmentManager.beginTransaction().hide(activeFragment)
                        .show(homeFragment)
                        .commit()
                    activeFragment = homeFragment
                    true
                }

                R.id.navigation_afterAcademy -> {
                    supportFragmentManager.beginTransaction().hide(activeFragment)
                        .show(checkoutFragment).commit()
                    activeFragment = checkoutFragment
                    true
                }

                R.id.navigation_user -> {
                    supportFragmentManager.beginTransaction().hide(activeFragment)
                        .show(profileFragment)
                        .commit()
                    activeFragment = profileFragment
                    true
                }

                else -> false
            }
        }
    }
}
