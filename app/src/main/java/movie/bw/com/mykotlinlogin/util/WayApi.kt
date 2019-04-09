package movie.bw.com.mykotlinlogin.util

import io.reactivex.Observable
import okhttp3.ResponseBody
import retrofit2.http.*

/**
 * Created by Administrator on 2019/4/9 0009
 */
interface WayApi {
    @FormUrlEncoded
    @POST
     fun post(@Url url: String, @FieldMap map: Map<String, String>): Observable<ResponseBody>

    @GET
     operator fun get(@Url url: String, @QueryMap map: Map<String, String>): Observable<ResponseBody>
}