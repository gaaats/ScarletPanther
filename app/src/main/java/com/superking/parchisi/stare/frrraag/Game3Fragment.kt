package com.superking.parchisi.stare.frrraag

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.superking.parchisi.stare.R
import com.superking.parchisi.stare.databinding.FragmentGame3Binding
import kotlinx.coroutines.delay


class Game3Fragment : Fragment() {

    private var fragmentGame3Binding: FragmentGame3Binding? = null
    private val binding
        get() = fragmentGame3Binding ?: throw RuntimeException("FragmentGame3Binding = null")

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        try {
            gtgtjoijtijogtjgjtjgt()
        } catch (e: Exception) {
            efrfrgtgttg5()
        }


        super.onViewCreated(view, savedInstanceState)
    }

    private fun gtgtjoijtijogtjgjtjgt() {
        lifecycleScope.launchWhenCreated {
            delay(2500)
            gtigtijtgiogtjjgtjgtji()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentGame3Binding = FragmentGame3Binding.inflate(inflater, container, false)
        return binding.root
    }


    private fun gtigtijtgiogtjjgtjgtji() {
        findNavController().navigate(R.id.action_game3Fragment_to_game2Fragment)
    }

    private fun efrfrgtgttg5() {
        Toast.makeText(
            requireContext(),
            "Error 999...",
            Toast.LENGTH_SHORT
        ).show()
        requireActivity().onBackPressed()
    }
}