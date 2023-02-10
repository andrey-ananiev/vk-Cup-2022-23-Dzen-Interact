package ru.keytomyself.dzeninteract.screens.pager.models

interface IntentHandler<T> {
    fun obtainIntent(intent: T)
}