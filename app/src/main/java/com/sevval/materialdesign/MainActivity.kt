package com.sevval.materialdesign

import android.os.Bundle
import android.widget.AdapterView.OnItemClickListener
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputLayout


class MainActivity : AppCompatActivity() {

    lateinit var textInputLayoutSeason:TextInputLayout
    lateinit var autoCompleteTextSeason:AutoCompleteTextView
    lateinit var textView:TextView

    lateinit var arrayList_season:ArrayList<String>
    lateinit var arrayAdapter_season:ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textInputLayoutSeason=findViewById(R.id.textInputLayout_season)
        autoCompleteTextSeason=findViewById(R.id.autoCompleteText_season)
        textView=findViewById(R.id.textView)

        arrayList_season=ArrayList<String>()
        arrayList_season.add("Summer")
        arrayList_season.add("Autumn")
        arrayList_season.add("Winter")
        arrayList_season.add("Spring")

        arrayAdapter_season=ArrayAdapter(applicationContext, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,arrayList_season)
        autoCompleteTextSeason.setAdapter(arrayAdapter_season)
        autoCompleteTextSeason.threshold=1

        (textInputLayoutSeason.getEditText() as AutoCompleteTextView).onItemClickListener =
            OnItemClickListener { adapterView, view, position, id ->
                val selectedValue: String = arrayAdapter_season.getItem(position).toString()
                textView.setText(selectedValue)
            }








    }
}