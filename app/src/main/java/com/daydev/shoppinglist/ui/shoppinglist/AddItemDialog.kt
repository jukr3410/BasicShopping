package com.daydev.shoppinglist.ui.shoppinglist

import android.content.Context
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.daydev.shoppinglist.R
import com.daydev.shoppinglist.data.db.entities.ShoppingItem


class AddItemDialog (context: Context,var addDialogListener:AddDialogListener): AppCompatDialog(context){


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_add_item)

        val textAddItem = findViewById<TextView>(R.id.text_add)
        val textCancel = findViewById<TextView>(R.id.text_cancel)
        val editItemName = findViewById<EditText>(R.id.edit_name)
        val editAmount = findViewById<EditText>(R.id.edit_amount)

        textAddItem!!.setOnClickListener{
            val name = editItemName?.text.toString()
            val amount = editAmount?.text.toString()

            if (name.isEmpty()||amount.isEmpty()){
                Toast.makeText(context,"Please enter all",Toast.LENGTH_SHORT)
                return@setOnClickListener
            }

            val item = ShoppingItem(name,amount.toInt())
            addDialogListener.onAddButtonClicked(item)
            dismiss()
        }

        textCancel!!.setOnClickListener{
            cancel()
        }


    }
}