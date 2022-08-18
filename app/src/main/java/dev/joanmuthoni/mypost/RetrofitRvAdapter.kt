package dev.joanmuthoni.mypost

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.joanmuthoni.mypost.databinding.RetrofitPostItemBinding
import kotlin.coroutines.CoroutineContext

class RetrofitRvAdapter(var context:Context, var postList: List<Post>)
    : RecyclerView.Adapter<RetrofitViewHolder> (){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RetrofitViewHolder {
       var bindingView = RetrofitPostItemBinding
           .inflate(LayoutInflater.from(context),parent,false)
        return  RetrofitViewHolder(bindingView)
    }

    override fun onBindViewHolder(holder: RetrofitViewHolder, position: Int) {
        var currentItem = postList.get(position)


        with(holder.bindingView){
            tvuserid.text = currentItem.userId.toString()
            tvid.text = currentItem.id.toString()
            tvtitle.text = currentItem.title
            tvbody.text= currentItem.body
            cvPosts.setOnClickListener{
                var intent = Intent(context, CommentActivity::class.java)
                intent.putExtra("POST_ID", currentItem.id)
                context.startActivity(intent)
            }
        }
    }

    override fun getItemCount(): Int {
        return postList.size
    }
}

class RetrofitViewHolder(var bindingView: RetrofitPostItemBinding):
        RecyclerView.ViewHolder(bindingView.root)