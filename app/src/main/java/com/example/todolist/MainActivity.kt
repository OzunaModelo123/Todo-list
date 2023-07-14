package com.example.todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.CheckedTextView
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
        // Initialize the view binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Create an empty list to store the to-do items
        val items = mutableListOf<String>()

        // Create an ArrayAdapter and set it as the adapter for the ListView
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_multiple_choice, items)
        binding.listView.adapter = adapter

        // Set the choice mode of the ListView to allow multiple item selection
        binding.listView.choiceMode = ListView.CHOICE_MODE_MULTIPLE

        // Add click listener for the "Add" button
        binding.addButton.setOnClickListener {
            // Get the text from the EditText
            val newItem = binding.editText.text.toString()
            if (newItem.isNotEmpty()) {
                // Add the new item to the list and notify the adapter
                items.add(newItem)
                adapter.notifyDataSetChanged()

                // Clear the EditText
                binding.editText.text.clear()
            }
        }
        // Add item click listener to toggle the checked state of the checkbox
        binding.listView.onItemClickListener =
            AdapterView.OnItemClickListener { _, view, _, _ ->
                val checkBox = view.findViewById<CheckedTextView>(android.R.id.text1)
                checkBox.isChecked = !checkBox.isChecked

            }
        // Add item long click listener to remove the item from the list
        binding.listView.setOnItemLongClickListener { _, _, position, _ ->
            val selectedItem = items[position]
            items.remove(selectedItem)
            adapter.notifyDataSetChanged()
            true
        }
    }
}

