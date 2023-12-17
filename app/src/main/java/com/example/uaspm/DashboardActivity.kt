package com.example.uaspm

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Email
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.GridLayout
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.uaspm.databinding.ActivityDashboardBinding
import com.google.android.material.bottomnavigation.BottomNavigationView


class DashboardActivity : AppCompatActivity() {

    val fragHome : Fragment = DashboardFragment()
    val fragprofile : Fragment = ProfileFragment()
    val fm : FragmentManager = supportFragmentManager
    var active: Fragment = fragHome

    private lateinit var bottomNavigationView: BottomNavigationView
    private lateinit var menu : Menu
    private lateinit var menuItem: MenuItem


    private  val list = arrayListOf<MyFlower>()
    private lateinit var binding : ActivityDashboardBinding

    //autntikasi user
    lateinit var textFullname : TextView
    lateinit var textEmail: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        list.addAll(listMyFlower)
//        showRecylerList()

        setUpNavibottom()
    }

//    private val listMyFlower: ArrayList<MyFlower>
//        get() {
//            val dataName = resources.getStringArray(R.array.flower_name)
//            val dataPhoto = resources.obtainTypedArray(R.array.data_photo_flower)
//            val recylerviewPlant = ArrayList<MyFlower>()
//            for (i in dataName.indices){
//                val flower = MyFlower(dataName[i], dataPhoto.getResourceId(i, -1))
//                recylerviewPlant.add(flower)
//            }
//            return recylerviewPlant
//        }


//    private fun showRecylerList(){
//        if(applicationContext.resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE){
//            binding.recylerviewPlant.layoutManager = GridLayoutManager(this, 2)
//        }else {
//            binding.recylerviewPlant.layoutManager = LinearLayoutManager(this)
//        }
//
//        val adapter = MyFlowerAdapter(list)
//        binding.recylerviewPlant.adapter = adapter
//        adapter.setOnItemClickCallback(object : MyFlowerAdapter.OnitemClickCallback{
//            override fun onItemClicked(data: MyFlower) {
//                Toast.makeText(this@DashboardActivity, "Kamu memilih " +
//                data.name, Toast.LENGTH_SHORT).show()
//            }
//        })
//    }

    private fun setUpNavibottom() {
        fm.beginTransaction().add(R.id.navi_content,fragHome).show(fragHome).commit()
        fm.beginTransaction().add(R.id.navi_content,fragprofile).hide(fragprofile).commit()

        bottomNavigationView = binding.navView
        menu = bottomNavigationView.menu
        menuItem = menu.getItem(0)
        menuItem.isChecked = true

        bottomNavigationView.setOnNavigationItemReselectedListener { item ->
            when (item.itemId) {
                R.id.navi_dashboard -> {
                    callFragment(0, fragHome)
                }
                R.id.navi_profile -> {
                    callFragment(1, fragprofile)
                }
            }
        }
    }

    private fun callFragment(index : Int , fragment: Fragment) {
        menuItem = menu.getItem(index)
        menuItem.isChecked = true
        fm.beginTransaction().hide(active).show(fragment).commit()
        active = fragment
    }
}