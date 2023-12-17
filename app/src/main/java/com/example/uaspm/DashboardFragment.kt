package com.example.uaspm

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class DashboardFragment : Fragment() {

    private lateinit var adapter: MyFlowerAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var flowerArrayList: ArrayList<MyFlower>

    lateinit var name : Array<String>
    lateinit var photo: Array<Int>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dashboard, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)
        dataInitialize()
        val layoutManager = GridLayoutManager(context,2)
        recyclerView = view.findViewById(R.id.recylerview_plant)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = MyFlowerAdapter(flowerArrayList)
        recyclerView.adapter = adapter
    }

    private fun dataInitialize(){
        flowerArrayList = arrayListOf<MyFlower>()

        photo = arrayOf(
            R.drawable.aglonema,
            R.drawable.calathea,
            R.drawable.peperomia_watermelon,
            R.drawable.hypoestes_phyllostachya,
            R.drawable.philodendron_selloum_variegata,
            R.drawable.sansevieria,
            R.drawable.scindapsus_treubii,
            R.drawable.sri_rezeki,
            R.drawable.stromanthe_varieties
        )

        name = arrayOf(
            getString(R.string.Aglonema),
            getString(R.string.Calathea),
            getString(R.string.Peperomia),
            getString(R.string.Hypoestes),
            getString(R.string.Philodendron),
            getString(R.string.Sansevieria),
            getString(R.string.Scindapsus),
            getString(R.string.Sri),
            getString(R.string.Stromanthe)
            )

        for (i in photo.indices){
            val flower = MyFlower(photo[i], name[i])
            flowerArrayList.add(flower)
        }
    }

}