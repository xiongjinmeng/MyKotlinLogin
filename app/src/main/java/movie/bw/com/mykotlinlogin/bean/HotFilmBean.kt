package movie.bw.com.mykotlinlogin.bean

/**
 * Created by Administrator on 2019/3/15 0015
 */
class HotFilmBean {

    /**
     * result : [{"followMovie":2,"id":20,"imageUrl":"http://172.17.8.100/images/movie/stills/ws/ws1.jpg","name":"无双","rank":1,"summary":"以代号\u201c画家\u201d（周润发 饰）为首的犯罪团伙，掌握了制造伪钞技术，难辨真伪，并在全球进行交易获取利益，引起警方高度重视。然而\u201c画家\u201d和其他成员的身份一直成谜，警方的破案进度遭受到了前所未有的挑战。在关键时刻，擅长绘画的李问（郭富城 饰）打开了破案的突破口，而\u201c画家\u201d的真实身份却让众人意想不到\u2026\u2026"},{"followMovie":2,"id":19,"imageUrl":"http://172.17.8.100/images/movie/stills/jhen/jhen1.jpg","name":"江湖儿女","rank":2,"summary":"故事起始于2001年的山西大同，模特巧巧（赵涛 饰）与出租车公司老板斌哥（廖凡 饰）是一对恋人，斌哥每天在外面呼朋唤友，巧巧却希望两人能够尽快步入婚姻的殿堂。然而一次斌哥在街头遭到竞争对手的袭击，巧巧为了保护斌哥在街头开枪，被判刑五年。巧巧出狱以后，开始寻找斌哥以便重新开始，然而事情却发生了意想不到的变化。"}]
     * message : 查询成功
     * status : 0000
     */

    var message: String? = null
    var status: String? = null
    var result: List<ResultBean>? = null

    class ResultBean {
        /**
         * followMovie : 2
         * id : 20
         * imageUrl : http://172.17.8.100/images/movie/stills/ws/ws1.jpg
         * name : 无双
         * rank : 1
         * summary : 以代号“画家”（周润发 饰）为首的犯罪团伙，掌握了制造伪钞技术，难辨真伪，并在全球进行交易获取利益，引起警方高度重视。然而“画家”和其他成员的身份一直成谜，警方的破案进度遭受到了前所未有的挑战。在关键时刻，擅长绘画的李问（郭富城 饰）打开了破案的突破口，而“画家”的真实身份却让众人意想不到……
         */

        var followMovie: String? = null
        var id: Int = 0
        var imageUrl: String? = null
        var name: String? = null
        var rank: Int = 0
        var summary: String? = null
    }
}
