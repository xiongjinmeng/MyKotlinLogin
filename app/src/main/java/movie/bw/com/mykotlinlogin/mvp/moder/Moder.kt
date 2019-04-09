package movie.bw.com.mykotlinlogin.mvp.moder

import android.util.Log
import com.google.gson.Gson
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import movie.bw.com.mykotlinlogin.util.HttpRetrofitUtil
import movie.bw.com.mykotlinlogin.util.WayApi
import okhttp3.ResponseBody
import java.util.HashMap

/**
 * Created by Administrator on 2019/4/8 0008
 */
class Moder {
    fun login(logiN_URL: String, map: HashMap<String, String>, iModer: IModer) {
        HttpRetrofitUtil.instance.create(WayApi::class.java).post(logiN_URL,map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe (

                    object : Observer<ResponseBody> {
                        override fun onNext(t: ResponseBody) {
                            val string = t.string()
                            iModer.onSuccessful(string)
                        }

                        override fun onSubscribe(d: Disposable) {
                            Log.e("--","++");
                        }

                        override fun onError(e: Throwable) {
                            iModer.onError(e.message!!)
                        }

                        override fun onComplete() {
                            Log.e("--","++");
                        }
                    }
                    )

    }

    fun shop(moviE_API: String, map: HashMap<String, String>, iModer: IModer) {
        HttpRetrofitUtil.instance.create(WayApi::class.java).get(moviE_API,map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe (

                        object : Observer<ResponseBody> {
                            override fun onNext(t: ResponseBody) {
                                val string = t.string()
                                iModer.onSuccessful(string)
                            }

                            override fun onSubscribe(d: Disposable) {
                                Log.e("--","++");
                            }

                            override fun onError(e: Throwable) {
                                iModer.onError(e.message!!)
                            }

                            override fun onComplete() {
                                Log.e("--","++");
                            }
                        }
                )

    }
}