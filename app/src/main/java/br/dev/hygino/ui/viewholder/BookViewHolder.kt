package br.dev.hygino.ui.viewholder

import androidx.recyclerview.widget.RecyclerView
import br.dev.hygino.R
import br.dev.hygino.databinding.ItemBookBinding
import br.dev.hygino.entity.BookEntity

class BookViewHolder(private val item: ItemBookBinding) : RecyclerView.ViewHolder(item.root) {
    fun bind(book: BookEntity) {
        item.textviewTitle.text = book.title
        item.textviewAuthor.text = book.author
        item.textviewGenre.text = book.genre

        setGenreBackground(book.genre)
        updateFavoriteIcon(book.favorite)
    }

    private fun updateFavoriteIcon(favorite: Boolean) {
        if (favorite) {
            item.imageviewFavorite.setImageResource(R.drawable.ic_favorite)
        } else {
            item.imageviewFavorite.setImageResource(R.drawable.ic_favorite_empty)
        }
    }

    private fun setGenreBackground(genre: String) {
        when (genre) {
            "Terror" -> {
                item.textviewGenre.setBackgroundResource(R.drawable.rounded_label_red)
            }

            "Fantasia" -> {
                item.textviewGenre.setBackgroundResource(R.drawable.rounded_label_fantasy)
            }

            else -> {
                item.textviewGenre.setBackgroundResource(R.drawable.rounded_label_teal)
            }
        }
    }
}