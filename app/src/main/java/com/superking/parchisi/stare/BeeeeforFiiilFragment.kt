package com.superking.parchisi.stare

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.superking.parchisi.stare.modullles.ViMod
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.activityViewModel
import org.koin.core.qualifier.named


class BeeeeforFiiilFragment : Fragment() {
    val viewMainModel by activityViewModel<ViMod>(named("MainModel"))
    val shareP: SharedPreferences by inject(named("SharedPreferences"))
    lateinit var appCamp: String
    private lateinit var mContext: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_beeeefor_fiiil, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val checkFly = shareP.getString("apps", null)
        val appsCamp = shareP.getString("appCamp", null)

        if (checkFly=="1" &&appsCamp == null) {
            viewMainModel.convers(mContext)
            viewMainModel.appsData.observe(viewLifecycleOwner) {

                if (it != null) {
                    //delete later
                    Toast.makeText(requireContext(), "naming ${it}", Toast.LENGTH_SHORT).show()


                    appCamp = it.toString()
                    shareP.edit().putString("appCamp", appCamp).apply()
                    findNavController().navigate(R.id.action_beeeeforFiiilFragment_to_fiiilttterFragment)
                }
            }
        } else {
            findNavController().navigate(R.id.action_beeeeforFiiilFragment_to_fiiilttterFragment)
        }
    }

}