package com.example.lesson1.fragments

import android.content.Intent
import android.os.Bundle
import android.service.autofill.Validators.and
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.lesson1.*
import kotlinx.android.synthetic.main.fragment_sign_in.*
import kotlinx.android.synthetic.main.fragment_sign_up.*
import kotlinx.android.synthetic.main.fragment_sign_up.emailEditText
import kotlinx.android.synthetic.main.fragment_sign_up.passwordEditText

class SignUpFragment:Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_sign_up,container,false);
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
         logInTextView.setOnClickListener{
             requireActivity().supportFragmentManager.beginTransaction().apply {
                 setReorderingAllowed(true)
                 replace(R.id.container, signInFragment)
                 addToBackStack(null)
                 commit()
         }
    }
        RegistrationButton.setOnClickListener {
            val email= emailEditText.text.toString()
            val name =nameEditText.text.toString()
            val secondName = secondNameEditText.text.toString()
            val password = passwordEditText.text.toString()
            val submitPassword =submitPasswordEditText.text.toString()
            val permission = validate(email,name,secondName,password,submitPassword)
            if (permission) {
             val intent = Intent(activity, MainMenuActivity::class.java)
                val user = User(email,password)
                intent.putExtra("message",getString(R.string.signUpGreeting))
                intent.putExtra("user",user)
                if(intent.resolveActivity(requireActivity().packageManager)!=null){
                      startActivity(intent)
                }
            }
            else {
                var firstBanner = ""
                var secondBanner = ""
                var thirdBanner = ""
                var fourthBanner = ""
                var fifthBanner = ""
                var sixthBanner = ""

                var arguments = Bundle()
                //куча if как-то некрасиво,но не знаю,как еще сделать
                if ((email == "") or (email == getString(R.string.example_email_authorization) )) firstBanner += "\n"+getString(R.string.emailAlert)+"\n"
                if (name == "" ) secondBanner += "\n"+ getString(R.string.nameAlert)+"\n"
                if (secondName == "" ) thirdBanner += "\n"+getString(R.string.secondNameAlert)+"\n"
                if (password== "" ) fourthBanner += "\n"+getString(R.string.passwordAlert)+"\n"
                if ((password.toCharArray().size<8 )and (password!="")) fifthBanner += "\n"+getString(R.string.smallPasswordAlert)+"\n"
                if ((submitPassword != password) and(password.toCharArray().size>8 ) and (password!="")) fifthBanner += "\n"+getString(R.string.submitPasswordAlert)+"\n"

                arguments.putString("firstBanner",firstBanner)
                arguments.putString("secondBanner",secondBanner)
                arguments.putString("thirdBanner",thirdBanner)
                arguments.putString("fourthBanner",fourthBanner)
                arguments.putString("fifthBanner",fifthBanner)
                arguments.putString("sixthBanner",sixthBanner)
                arguments.putString("Fragment","SignUp")
                val dialog = CustomDialogFragment()
                dialog.arguments = arguments
                dialog.show(requireActivity().supportFragmentManager, "Dialog fragment")

            }

        }
    }

    override fun onPause() {
        super.onPause()
    }
    private fun validate(email:String,name:String,secondName:String,password:String,submitPassword:String): Boolean {

        return (email!="") and (email!="simpleEmail@pochta.kek") and (name!= "") and (secondName!="") and (password!="")and (password.toCharArray().size>8) and(submitPassword ==password)
    }
}