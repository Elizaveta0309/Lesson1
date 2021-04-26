package com.example.lesson1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.lesson1.fragments.CustomDialogFragment
import com.example.lesson1.fragments.SignInFragment
import com.example.lesson1.fragments.SignUpFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_sign_in.*

val signUpFragment = SignUpFragment()
val signInFragment = SignInFragment()

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().apply {
            setReorderingAllowed(true)
            add(R.id.container, signInFragment)
            addToBackStack(null)
            commit()
        }




    }
}

