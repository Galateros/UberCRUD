package com.android.ubertest.fragmentos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import com.android.ubertest.AlertDialogueActivity
import com.android.ubertest.DespensaFirebase
import com.android.ubertest.Item

import com.android.ubertest.R
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.fragment_alta.*
import kotlinx.android.synthetic.main.fragment_borrar.*

/**
 * A simple [Fragment] subclass.
 */
class BorrarFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_borrar, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        borrar_todo.setOnClickListener{


            /* var database = FirebaseDatabase.getInstance().reference
              database.child("despensa").removeValue()*/
        }
    }

}
