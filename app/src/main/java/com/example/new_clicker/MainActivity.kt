package com.example.new_clicker

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.example.new_clicker.databinding.ActivityMainBinding
import androidx.fragment.app.Fragment
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import androidx.lifecycle.Lifecycle


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var settingsFragment: Settings
    lateinit var storeFragment: StoreFragment
    var n = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        settingsFragment = Settings()
        storeFragment = StoreFragment()
//        binding.button.setOnClickListener { ActivateSettingsFragment() }

        binding.settingsButton.setOnClickListener {
            ActivateSettingsFragment()
            binding.textView.text = n.toString()
            n++
        }

        binding.storeButton.setOnClickListener {
            ActivateStoreFragment()
        }
        //активирует сразу(или добавляет на экран) фрагмент
        /*supportFragmentManager.commit {
            add<Settings>(R.id.fragment_container_view)
        }*/
    }

    private fun showFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().setMaxLifecycle(fragment, Lifecycle.State.RESUMED)
            .show(fragment).commit()

    }

    private fun hideFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().setMaxLifecycle(fragment, Lifecycle.State.CREATED)
            .hide(fragment).commit()
    }

    fun ActivateSettingsFragment() {
        supportFragmentManager.commit {
            setReorderingAllowed(true)
//            add<Settings>(R.id.fragment_container_view)
            replace<Settings>(R.id.fragment_container_view)
            //addToBackStack("First tab")
        }
    }

    fun ActivateStoreFragment() {
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            replace<StoreFragment>(R.id.fragment_container_view)
        }
    }


}
