package com.example.week3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.week3.databinding.FragmentPannelBinding

/**
 * A simple [Fragment] subclass.
 * Use the [PannelFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PannelFragment(val imgRes: Int) : Fragment() {

    lateinit var binding: FragmentPannelBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPannelBinding.inflate(inflater, container, false)
        binding.pannelImageIv.setImageResource(imgRes)
        return binding.root
    }
}