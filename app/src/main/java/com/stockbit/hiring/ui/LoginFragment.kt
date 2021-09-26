package com.stockbit.hiring.ui

import android.content.Intent
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import com.stockbit.hiring.R
import id.rizmaulana.sheenvalidator.lib.SheenValidator


class LoginFragment : Fragment() {

    lateinit var btnLogin: Button

    private lateinit var sheenValidator: SheenValidator
    private lateinit var tvEmail: EditText
    private lateinit var tvPassword: EditText
    private lateinit var textViewRegister: TextView

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

        textViewRegister = view.findViewById(R.id.textViewRegister)

        val text = "Belum punya akun? "
        val word = SpannableString(text)

        word.setSpan(ForegroundColorSpan(ContextCompat.getColor(requireContext(), R.color.black)),
                0, word.length,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)

        textViewRegister.text = word

        val text2 = "Daftar Sekarang"
        val word2 = SpannableString(text2)

        word2.setSpan(ForegroundColorSpan(ContextCompat.getColor(requireContext(), R.color.green)),
                0, word2.length,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)

        textViewRegister.append(word2)
    }
}