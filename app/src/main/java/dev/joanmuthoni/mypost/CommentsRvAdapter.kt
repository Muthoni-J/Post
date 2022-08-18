package dev.joanmuthoni.mypost

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.joanmuthoni.mypost.databinding.CommentslistBinding
import dev.joanmuthoni.mypost.databinding.RetrofitPostItemBinding

class CommentsRvAdapter(var commentslist: Context, var commentstlist: List<Post>)
    : RecyclerView.Adapter<CommentsViewHolder> (){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentsViewHolder {
        var bindingView = CommentslistBinding
            .inflate(LayoutInflater.from(context),parent,false)
        return  CommentsViewHolder(bindingView)
    }

    override fun onBindViewHolder(holder: CommentsViewHolder, position: Int) {
        var currentItem = commentsList.get(position)
        with(holder.binding){
            holder.binding.tvid.text=currentItem.id
            holder.bindingView.
            tvId.text = currentItem.userId.toString()
            tvid.text = currentItem.id.toString()
            tvemail.text = currentItem.email
            tv.text= currentItem.body
            cvPosts.setOnClickListener{
                var intent = Intent(context, CommentActivity::class.java)
                intent.putExtra("POST_ID", currentItem.id)
                context.startActivity(intent)
            }
        }
    }

    override fun getItemCount(): Int {
        return  commmentslist.size
    }
}

class CommentsViewHolder(var bindingView: CommentsItemBinding):
    RecyclerView.ViewHolder(bindingView.root)