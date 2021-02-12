package com.kuldeepKotlin.sharedpreferenekotlin

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var sharedP : SharedPreferences? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       btnAdd.setOnClickListener {

           sharedP = getSharedPreferences("addProduct", Context.MODE_PRIVATE)
           var editor = sharedP?.edit()

           editor?.putString("product_input", edtProduct.text.toString())
           editor?.commit()

           Toast.makeText(this@MainActivity,"Successfully added!",Toast.LENGTH_SHORT).show()

           edtProduct.text.clear()
       }

        btnGetProduct.setOnClickListener {

            txtProductName.text = sharedP?.getString("product_input","null")

        }



    }
}