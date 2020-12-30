package com.daydev.shoppinglist.data.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "items")  //specify table name
class ShoppingItem(@ColumnInfo(name = "item_name")  //specify column name that represent in db for each entry
                   var name:String,
                   @ColumnInfo(name = "item_amount")
                   var amount:Int,)
{
    @PrimaryKey(autoGenerate = true)  //don't have to set manual in constructor
    var id:Int? =null

}