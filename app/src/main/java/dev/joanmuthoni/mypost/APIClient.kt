package dev.joanmuthoni.mypost

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object APIClient {
    var retrofit = Retrofit.Builder()
        .baseUrl("https://jsonplaceholder.typicode.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    fun <T> buildApiClient(apiInterface: Class<T>): T {
        return retrofit.create(apiInterface)
    }
}
//fun main(){
//
//}
//interface  Television {
//    fun switchOn()
//    fun switchOff()
//    fun adjustVolume(Level: Int)
//    fun switchChannel()
//}
//class Sony:Television{
//    override fun switchOn() {
//        TODO("Not yet implemented")
//    }
//
//    override fun switchOff() {
//        TODO("Not yet implemented")
//    }
//
//    override fun adjustVolume(Level: Int) {
//        TODO("Not yet implemented")
//    }
//
//    override fun switchChannel() {
//        TODO("Not yet implemented")
//    }
//}
//class

