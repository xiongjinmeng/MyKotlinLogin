package movie.bw.com.mykotlinlogin.mvp.moder

import java.util.*

/**
 * Created by Administrator on 2019/4/8 0008
 */
interface IModer {
    abstract fun onSuccessful(string: String)
    abstract fun onError(e: String)
}