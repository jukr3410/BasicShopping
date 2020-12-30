package com.daydev.shoppinglist.ui.shoppinglist

import com.daydev.shoppinglist.data.db.entities.ShoppingItem

interface AddDialogListener {
    fun onAddButtonClicked(item:ShoppingItem)
}