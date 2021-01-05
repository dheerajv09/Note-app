package com.example.noteapplication.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.noteapplication.R
import com.example.noteapplication.databinding.NoteLabelAdapterItemsBinding
import com.example.noteapplication.model.Note



class HeaderAdapter(private val context: Context, private val list: MutableList<Note>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder {
        if (viewType == TYPE_ITEM) {
            //inflate your layout and pass it to view holder
            //val v = LayoutInflater.from(context).inflate(R.layout.note_label_adapter_items, parent, false)
            val layoutInflater = LayoutInflater.from(context)
            val noteLabelAdapterItemsBinding: NoteLabelAdapterItemsBinding = NoteLabelAdapterItemsBinding.inflate(layoutInflater,parent,false)
            return VHItem(noteLabelAdapterItemsBinding)
        } else if (viewType == TYPE_HEADER) {
            //inflate your layout and pass it to view holder
            val v = LayoutInflater.from(context).inflate(R.layout.note_label_adapter_header, parent, false)
            return VHHeader(v)
        }
        throw RuntimeException("there is no type that matches the type $viewType + make sure your using types correctly")
    }

    override fun onBindViewHolder(
        holder: RecyclerView.ViewHolder,
        position: Int
    ) {
        if (holder is VHItem) {
            val dataItem = getItem(position)
            val note: Note = list[position]
            holder.labelAdapterItemsBinding.note = note
            holder.labelAdapterItemsBinding.executePendingBindings()

            //holder.button!!.setOnClickListener {
            //    Toast.makeText(context,list[position].id.toString(),Toast.LENGTH_SHORT).show()
           // }
            //cast holder to VHItem and set data
        } else if (holder is VHHeader) {
            //cast holder to VHHeader and set data for header.
                holder.headerButton!!.setOnClickListener {
                    Toast.makeText(context,"Header",Toast.LENGTH_SHORT).show()
                }
        }
    }

    fun itemClick(view: View?) {
        Toast.makeText(context,"Header",Toast.LENGTH_SHORT).show()
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun getItemViewType(position: Int): Int {
        return if (isPositionHeader(position)) TYPE_HEADER else TYPE_ITEM
    }

    private fun isPositionHeader(position: Int): Boolean {
        return position == 0
    }

    private fun getItem(position: Int): Note {
        return list[position - 1]
    }

    internal inner class VHItem(labelAdapterItemsBinding: NoteLabelAdapterItemsBinding?) :
        RecyclerView.ViewHolder(labelAdapterItemsBinding!!.root) {
        //var button: CardView? = itemView!!.findViewById(R.id.note_label_adapter_note_cardView)
        var labelAdapterItemsBinding: NoteLabelAdapterItemsBinding = labelAdapterItemsBinding!!
    }

    internal inner class VHHeader(itemView: View?) :
        RecyclerView.ViewHolder(itemView!!) {
        var headerButton: CardView? = itemView!!.findViewById(R.id.note_label_adapter_header_button)
    }

    companion object {
        private const val TYPE_HEADER = 0
        private const val TYPE_ITEM = 1
    }

}



