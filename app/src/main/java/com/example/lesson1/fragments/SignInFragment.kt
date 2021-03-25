package com.example.lesson1.fragments

import android.content.Intent
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.lesson1.*
import kotlinx.android.synthetic.main.fragment_sign_in.*

class SignInFragment: Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_sign_in, container, false);
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        signUpSuggestionTextView.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction().apply {
                setReorderingAllowed(true)
                replace(R.id.container, signUpFragment)
                addToBackStack(null)
                commit()
            }
        }

        signInButton.setOnClickListener {
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()
            val permission = validate(email,password)


            if (permission) {
                val intent = Intent(activity, MainMenuActivity::class.java)

                val user = User(email,password)
                intent.putExtra("message",getString(R.string.signInGreeting))
                intent.putExtra("user",user)
                if(intent.resolveActivity(requireActivity().packageManager)!=null){
                    startActivity(intent)
                }
            } else {
                var firstBanner = ""
                var secondBanner = ""
                var banners = Bundle()

                 if ((email == "") or (email == "simpleEmail@pochta.kek"))  firstBanner += "\n"+getString(R.string.emailAlert)+"\n"
                   if (password == "" ) secondBanner += "\n"+getString(R.string.passwordAlert)+"\n"

               banners.putString("firstBanner",firstBanner)
                banners.putString("secondBanner",secondBanner)
                val dialog = CustomDialogFragment()
                dialog.arguments = banners
                dialog.show(requireActivity().supportFragmentManager, "Dialog fragment")

            }
        }
    }
     override   fun onPause() {
            super.onPause()
        }



    private fun validate(email:String,password:String): Boolean {

        return (email!="") and (email!=getString(R.string.example_email_authorization)) and(password!="")
    }
}
