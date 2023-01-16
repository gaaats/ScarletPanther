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


class SeeecMainFragment : Fragment() {

    lateinit var appssssssss: String
    private lateinit var mContexttttttttttt: Context

    val shareP: SharedPreferences by inject(named("SharedPreferences"))


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    val viewMainModelfrrffrrf by activityViewModel<ViMod>(named("MainModel"))
    lateinit var countryDevfrrfrf: String
    lateinit var wvfrrfrfrf: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_seeec_main, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContexttttttttttt = context
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewMainModelfrrffrrf.frrfrffrfrrf.observe(viewLifecycleOwner) {
            if (it != null) {
                val mainnnnnnnnnn = it.toString()
                shareP.edit().putString("mainId", mainnnnnnnnnn).apply()
            }
        }

        viewMainModelfrrffrrf.ggtgtgtgtthyhy.observe(viewLifecycleOwner) {
            if (it != null) {

                countryDevfrrfrf = it.geoooo
                appssssssss = it.appsCheckerrrrr
                wvfrrfrfrf = it.viewvvv

                jgtigtjtgjgtjigtjgt()
                shareP.edit().putString("apps", appssssssss).apply()
                shareP.edit().putString("wv", wvfrrfrfrf).apply()

                gttkgttgjigtjgtgtji()
            }
        }
    }

    private fun jgtigtjtgjgtjigtjgt() {
        shareP.edit().putString("countryDev", countryDevfrrfrf).apply()
    }

    private fun gttkgttgjigtjgtgtji() {
        gtgtgtjgtijtgjigtjjgt()
    }

    private fun gtgtgtjgtijtgjigtjjgt() {
        findNavController().navigate(R.id.action_seeecMainFragment_to_beeeeforFiiilFragment)
    }
}