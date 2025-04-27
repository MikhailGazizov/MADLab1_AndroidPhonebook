package pt.ola.dial_application

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemAdapter(private val items: List<Item>) :
    RecyclerView.Adapter<ItemAdapter.ViewHolder>() {
    var onItemClickListener: ((Item) -> Unit)? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_view, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.nameTextView.text = items[position].name
        holder.phoneTextView.text = items[position].phoneNumber
        holder.itemView.setOnClickListener {
            onItemClickListener?.invoke(items[position])
        }}


        override fun getItemCount(): Int {
            return items.size
        }

        class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val nameTextView: TextView = itemView.findViewById(R.id.nameTextView)
            val phoneTextView: TextView = itemView.findViewById(R.id.phoneTextView)
        }
    }
