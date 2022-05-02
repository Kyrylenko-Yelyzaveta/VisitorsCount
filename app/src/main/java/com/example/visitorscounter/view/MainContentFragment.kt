package com.example.visitorscounter.view

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.visitorscounter.databinding.FragmentMainContentBinding
import com.example.visitorscounter.presentor.MainPresenter

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MainContent.newInstance] factory method to
 * create an instance of this fragment.
 */
class MainContent : Fragment() {
    private lateinit var binding: FragmentMainContentBinding

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val presenter = MainPresenter(activity?.applicationContext!!)
        binding = FragmentMainContentBinding.inflate(inflater)
        if (presenter.checkFirstRun()) {

            binding.mainView.loadUrl(presenter.getFromShared("link"))

            presenter.saveBooleanToShared(false)
        } else {
            binding.mainView.loadUrl(presenter.getFromShared("home"))

        }

        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = MainContent()
    }
}