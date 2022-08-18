package dev.joanmuthoni.mypost

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import dev.joanmuthoni.mypost.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getPosts()
    }
    fun getPosts(){
        val retrofit = APIClient.buildApiClient(APInterface::class.java)
        val request = retrofit.getPosts()

        request.enqueue(object: Callback<List<Post>>{
            override fun onResponse(call: Call<List<Post>>, response:  Response<List<Post>>) {
                if (response.isSuccessful){
                    val post = response.body()!!
                    var adapter = RetrofitRvAdapter(baseContext, post)
                    binding.rvretrofit.adapter = adapter
                    binding.rvretrofit.layoutManager = LinearLayoutManager(baseContext)
                    Toast.makeText(baseContext, "fetched ${post.size} posts",
                        Toast. LENGTH_LONG).show()
                }
            }
            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
            }
        })
    }
}
//fun displayPost(post)
//binding.postA

