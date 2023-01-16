package com.superking.parchisi.stare.cococococ

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.superking.parchisi.stare.R
import com.superking.parchisi.stare.modullles.ViMod
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.activityViewModel
import org.koin.core.qualifier.named


class BeeeeforFiiilFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    val gtgttggtgttg by activityViewModel<ViMod>(named("MainModel"))
    val gtgtgtgtgt: SharedPreferences by inject(named("SharedPreferences"))
    lateinit var gtgtgtgt: String
    private lateinit var vfbgbhnhnnhnhnh: Context


    override fun onAttach(context: Context) {
        super.onAttach(context)
        vfbgbhnhnnhnhnh = context
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_beeeefor_fiiil, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val checkFlyfrrffrfr = gtgtgtgtgt.getString("apps", null)
        val appsCampgtggtgt = gtgtgtgtgt.getString("appCamp", null)

        if (checkFlyfrrffrfr=="1" &&appsCampgtggtgt == null) {
            gtgttggtgttg.converssssssss(vfbgbhnhnnhnhnh)
            gtgttggtgttg.appsDatagtgt65tggt.observe(viewLifecycleOwner) {

                if (it != null) {

                    gtgtgtgt = it.toString()
                    gtgtgtgtgt.edit().putString("appCamp", gtgtgtgt).apply()
                    gtjigtjigtijgtjitgjjgt()
                }
            }
        } else {
            gtjigtjigtijgtjitgjjgt()
        }
    }

    private fun gtjigtjigtijgtjitgjjgt() {
        findNavController().navigate(R.id.action_beeeeforFiiilFragment_to_fiiilttterFragment)
    }

}