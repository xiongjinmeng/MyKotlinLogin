package movie.bw.com.mykotlinlogin.mvp.view

import java.util.*

/**
 * Created by Administrator on 2019/4/8 0008
 */
interface IView {
     fun onSuccessful(string: String)
     fun onError(e: String)
}