package be.keming.moviebox

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.movie_row.view.*

class RecyMainAdpater (val topRatedMoviesfeed: TopRatedMoviesfeed): RecyclerView.Adapter<CustomViewHolder>() {

    // static view
    //val movieTitles = listOf<String>("first", "ok", "no", "fok", "better", "cool", "first", "ok", "no", "fok", "better", "cool")

    // number of items of view
    override fun getItemCount(): Int {
        return topRatedMoviesfeed.results.count()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val cellForRow = layoutInflater.inflate(R.layout.movie_row, parent, false)
        return CustomViewHolder(cellForRow)
    }

    // this function helps you to add or modify items on the view
    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        // Flags URL
        val EN = "https://www.countryflags.io/us/flat/64.png"

        //val movieTitle = movieTitles.get(position)
        // load things to UI
        val movie = topRatedMoviesfeed.results.get(position)
        holder.view.textView_video_title?.text = movie.title
        holder.view.textView_Original_lang.text= movie.original_language
        holder.view.textView_original_title.text = movie.original_title
        holder.view.textView_popularity.text = movie.popularity

        // Fill the image view with pictures
        // get imageview
        val poster_path = movie.poster_path
        var thumbnail_url = "https://image.tmdb.org/t/p/w185/$poster_path"
        // Flags
        val flag_url = "https://www.countryflags.io/us/flat/64.png"
        val thumbnailImageView = holder.view.imageView_thumbnail
        val languageImageView = holder.view.imageView_language
        Picasso.with(holder.view.context).load(thumbnail_url).into(thumbnailImageView)

        when (movie.original_language) {
            "en" -> Picasso.with(holder.view.context).load(EN).into(languageImageView)
            //2 -> print("x == 2")
            else -> { // Note the block
                println("x is neither 1 nor 2")
            }
        }



    }
}

class CustomViewHolder(val view :View): RecyclerView.ViewHolder(view){

}