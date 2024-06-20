package uz.isystem.data.data.local_data

import android.content.Context
import android.content.SharedPreferences

class LocalStorage private constructor(context: Context){

    private val lastInputKey = "KEY_LAST_INPUT"

    init {
        sharedPreferences = context.getSharedPreferences("cache", Context.MODE_PRIVATE)

    }
    companion object{
        private var appCache: LocalStorage? = null
        private var sharedPreferences: SharedPreferences? = null

        fun init(context: Context) {
            if (appCache == null) {
                appCache = LocalStorage(context)
            }
        }

        fun getObject(): LocalStorage {
            return appCache!!
        }
    }

    fun setLastInput(text:String){
        sharedPreferences!!.edit().putString(lastInputKey, text).apply()
    }

    fun getLastInput() : String{
        return sharedPreferences!!.getString(lastInputKey,"Минск")!!
    }

}