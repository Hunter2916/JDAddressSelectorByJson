package com.hunter.jdaddressselectorbyjson

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import chihane.jdaddressselector.AddressSelector
import chihane.jdaddressselector.BottomDialog
import chihane.jdaddressselector.OnAddressSelectedListener
import chihane.jdaddressselector.model.City
import chihane.jdaddressselector.model.County
import chihane.jdaddressselector.model.Province
import chihane.jdaddressselector.model.Street
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), OnAddressSelectedListener {


    var dialog: BottomDialog? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        dialog = BottomDialog(this)
        val selector = AddressSelector(this)
        selector.onAddressSelectedListener = this
        frameLayout.addView(selector.view)
        buttonBottomDialog.setOnClickListener {
            dialog!!.setOnAddressSelectedListener(this)
            dialog!!.show()
        }
    }

    override fun onAddressSelected(province: Province?, city: City?, county: County?, street: Street?) {

        val s = (if (province == null) "" else province.id) + (if (city== null) "" else "\n" + city.id) + (if (county == null) "" else "\n" + county.id) +
                if (street == null) "" else "\n" + street.id
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show()
        dialog!!.dismiss()
    }
}
