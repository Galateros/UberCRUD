package com.android.ubertest

import com.google.firebase.database.*

class DespensaFirebase  {

    private lateinit var database: DatabaseReference

    constructor(){
        database = FirebaseDatabase.getInstance().reference
    }

    fun cargaFirebaseDummy(){
        val items: List<Item> = mutableListOf(
            Item("","Leche", 15 ),
            Item("","Pan", 1 ),
            Item("","Pasta", 15 ),
            Item("","Arroz", 3 ),
            Item("","Frijol", 5 )
        )
        items.forEach {
            val key = database.child("despensa").push().key
            it.id = key
            database.child("despensa").child(key!!).setValue(it)
        }

    }


    //Completa los siguientes métodos
    // y crea una pequeña interfaz en la app
    //    // para probar cada método.
    // Todas las salidas se ven en consola
    // Pueden usar: https://firebase.google.com/docs/database/android/start

    //var latestKey:String? = null
    fun cargaUnItem(item: Item):Item{
        val key = database.child("despensa").push().key
        //latestKey = key
        item.id = key
        database.child("despensa").child(key!!).setValue(item)
        return item;

    }


    fun borraUnItem(item: Item){
        database.child("despensa").child(item.id!!).removeValue()
        //removeValue
    }

    fun borraTodo( ){
        database.child("despensa").removeValue()
    }

    fun modificaUnItem( item: Item){

        database.child("despensa").child(item.id!!).setValue(item)
        //updateChildrem //setValue
    }

    fun obtenTodos( ) {
        database.child("despensa").addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for (postSnapshot in dataSnapshot.children) {
                    println("Snapshot "+ postSnapshot)
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {
                println("loadPost:onCancelled: " + databaseError.toException())

            }
        })

    }



}