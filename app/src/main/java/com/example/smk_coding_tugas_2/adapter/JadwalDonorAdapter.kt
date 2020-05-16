package com.example.smk_coding_tugas_2.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.smk_coding_tugas_2.dataclass.Data
import com.example.smk_coding_tugas_2.R
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.jadwal_donor_item.*

class JadwalDonorAdapter(private val context: Context, private val items:
List<Data>, private val listener: (Data)-> Unit) :
    RecyclerView.Adapter<JadwalDonorAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            context, LayoutInflater.from(context).inflate(
                R.layout.jadwal_donor_item,
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
        fun bindItem(item: Data, listener: (Data) -> Unit) {
            txtInstansi.text = item.instansi
            txtAlamat.text = item.alamat
            txtJam.text = item.jam
            txtKuota.text = item.rencanaDonor
            containerView.setOnClickListener { listener(item) }
        }
    }
}