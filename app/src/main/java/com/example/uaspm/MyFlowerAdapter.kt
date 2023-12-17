package com.example.uaspm
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.google.android.material.shape.Shapeable

class MyFlowerAdapter(private val listMyFlower: ArrayList<MyFlower>) :
    RecyclerView.Adapter<MyFlowerAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_flower,parent,false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val currentItem = listMyFlower[position]
        holder.imgFlower.setImageResource(currentItem.photo)
        holder.tvNameFlower.text = currentItem.name

    }

    override fun getItemCount(): Int = listMyFlower.size

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgFlower: ShapeableImageView = itemView.findViewById(R.id.img_flower)
        var tvNameFlower: TextView = itemView.findViewById(R.id.tv_title_flower)

    }


}