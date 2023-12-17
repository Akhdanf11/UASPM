package com.example.uaspm
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyFlowerAdapter(private val listMyFlower: ArrayList<MyFlower>) :
    RecyclerView.Adapter<MyFlowerAdapter.ListViewHolder>() {
    private lateinit var onItemCallback: OnitemClickCallback

    fun setOnItemClickCallback(onitemClickCallback: OnitemClickCallback){
        this.onItemCallback= onItemCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_flower,parent,false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, photo) = listMyFlower[position]
        holder.imgFlower.setImageResource(photo)
        holder.tvNameFlower.text = name

        holder.itemView.setOnClickListener{
            onItemCallback.onItemClicked(listMyFlower[holder.adapterPosition])
        }
    }

    override fun getItemCount(): Int = listMyFlower.size

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgFlower: ImageView = itemView.findViewById(R.id.img_flower)
        var tvNameFlower: TextView = itemView.findViewById(R.id.tv_title_flower)

    }
    interface OnitemClickCallback {
        fun onItemClicked(data: MyFlower)
    }


}