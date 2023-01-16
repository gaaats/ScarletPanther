package com.superking.parchisi.stare.cococococ

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.superking.parchisi.stare.R
import com.superking.parchisi.stare.modullles.ViMod
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.activityViewModel
import org.koin.core.qualifier.named

class MainnnnnnFragment : Fragment() {


    val gttggtgtgt: SharedPreferences by inject(named("SharedPreferences"))
    val gtgthyhyhyyhhyhyhy by activityViewModel<ViMod>(named("MainModel"))

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_mainnnnnn, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContextgfgtgtgtgt=context
    }
    private lateinit var mContextgfgtgtgtgt: Context
    lateinit var gtgtgtgtgtgt: String

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        gtgthyhyhyyhhyhyhy.fbDeeeeeeeee(mContextgfgtgtgtgt)

        gigtjojgtjgtjgtjgt()

    }

    private fun gigtjojgtjgtjgtjgt() {
        findNavController().navigate(R.id.action_mainnnnnnFragment_to_couuuntryFragment)
    }
}