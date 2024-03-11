package org.example

import kotlin.reflect.KProperty

fun main() {
    val student = Student()
    student.age = 25
    println(student.age)
    println(student.age)

}

class Student {
    var age: Int by MyLazy()
}

class MyLazy<T> {
    private var value: T? = null

    operator fun getValue(thisRef: Any?, property: KProperty<*>): T {
        println("getting")
        return value ?: throw NullPointerException()
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        println("setting")
        this.value = value
    }
}
