package com.example.new_clicker
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.fragment.app.commit
import com.example.new_clicker.databinding.FragmentStoreBinding

class StoreFragment : Fragment() {
    private var binding : FragmentStoreBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentStoreBinding.inflate(layoutInflater)
        binding?.buy1?.setOnClickListener{ }
        binding?.buy2?.setOnClickListener{ }
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentStoreBinding.inflate(inflater, container, false)
        binding?.fragmentField?.setOnClickListener{}
        requireActivity().onBackPressedDispatcher.addCallback(this) {
            parentFragmentManager.commit {
                parentFragmentManager.beginTransaction().remove(this@StoreFragment).commit()
            }
        }
        binding?.containerRoot?.setOnClickListener {
            activity?.supportFragmentManager?.commit {
                remove(this@StoreFragment)
            }
        }

        binding?.closeStoreButton?.setOnClickListener{
            activity?.supportFragmentManager?.commit {
                remove(this@StoreFragment)
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