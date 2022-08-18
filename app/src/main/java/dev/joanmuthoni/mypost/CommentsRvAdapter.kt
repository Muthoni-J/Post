package dev.joanmuthoni.mypost

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.joanmuthoni.mypost.databinding.CommentslistBinding
import dev.joanmuthoni.mypost.databinding.RetrofitPostItemBinding

class CommentsRvAdapter(var commentslist:List<Comment>)
    : RecyclerView.Adapter<CommentsViewHolder> (){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentsViewHolder {
        var binding = CommentslistBinding
            .inflate(LayoutInflater.from(parent.context),parent,false)
        return  CommentsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CommentsViewHolder, position: Int) {
        var currentcomments = commentslist.get(position)
        with(holder.bindingView){
            holder.bindingView.tvPostId.text=currentcomments.postId.toString()
            holder.bindingView.tvId.text=currentcomments.postId.toString()
            holder.bindingView.tvname.text=currentcomments.name
            holder.bindingView.tvemail.text=currentcomments.email
            holder.bindingView.tvbody2.text=currentcomments.body



            }
        }


    override fun getItemCount(): Int {
        return  commentslist.size
    }
}

class CommentsViewHolder(var bindingView: CommentslistBinding ):
    RecyclerView.ViewHolder(bindingView.root){
    }