package com.example.contact_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.ContextMenu
import android.view.Menu
import android.view.View
import android.widget.ListView
import com.example.contact_app.model.Person

class MainActivity : AppCompatActivity() {

    private lateinit var contacts : ArrayList<Person>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initData()
        val customAdapter = CustomAdapter(this, contacts)
        val listItem = findViewById<ListView>(R.id.list_item)
        listItem.adapter = customAdapter
        listItem.setOnItemClickListener { parent, view, position, id ->
            val selectedPerson = contacts[position]
            Log.v("Click", selectedPerson.email)
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("id",selectedPerson.id.toString())
            intent.putExtra("username",selectedPerson.username)
            intent.putExtra("phone",selectedPerson.phoneNumber)
            intent.putExtra("email",selectedPerson.email)
            startActivity(intent)
        }
        registerForContextMenu(listItem)


    }




    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menuInflater.inflate(R.menu.menu, menu)
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }


    private fun initData(){
        contacts = ArrayList<Person>()
        contacts.add( Person(1, "John Dang", "12345678", "johndang@gmail.com"))
        contacts.add( Person(2, "Tom Boy", "03834713439", "tomboy@gmail.com"))
        contacts.add( Person(3, "Fake Data", "1123912371", "fakedata@gmail.com"))
        contacts.add( Person(4, "User name", "1238491", "username@gmail.com"))
        contacts.add( Person(5, "Test function", "2347882", "testfunction@gmail.com"))
        contacts.add( Person(6, "Validate Data", "9812374", "dalidatedata@gmail.com"))
    }
}