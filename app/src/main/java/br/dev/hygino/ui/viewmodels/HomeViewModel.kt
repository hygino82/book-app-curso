package br.dev.hygino.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.dev.hygino.entity.BookEntity
import br.dev.hygino.repository.BookRepository

class HomeViewModel : ViewModel() {
    private val _books = MutableLiveData<List<BookEntity>>()
    val books: LiveData<List<BookEntity>> = _books

    private val repository: BookRepository = BookRepository()

    fun getAllBooks() {
        _books.value = repository.getAllBooks()
    }
}