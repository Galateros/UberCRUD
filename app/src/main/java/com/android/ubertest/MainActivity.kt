package com.android.ubertest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.android.ubertest.fragmentos.ListaDespensaFragment


class MainActivity : AppCompatActivity() {

    private val despensaFirebase : DespensaFirebase = DespensaFirebase()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ListaDespensaFragment().setFragment(supportFragmentManager)
    }
    public fun showNoticeDialog() {
        // Create an instance of the dialog fragment and show it
        val dialog = AlertDialogueActivity()
        dialog.show(supportFragmentManager, "AlertDialogueActivity")
    }

    var latestItem:Item = Item("","",0)
    fun agregaItem(view: View){
        latestItem = despensaFirebase.cargaUnItem(Item("","CargaItem",1))

    }
    fun quitaItem(view:View,item: Item){
        despensaFirebase.borraUnItem(item);
    }
    fun updateItem(view:View,item: Item){
        latestItem.description = "ItemEditado"
        latestItem.cantidad = 5
        despensaFirebase.modificaUnItem(item)
    }
    fun getAllitems(view:View){
        despensaFirebase.obtenTodos()
    }
    fun borraItems(view:View){
        despensaFirebase.borraTodo()
    }

}
