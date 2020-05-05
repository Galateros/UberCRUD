package com.android.ubertest.fragmentos
import android.app.PendingIntent.getActivity
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.android.ubertest.AlertDialogueActivity
import com.android.ubertest.Item
import com.android.ubertest.MainActivity
import com.android.ubertest.R
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.*
import org.w3c.dom.Text


class DespensaRecyclerAdapter( private val list: List<Item>)
    : RecyclerView.Adapter<ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ItemViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item: Item = list[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = list.size

}

class ItemViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.renglon_item, parent, false)) {
    private var cantidadItemTextView: TextView? = null
    private var itemDescripcionTextView: TextView? = null
    private var itemQuitaButton: Button? = null
    private var itemUpdateButton: Button? = null
    private var itemDescriptorInput: TextView? = null;
    private var itemCantidadInput: TextView? = null;


    init {
        cantidadItemTextView = itemView.findViewById(R.id.item_cantidad)
        itemDescripcionTextView = itemView.findViewById(R.id.item_descipcion)
        itemQuitaButton = itemView.findViewById(R.id.item_delete)
        itemUpdateButton = itemView.findViewById(R.id.update)
        itemDescriptorInput = itemView.findViewById(R.id.text_desc)
        itemCantidadInput = itemView.findViewById(R.id.text_can)
    }

    fun bind(item: Item) {
        Log.i("Error despensa",item.cantidad.toString() )
        cantidadItemTextView?.text = item.cantidad.toString()
        itemDescripcionTextView?.text = item.description
        itemQuitaButton?.setOnClickListener{
           var database = FirebaseDatabase.getInstance().reference
            database.child("despensa").child(item.id!!).removeValue()
        }
        itemUpdateButton?.setOnClickListener{
            var dialog = AlertDialogueActivity()
            dialog.setAnId(item.id);
            //item.cantidad = itemCantidadInput?.toString()?.toInt()
            //item.description = itemDescripcionTextView?.toString()
            Log.v("WAAAAAAAAAG"," - "+itemDescriptorInput?.text+"-----------"+itemCantidadInput?.text)
            item.cantidad = itemCantidadInput?.text.toString().toInt()
            item.description = itemDescriptorInput?.text.toString()

            var database = FirebaseDatabase.getInstance().reference
            database.child("despensa").child(item.id!!).setValue(item)
            // dialog.show(supportFragmentManager,"")

        }

    }

}