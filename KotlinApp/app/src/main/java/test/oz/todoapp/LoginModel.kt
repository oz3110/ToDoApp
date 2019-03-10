package test.oz.todoapp

import java.io.PrintStream
import java.net.HttpURLConnection
import java.net.URL

class LoginModel : LoginModelObserver(){
    override fun observe(userId: String, userPass: String) : Boolean{

        return true
    }
    // とりあえず見よう見真似
    // 後日調べる
    fun isLogin( user_Id : String, user_Pass : String ) : Boolean{
        var con : HttpURLConnection? = null

        try{
            val urlStr = "http://localhost"
            val url = URL(urlStr)
            con = url.openConnection() as HttpURLConnection
            con.requestMethod = "POST"
            con.instanceFollowRedirects = false
            con.doOutput = true
            con.connect()

            val os = con.outputStream
            val ps = PrintStream(os)
            ps.print(user_Id)
            ps.print(user_Pass)
            ps.close()

            val responseCode = con.responseCode
        }catch(e:InterruptedException){

        }finally{
            con?.disconnect()
            return false
        }
        return true
    }
}