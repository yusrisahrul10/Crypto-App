package com.stockbit.hiring.ui

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.navigation.fragment.findNavController
import com.stockbit.hiring.R
import id.rizmaulana.sheenvalidator.lib.SheenValidator


class LoginFragment : Fragment() {

    lateinit var btnLogin: Button

    private lateinit var sheenValidator: SheenValidator
    private lateinit var tvEmail: EditText
    private lateinit var tvPassword: EditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_login, container, false)
        bindView(root)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sheenValidator = SheenValidator(requireContext())

        sheenValidator.registerAsEmail(tvEmail)
        sheenValidator.registerAsRequired(tvEmail)
        sheenValidator.registerAsRequired(tvPassword)



        btnLogin.setOnClickListener {
            sheenValidator.validate()
        }

        sheenValidator.setOnValidatorListener {
            val action = LoginFragmentDirections.actionLoginFragmentToWatchListFragment()
            findNavController().navigate(action)
//            startActivity(Intent(requireContext(), WatchlistActivity::class.java))
        }
    }

    private fun bindView(view: View) {
        btnLogin = view.findViewById(R.id.btnLogin)
        tvEmail = view.findViewById(R.id.editTextEmail)
        tvPassword = view.findViewById(R.id.editTextPassword)
    }
}