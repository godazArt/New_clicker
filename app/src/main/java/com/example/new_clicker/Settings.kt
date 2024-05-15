package com.example.new_clicker
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.fragment.app.commit
import com.example.new_clicker.databinding.SettingsBinding

class Settings : Fragment() {
    private var binding : SettingsBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SettingsBinding.inflate(layoutInflater)
        binding?.soundSwitch?.setOnClickListener{ }
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = SettingsBinding.inflate(inflater, container, false)
        binding?.fragmentField?.setOnClickListener{}
        requireActivity().onBackPressedDispatcher.addCallback(this) {
            parentFragmentManager.commit {
                parentFragmentManager.beginTransaction().remove(this@Settings).commit()
            }
        }
        binding?.containerRoot?.setOnClickListener {
            activity?.supportFragmentManager?.commit {
                remove(this@Settings)
            }
        }
        return binding?.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    companion object {
        @JvmStatic
        fun newInstance() = Settings()
    }
}