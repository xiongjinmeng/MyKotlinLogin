package movie.bw.com.mykotlinlogin.util

/**
 * Created by Administrator on 2019/4/7 0007
 */

object UserApi{
//    val BASE_URL = "https://172.17.8.100/"
//    val BASE_API = "techApi/information/v1/bannerShow"
//外网地址
    val BASE_URL = "http://mobile.bwstudent.com/"
    //内网
    val BASE_API = "http://172.17.8.100/"
    val MOVIE_API = "movieApi/movie/v1/findHotMovieList"
    //注册:POST
    val REGISTER_URL = "movieApi/user/v1/registerUser"
    //登陆:POST
    val LOGIN_URL = "movieApi/user/v1/login"

}