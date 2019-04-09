package movie.bw.com.mykotlinlogin.mvp.presenter

import movie.bw.com.mykotlinlogin.mvp.moder.IModer
import movie.bw.com.mykotlinlogin.mvp.moder.Moder
import movie.bw.com.mykotlinlogin.mvp.view.IView
import java.util.*

/**
 * Created by Administrator on 2019/4/8 0008
 */
class Presenter(var iView: IView) {


    private var moder=Moder()

    fun Presenter(iView: IView) {
        this.iView = iView
        moder = Moder()
    }

    fun onDestroy() {
        if (iView != null) {

        }
    }

    fun login(logiN_URL: String, map: HashMap<String, String>) {
        moder.login(logiN_URL,map,object :IModer{
            override fun onSuccessful(string: String) {
                iView.onSuccessful(string)
            }

            override fun onError(e: String) {
                iView.onError(e)
            }

        })

    }

    fun shop(moviE_API: String, map: HashMap<String, String>) {
        moder.shop(moviE_API,map,object :IModer{
            override fun onSuccessful(string: String) {
                iView.onSuccessful(string)
            }

            override fun onError(e: String) {
                iView.onError(e)
            }

        })

    }
}