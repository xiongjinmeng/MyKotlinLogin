package movie.bw.com.mykotlinlogin.util

import android.app.Application
import android.content.Context
import android.support.multidex.MultiDex
import com.facebook.drawee.backends.pipeline.Fresco

/**
 * Created by Administrator on 2019/4/8 0008
 */
class App : Application() {
    private var context: Context? = null

    fun getContext(): Context? {
        return context
    }
    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }
    override fun onCreate() {
        super.onCreate()
        Fresco.initialize(this)
        HttpRetrofitUtil.instance.init(UserApi.BASE_URL)
    }
}