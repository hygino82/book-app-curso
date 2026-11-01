package br.dev.hygino.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.dev.hygino.entity.BookEntity
import br.dev.hygino.repository.BookRepository

class DetailsViewModel : ViewModel() {
    private val repository: BookRepository = BookRepository()

    private val _book = MutableLiveData<BookEntity>()
    val book: LiveData<BookEntity> = _book

    fun getBookById(id: Int) {
        _book.value = repository.getBookById(id)
    }
}