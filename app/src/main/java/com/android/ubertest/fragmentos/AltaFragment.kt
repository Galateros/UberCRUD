package com.android.ubertest.fragmentos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.ubertest.DespensaFirebase
import com.android.ubertest.Item

import com.android.ubertest.R
import kotlinx.android.synthetic.main.fragment_alta.*

/**
 * A simple [Fragment] subclass.
 */
class AltaFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_alta, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        send_button.setOnClickListener{
            val despensaFirebase = DespensaFirebase()
            val item = Item()
            item.id = ""
            item.cantidad = cantidad_edittext.text.toString().toInt()
            item.description = description_edittext.text.toString()
            despensaFirebase.cargaUnItem(item)
        }
    }

}
