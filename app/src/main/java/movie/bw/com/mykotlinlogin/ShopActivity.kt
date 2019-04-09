package movie.bw.com.mykotlinlogin
import android.app.PendingIntent.getActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_shop.*
import movie.bw.com.mykotlinlogin.adapter.MyMoviesAdapter
import movie.bw.com.mykotlinlogin.bean.HotFilmBean
import movie.bw.com.mykotlinlogin.bean.RegisteredBean
import movie.bw.com.mykotlinlogin.mvp.presenter.Presenter
import movie.bw.com.mykotlinlogin.mvp.view.IView
import movie.bw.com.mykotlinlogin.util.BaseActivity
import movie.bw.com.mykotlinlogin.util.UserApi
import java.util.HashMap

class ShopActivity : BaseActivity(),IView {
    val presenter= Presenter(this)
    override fun onSuccessful(string: String) {
        val gson = Gson()
        val bean = gson.fromJson<HotFilmBean>(string, HotFilmBean::class.java)
        if (bean.status.equals("0000")){
            val result = bean.result
            shopet.layoutManager = LinearLayoutManager(this)
            val adapter = MyMoviesAdapter(this@ShopActivity, result)
            shopet.setAdapter(adapter)
        }
    }

    override fun onError(e: String) {
        Log.e("------",e)
    }

    override fun init() {

        val map = HashMap<String, String>()
        map.put("page","1")
        map.put("count","10")
        presenter.shop(UserApi.MOVIE_API,map)
    }

    override fun getlayout(): Int {
        return R.layout.activity_shop
    }

    override fun initView() {

    }

    override fun initData() {

    }

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_shop)
//    }
}
