package com.example.lesson1.fragments

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.lesson1.R
import kotlinx.android.synthetic.main.fragment_dialog.*



class CustomDialogFragment: DialogFragment() {
    private val TAG:String ="Dialog fragment"
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_dialog, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var b = arguments
       val s1= arguments?.getString("firstBanner")
        val s2= arguments?.getString("secondBanner")
        if(arguments?.getString("Fragment") == "SignUp") //Проверочка,чтобы не выводилась куча null,т.к s3-s6 инициализуются только в SignUpFragment
        {
        val s3= arguments?.getString("thirdBanner")
        val s4= arguments?.getString("fourthBanner")
        val s5= arguments?.getString("fifthBanner")
        val s6= arguments?.getString("sixthBanner")
            alertTextView.text =s1+s2+s3+s4+s5+s6
        }
        else alertTextView.text =s1+s2




    }







}