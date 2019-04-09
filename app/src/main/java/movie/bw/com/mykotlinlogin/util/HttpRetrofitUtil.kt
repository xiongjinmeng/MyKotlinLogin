package movie.bw.com.mykotlinlogin.util

import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.Retrofit






/**
 * Created by Administrator on 2019/4/7 0007
 */
    //kotlin实现
    class HttpRetrofitUtil private constructor() {
        companion object {
            val instance: HttpRetrofitUtil by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
                HttpRetrofitUtil()
            }
        }


        private lateinit var retrofit: Retrofit

         fun init(string: String) {
            retrofit = Retrofit.Builder()
                    .client(okHttpClient())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(string)
                    .build()
        }

        private fun okHttpClient(): OkHttpClient {
            val loggingInterceptor: HttpLoggingInterceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

            return OkHttpClient.Builder()
                    .readTimeout(5, TimeUnit.SECONDS)
                    .writeTimeout(5, TimeUnit.SECONDS)
                    .connectTimeout(5, TimeUnit.SECONDS)
                    .addInterceptor(loggingInterceptor)
                    .addNetworkInterceptor(loggingInterceptor)
                    .build()
        }

        fun <T> create(aClass: Class<T>): T {

            return retrofit.create(aClass)
        }
    }

