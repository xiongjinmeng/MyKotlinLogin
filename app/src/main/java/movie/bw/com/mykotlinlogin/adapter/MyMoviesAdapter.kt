package movie.bw.com.mykotlinlogin.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import movie.bw.com.mykotlinlogin.R
import movie.bw.com.mykotlinlogin.bean.HotFilmBean

/**
 * Created by Administrator on 2019/4/9 0009
 */
class MyMoviesAdapter : RecyclerView.Adapter<MyMoviesAdapter.ViewHolder> {
     val list: List<HotFilmBean.ResultBean>?

     val context: Context

    constructor(context: Context, list: List<HotFilmBean.ResultBean>?){
        this.context = context
        this.list = list
    }
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.layout_adapter_list, p0, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list!!.size
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        val name = list!!.get(p1).name
        val imageUrl = list!!.get(p1).imageUrl
        p0.textView.setText(name)
        Glide.with(context).load(imageUrl).apply(RequestOptions.bitmapTransform(RoundedCorners(8))).into(p0.imageView)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val imageView = itemView.findViewById<ImageView>(R.id.image_adapter)
            val textView = itemView.findViewById<TextView>(R.id.text_adapter)

    }


}