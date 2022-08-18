package dev.joanmuthoni.mypost

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.InputQueue
import dev.joanmuthoni.mypost.databinding.ActivityCommentBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class CommentActivity : AppCompatActivity() {
    lateinit var binding: ActivityCommentBinding
    var postId = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
    fun obtainPostId(){
        postId = intent.extras?.getInt("POST_ID")?:0

    }
    fun fetchPost(){
        var apiClient = APIClient.buildApiClient(APInterface::class.java)
        var request = apiClient.getPostById(postId)

        request.enqueue(object :Callback<Post> {
            override fun onResponse(call:Call<Post>, reponse: Response<Post>) {
                var post = reponse.body()
                if(post!= null){
                    binding.tvPostTitle.text = post.title
                    binding.tvPostBody.text = post.body
                }
            }
            override fun onFailure(cal: Call<Post>, t:Throwable){
        }
    })
  }
}
 fun getComment(){
     var apiClient = APIClient.buildApiClient(APInterface::class.java)
     var request = apiClient.getPostById(postId)
      request.enqueue(object :Callback<Post>{
         override fun onResponse(call: Call<Post>,response: Response<Post>){
             var post = response.body()
             if (post!=null){
                 binding.tvPostTitle.text=post.title
                 binding.tvPostBody.text = post.body
             }
         }

          override fun onFailure(call: Call<Post>, t: Throwable) {
              TODO("Not yet implemented")
          }
      })


 }