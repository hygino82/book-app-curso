package br.dev.hygino.ui.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import br.dev.hygino.R
import br.dev.hygino.databinding.ItemBookBinding
import br.dev.hygino.entity.BookEntity
import br.dev.hygino.ui.listener.BookListener

class BookViewHolder(private val item: ItemBookBinding,private val listener: BookListener) : RecyclerView.ViewHolder(item.root){
    fun bind(book: BookEntity) {
        item.textviewTitle.text = book.title
        item.textviewAuthor.text = book.author
        item.textviewGenre.text = book.genre

        item.textviewTitle.setOnClickListener((object : View.OnClickListener{
            override fun onClick(p0: View?) {
                listener.onClick(book.id)
            }
        }))

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