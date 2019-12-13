package com.data.sqliteandroid.mvvm

class User {


    lateinit var name:String
    lateinit var value:String
     var age:Int = 0
    var check:Boolean = false

    constructor(name: String, value: String, age: Int, check: Boolean){

        this.name=name
        this.value=value
        this.age=age
        this.check=check
    }
}