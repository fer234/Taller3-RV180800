package edu.udb.mvvm.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData
import edu.udb.mvvm.model.Registro

class MainViewModel: ViewModel() {
    var lst = MutableLiveData<ArrayList<Registro>>()
    var newlist = arrayListOf<Registro>()

    fun add(blog: Registro){
        newlist.add(blog)
        lst.value=newlist
    }

    fun remove(blog: Registro){
        newlist.remove(blog)
        lst.value=newlist
    }
}