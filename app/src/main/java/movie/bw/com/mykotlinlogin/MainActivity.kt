package movie.bw.com.mykotlinlogin

import android.content.Intent
import android.util.Log
import com.blankj.utilcode.util.SPUtils
import com.blankj.utilcode.util.ToastUtils
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import movie.bw.com.mykotlinlogin.base.EncryptUtil
import movie.bw.com.mykotlinlogin.bean.RegisteredBean
import movie.bw.com.mykotlinlogin.mvp.presenter.Presenter
import movie.bw.com.mykotlinlogin.mvp.view.IView
import movie.bw.com.mykotlinlogin.util.BaseActivity
import movie.bw.com.mykotlinlogin.util.UserApi
import java.util.*

class MainActivity : BaseActivity(),IView {

    val presenter=Presenter(this)
    override fun onSuccessful(string: String) {
        val gson = Gson()
        val bean = gson.fromJson<RegisteredBean>(string, RegisteredBean::class.java)
        if (bean.status.equals("0000")){
            val intent = Intent(this, ShopActivity::class.java)
            startActivity(intent)
            ToastUtils.showLong(bean.message)
        }


    }

    override fun onError(e: String) {
        Log.e("------",e)
    }

    override fun init() {
        btn_login_login.setOnClickListener {
            val phone = edit_login_phone.text.toString()
            val pwass = edit_login_pwass.text.toString()
            val map = HashMap<String, String>()
            map.put("phone",phone)
            val encrypt = EncryptUtil.encrypt(pwass)
            map.put("pwd",encrypt)
            presenter.login(UserApi.LOGIN_URL,map)
        }
        text_login_registered.setOnClickListener {
            val intent = Intent(this, RegisteredActivity::class.java)
            startActivity(intent)
        }



    }

    override fun getlayout(): Int {
    return R.layout.activity_main
    }

    override fun initView() {

    }

    override fun initData() {

    }

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//    }
}
