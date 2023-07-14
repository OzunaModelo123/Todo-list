package com.example.todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import com.example.todolist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: ArrayAdapter<String>

    /**
     * Called when the activity is starting. Sets up the views and event listeners.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // Create an empty list to store the to-do items
        val items = mutableListOf<String>()

        // Create an ArrayAdapter and set it as the adapter for the ListView
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_multiple_choice, items)
        binding.listView.adapter = adapter

        // Set the choice mode of the ListView to allow multiple item selection
        binding.listView.choiceMode = ListView.CHOICE_MODE_MULTIPLE
    }
}