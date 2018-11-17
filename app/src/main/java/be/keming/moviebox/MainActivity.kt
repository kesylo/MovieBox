package be.keming.moviebox

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.*
import java.io.IOException

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // access widget in code (recycle view)
        //recycleview_main.setBackgroundColor(color.B)
        recycleview_main.layoutManager = LinearLayoutManager(this);
        //recycleview_main.adapter = RecyMainAdpater()

        // parse json
        fetchJson()
    }

    fun fetchJson(){
        println("fecthing")
        val key = "f9af0151f8511669816e207386cdf5e0"
        val url = "https://api.themoviedb.org/3/movie/top_rated?api_key=$key"
        val request = Request.Builder().url(url).build()

        // OkHttp get JSON
        val client = OkHttpClient()
        client.newCall(request).enqueue(object : Callback{
            override fun onResponse(call: Call, response: Response) {
               val body = response.body()?.string()
                println(body)

                // Parse the JSON
                val gson = GsonBuilder().create()
                val topRatedMoviesfeed = gson.fromJson(body, TopRatedMoviesfeed::class.java)

                // Add it to Recycleview
                runOnUiThread{
                    recycleview_main.adapter = RecyMainAdpater(topRatedMoviesfeed)
                }
            }
            override fun onFailure(call: Call, e: IOException) {
                // put toast
                println("FAILED")
            }
        })
    }
}




