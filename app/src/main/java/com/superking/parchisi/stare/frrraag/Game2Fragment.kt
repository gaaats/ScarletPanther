package com.superking.parchisi.stare.frrraag

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.superking.parchisi.stare.R
import com.superking.parchisi.stare.databinding.FragmentGame2Binding
import kotlin.random.Random


class Game2Fragment : Fragment() {

    private fun iogtojtjgtjtgjgtjjgtjgt(rrr: Int) {
        staaartBinding.imgEl2.setOnClickListener {
            gtmigjiojtjjgtjgtjjtgi(rrr)
            gtkgtkgtktg()
        }
    }

    private val names = listOf(
        "Sasha",
        "Grom",
        "Tor",
        "Loki",
        "Bros",
        "Lomo",
        "Jasper",
        "Walker",
        "Jason",
        "Brayden",
        "Cole",
        "Nathaniel",
        "George",
        "Lorenzo",
        "Zion",
        "Luis",
        "Archer",
        "Enzo",
        "Jonah",
        "Thiago",
        "Theo",
        "Ayden",
        "Zachary",
        "Calvin",
        "Braxton",
        "Ashton",
        "Rhett",
        "Atlas",
        "Jude",
        "Bentley",
        "Carlos",
        "Ryker",
        "Adriel",
        "Arthur",
        "Ace",
        "Tyler",
        "Jayce",
        "Max",
        "Elliot",
        "Graham",
        "Kaiden",
        "Maxwell",
        "Juan",
        "Dean",
        "Matteo",
        "Malachi",
        "Ivan",
        "Elliott",
        "Jesus",
        "Emiliano",
        "Messiah",
        "Gavin",

    ).shuffled()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentStaaartBinding = FragmentGame2Binding.inflate(inflater, container, false)
        return staaartBinding.root
    }

    private var fragmentStaaartBinding: FragmentGame2Binding? = null
    private val staaartBinding get() = fragmentStaaartBinding ?: throw RuntimeException("FragmentGame2Binding = null")

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        try {
            val rrr = Random.nextInt(from = 100, until = 1000)
            roijjgtijtgjtgjjgti(rrr)
            iogtojtjgtjtgjgtjjgtjgt(rrr)

        } catch (e: Exception){
            efrfrgtgttg5()
        }


        super.onViewCreated(view, savedInstanceState)
    }



    private fun roijjgtijtgjtgjjgti(rrr: Int) {
        staaartBinding.imgEl1.setOnClickListener {
            gtmigjiojtjjgtjgtjjtgi(rrr)
            gtkgtkgtktg()
        }
    }

    private fun gtmigjiojtjjgtjgtjjtgi(rrr: Int) {
        Toast.makeText(
            requireContext(),
            "${names.random()} receive ${rrr} bonus",
            Toast.LENGTH_SHORT
        ).show()
    }

    private fun gtkgtkgtktg() {
        kgitjiojgtojgtijgtjiogtj()
    }

    private fun kgitjiojgtojgtijgtjiogtj() {
        findNavController().navigate(R.id.action_game2Fragment_to_game3Fragment)
    }

    override fun onDestroy() {
        fragmentStaaartBinding = null
        super.onDestroy()
    }

    private fun efrfrgtgttg5() {
        Toast.makeText(
            requireContext(),
            "Error 999...",
            Toast.LENGTH_SHORT
        ).show()
        hkyhykhkykhy()
    }

    private fun hkyhykhkykhy() {
        requireActivity().onBackPressed()
    }
}