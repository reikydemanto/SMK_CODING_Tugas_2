package com.example.smk_coding_tugas_2.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.smk_coding_tugas_2.R
import com.example.smk_coding_tugas_2.dataclass.DataX
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.stok_darah_item.*

class StokDarahAdapter(private val context: Context, private val items:
List<DataX>, private val listener: (DataX)-> Unit) :
    RecyclerView.Adapter<StokDarahAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            context, LayoutInflater.from(context).inflate(
                R.layout.stok_darah_item,
                parent, false
            )
        )
    override fun getItemCount(): Int {
        return items.size
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(items.get(position), listener)
    }
    class ViewHolder(val context: Context, override val containerView : View) :
        RecyclerView.ViewHolder(containerView), LayoutContainer {
        fun bindItem(item: DataX, listener: (DataX) -> Unit) {
            txtInstansi.text = item.unit
            txtJumlah.text = item.jumlah
            containerView.setOnClickListener { listener(item) }
        }
    }
}