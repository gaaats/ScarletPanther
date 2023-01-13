package com.superking.parchisi.stare.frrraag

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.superking.parchisi.stare.R
import com.superking.parchisi.stare.databinding.FragmentGamq1Binding


class Gamq1Fragment : Fragment() {


    private var fragmentGamq1Binding: FragmentGamq1Binding? = null
    private val gtgyhujuju get() = fragmentGamq1Binding ?: throw RuntimeException("FragmentGamq1Binding = null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentGamq1Binding = FragmentGamq1Binding.inflate(inflater, container, false)
        return gtgyhujuju.root
    }

    private fun gtjigijgtjgtjgtjjtgijtgijgtj() {
        Snackbar.make(
            gtgyhujuju.root,
            "Some error...",
            Snackbar.LENGTH_LONG
        ).show()
        requireActivity().onBackPressed()
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        try {

            rijjfrfojrfojrfo()

        } catch (e: Exception) {
            gtjigijgtjgtjgtjjtgijtgijgtj()
        }


        super.onViewCreated(view, savedInstanceState)
    }

    private fun rijjfrfojrfojrfo() {
        gtgyhujuju.btnPlayGame.setOnClickListener {
            rfrfjjrfjirfjirfjrf()
        }
    }

    private fun rfrfjjrfjirfjirfjrf() {
        findNavController().navigate(R.id.action_gamq1Fragment_to_game2Fragment)
    }

    override fun onDestroy() {
        fragmentGamq1Binding = null
        super.onDestroy()
    }

}