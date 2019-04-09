package movie.bw.com.mykotlinlogin.util

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.blankj.utilcode.util.BarUtils
import com.jaeger.library.StatusBarUtil

/**
 * Created by Administrator on 2019/4/8 0008
 */
abstract class BaseActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getlayout())
        StatusBarUtil.setTransparent(this)
        BarUtils.setStatusBarVisibility(this, false)
        init()
        initView()
        initData()
    }

    protected abstract fun init()

    protected abstract fun getlayout(): Int

    protected abstract fun initView()

    protected abstract fun initData()
}