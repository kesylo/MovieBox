package be.keming.moviebox

class TopRatedMoviesfeed(val results:List<Movie> )

// add more variable here to get more data from the JSON
// case sensitive
class Movie(val id:Int,
            val title:String,
            val original_language:String,
            val popularity:String,
            val original_title:String,
            val poster_path:String)

// this is how to get an object in another object
//class GenreID(val genre_ids:List<Int>)