package com.android.ubertest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {

    private val despensaFirebase : DespensaFirebase = DespensaFirebase()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    var latestItem:Item = Item("","",0)
    fun agregaItem(view: View){
        latestItem = despensaFirebase.cargaUnItem(Item("","CargaItem",1))

    }
    fun quitaItem(view:View){
        despensaFirebase.borraUnItem(latestItem);
    }
    fun updateItem(view:View){
        latestItem.description = "ItemEditado"
        latestItem.cantidad = 5
        despensaFirebase.modificaUnItem(latestItem)
    }
    fun getAllitems(view:View){
        despensaFirebase.obtenTodos()
    }
    fun borraItems(view:View){
        despensaFirebase.borraTodo()
    }

}
