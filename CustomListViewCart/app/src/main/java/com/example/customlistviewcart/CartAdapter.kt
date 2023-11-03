package com.example.customlistviewcart

class CartAdapter(val title:String, val description:String, val img:Int, var checked:Boolean) {
    fun isChecked(): Boolean {
        return checked
    }
}