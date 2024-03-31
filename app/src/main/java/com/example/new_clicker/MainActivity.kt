package com.example.new_clicker

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.example.new_clicker.databinding.ActivityMainBinding
import androidx.fragment.app.Fragment
import androidx.fragment.app.add
import androidx.fragment.app.commit


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var settingsFragment: Settings
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        settingsFragment = Settings()
//        binding.button.setOnClickListener { ActivateSettingsFragment() }

        binding.settingsButton.setOnClickListener {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add<Settings>(R.id.fragment_container_view)
            }
        }

    }
        /* fun ActivateSettingsFragment() {


         }*/


}
