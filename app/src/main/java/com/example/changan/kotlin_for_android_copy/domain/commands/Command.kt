package com.example.changan.kotlin_for_android_copy.domain.commands

public interface Command<T> {
    fun execute(): T
}