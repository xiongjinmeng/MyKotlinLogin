package movie.bw.com.mykotlinlogin

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.blankj.utilcode.util.PhoneUtils
import com.blankj.utilcode.util.ScreenUtils
import com.blankj.utilcode.util.ToastUtils
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_registered.*
import movie.bw.com.mykotlinlogin.base.EncryptUtil
import movie.bw.com.mykotlinlogin.bean.RegisteredBean
import movie.bw.com.mykotlinlogin.mvp.presenter.Presenter
import movie.bw.com.mykotlinlogin.mvp.view.IView
import movie.bw.com.mykotlinlogin.util.BaseActivity
import movie.bw.com.mykotlinlogin.util.UserApi
import java.math.BigDecimal
import java.util.HashMap

class RegisteredActivity : BaseActivity(), IView {
    val presenter= Presenter(this)
    override fun onSuccessful(string: String) {
        val gson = Gson()
        val bean = gson.fromJson<RegisteredBean>(string, RegisteredBean::class.java)
        if (bean.status.equals("0000")){
            ToastUtils.showLong(bean.message)
            finish()
        }

    }

    override fun onError(e: String) {
        Log.e("------",e)
    }

    @SuppressLint("MissingPermission")
    override fun init() {
        btn_registered_registered.setOnClickListener {
            val name = edit_registered_name.text.toString()
            val sex = edit_registered_sex.text.toString()
            val date = edit_registered_date.text.toString()
            val mail = edit_registered_mail.text.toString()
            val phone = edit_registered_phone.text.toString()
            val pwass = edit_registered_pwass.text.toString()
            val map = HashMap<String, String>()
            map.put("nickName", name)
            map.put("phone", phone)
            val encrypt = EncryptUtil.encrypt(pwass)
            map.put("pwd", encrypt)
            map.put("pwd2", encrypt)
            if (sex.equals("女")){
                map.put("sex","2")
            } else{
                map.put("sex","1")
            }
            map.put("birthday", date)
            //手机唯一识别码
            map.put("imei", PhoneUtils.getDeviceId())
            //设备类型
            map.put("ua", Build.BRAND)
            //屏幕尺寸
            //屏幕尺寸
            val x = Math.pow((ScreenUtils.getScreenWidth() / ScreenUtils.getScreenDensityDpi()).toDouble(), 2.0)
            val y = Math.pow((ScreenUtils.getScreenHeight() / ScreenUtils.getScreenDensityDpi()).toDouble(), 2.0)
            //屏幕尺寸
            val decimal = BigDecimal(Math.sqrt(x + y)).setScale(1, BigDecimal.ROUND_UP)
            val doubleValue = decimal.toDouble()
            map.put("screenSize", ""+doubleValue)
            //设备系统
            map.put("os", "android")
            map.put("email", mail)
            presenter.login(UserApi.REGISTER_URL,map)
        }
    }

    override fun getlayout(): Int {
        return R.layout.activity_registered
    }

    override fun initView() {
    }

    override fun initData() {
    }

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_registered)
//    }
}
