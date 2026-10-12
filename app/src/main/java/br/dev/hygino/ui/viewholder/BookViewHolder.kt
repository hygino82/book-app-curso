package br.dev.hygino.ui.viewholder

import androidx.recyclerview.widget.RecyclerView
import br.dev.hygino.databinding.ItemBookBinding
import br.dev.hygino.entity.BookEntity

class BookViewHolder(private val item: ItemBookBinding) : RecyclerView.ViewHolder(item.root) {
    fun bind(book: BookEntity) {
        item.textviewTitle.text = book.title
        item.textviewAuthor.text = book.author
        item.textviewGenre.text = book.genre
    }
}