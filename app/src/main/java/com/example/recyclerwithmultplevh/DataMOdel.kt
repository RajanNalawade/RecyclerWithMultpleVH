package com.example.recyclerwithmultplevh

sealed class DataModel{
    data class ItemViewModel(val name: String, val email : String) : DataModel()
    data class HeaderData (val title : String, val desc : String) : DataModel()
}
