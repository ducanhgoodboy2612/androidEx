package com.example.radiokotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable

import android.text.TextWatcher

import android.view.Gravity

import android.view.LayoutInflater

import android.view.View

import android.widget.ArrayAdapter

import android.widget.Button

import android.widget.EditText

import android.widget.ListView
import android.widget.RadioButton
import android.widget.TextView

import android.widget.Toast

class MainActivity : AppCompatActivity() {
    internal var ans1: String = "";
    internal var ans2: String = "";
    internal var ans3: String = "";
    var onResult: View.OnClickListener = View.OnClickListener {
        var textView: TextView
        var hvt : String
        var name = findViewById(R.id.ethoten) as EditText
        hvt = name.text.toString()

        var strSo1 = "$hvt dung cau hinh $ans1"
        textView = findViewById(R.id.txtKq)
        textView.text = strSo1
        var strSo2 = "RAM $ans2, SSD $ans3"
        textView = findViewById(R.id.txtKq2)
        textView.text = strSo2
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var mbutton = findViewById(R.id.btnRes) as Button
        mbutton.setOnClickListener(onResult)
    }
    fun onRadioButtonClicked1(view: View){
        var mRam4 = findViewById(R.id.rb4g) as RadioButton
        var mRam8 = findViewById(R.id.rb8g) as RadioButton
        var mRam16 = findViewById(R.id.rb16g) as RadioButton
        var mRam32 = findViewById(R.id.rb32g) as RadioButton

        var ssd128 = findViewById(R.id.rb4g) as RadioButton
        var ssd256 = findViewById(R.id.rb8g) as RadioButton
        var ssd512 = findViewById(R.id.rb16g) as RadioButton
        var ssd1024 = findViewById(R.id.rb32g) as RadioButton

        mRam4.setEnabled(false)

        var checked = (view as RadioButton).isChecked
        when(view.getId()){
            R.id.rbthap -> if(checked){

            }
            R.id.rbtbinh -> if(checked){

            }
            R.id.rbcao -> if(checked){

            }
        }
        fun onRadioButtonClicked2(view: View){
            val checked = (view as RadioButton).isChecked
            when(view.getId()){
                R.id.rb4g -> if(checked)
                    ans2 = "4g"
                R.id.rb8g -> if(checked)
                    ans2 = "8g"
                R.id.rb16g -> if(checked)
                    ans2 = "16g"
                R.id.rb32g -> if(checked)
                    ans2 = "32g"
            }
        }
        fun onRadioButtonClicked3(view: View){
            val checked = (view as RadioButton).isChecked
            when(view.getId()){
                R.id.rb128 -> if(checked)
                    ans2 = "128g"
                R.id.rb256 -> if(checked)
                    ans2 = "256g"
                R.id.rb512 -> if(checked)
                    ans2 = "512g"
                R.id.rb1024 -> if(checked)
                    ans2 = "1024g"
            }
        }
    }
}