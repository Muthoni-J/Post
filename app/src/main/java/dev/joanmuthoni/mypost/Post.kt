package dev.joanmuthoni.mypost

import android.icu.text.CaseMap
import retrofit2.http.Body
//open class Item()
//var id:Int=()

data class Post(
    var userId:Int,
    var id:Int,
    var title:String,
    var body: String)
 data class Comment(
     var postId:Int,
     var name:String,
     var email:String,
     var body: String
     )

//fun <T>compareIds(item1:T,item2:T):T{
//    var output = (item1.toString()+item2.toString())
//    println(output)
//    return item1
//}
//fun stage() {
//    var post1 = Post(1, 2, "abc", "def")
//    var post2 = Post(3, 4, "abc", "def")
//    compareIds(post1, post2)
//
//    var comment1 =Comment(1,"abc","def","ddd")
//    var comment2 =Comment(3,"bbb","ghi","jkl")
//    compareIds(comment1, comment2)
//}