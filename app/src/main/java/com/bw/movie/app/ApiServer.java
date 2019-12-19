package com.bw.movie.app;


import com.bw.movie.bean.BuyBean;
import com.bw.movie.bean.CodeBean;
import com.bw.movie.bean.FujinBean;
import com.bw.movie.bean.GoupiaoBean;
import com.bw.movie.bean.JiaMiBean;
import com.bw.movie.bean.JijiangBean;
import com.bw.movie.bean.LoginBean;
import com.bw.movie.bean.PaiqiBean;
import com.bw.movie.bean.PaiqiShowBean;
import com.bw.movie.bean.QuyuBean;
import com.bw.movie.bean.QuyuLiebiaoBean;
import com.bw.movie.bean.RegisterBean;
import com.bw.movie.bean.RemenBean;
import com.bw.movie.bean.SousuoBean;
import com.bw.movie.bean.TuijianBean;
import com.bw.movie.bean.XbannerBean;
import com.bw.movie.bean.XiangqingBean;
import com.bw.movie.bean.XieyingpingBean;
import com.bw.movie.bean.YingpingBean;
import com.bw.movie.bean.YingyuanSouBean;
import com.bw.movie.bean.YingyuanXQBean;
import com.bw.movie.bean.ZhengzaiBean;
import com.bw.movie.bean.ZhifuBean;
import com.bw.movie.bean.ZuoBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiServer {
    //Xbanner
    @GET("tool/v2/banner")
    Observable<XbannerBean> onGetXbanner();
    //热门
    @GET("movie/v2/findHotMovieList")
    Observable<RemenBean> onGetRenmen(@Query("page") String page, @Query("count") String count);
    //正在
    @GET("movie/v2/findReleaseMovieList")
    Observable<ZhengzaiBean>onGetZhengzai(@Query("page") String page, @Query("count") String count);
    //即将
    @GET("movie/v2/findComingSoonMovieList")
    Observable<JijiangBean>onGetJijiang(@Query("page") String page, @Query("count") String count);
    //详情
    @GET("movie/v2/findMoviesDetail")
    Observable<XiangqingBean>onGetXiangqing(@Query("userId")String userId, @Query("sessionId")String sessionId, @Query("movieId")String movieId);
    //搜索
    @GET("movie/v2/findMovieByKeyword")
    Observable<SousuoBean>onGetSousuo(@Query("keyword")String keyword, @Query("page") String page, @Query("count") String count);
    //根据电影的id查询电影评论
    //http://172.17.8.100/movieApi/movie/v2/findAllMovieComment
    @GET("movie/v2/findAllMovieComment")
    Observable<YingpingBean> onGetYingping(@Query("movieId")String movieId, @Query("page")String page, @Query("count")String count);
    //推荐影院
    @GET("cinema/v1/findRecommendCinemas")
    Observable<TuijianBean> onGetTuijian(@Header("userId") String userId , @Header("sessionId") String sessionId,
                                    @Query("page") String page, @Query("count") String count);
    //查询附近影院
    @GET("cinema/v1/findNearbyCinemas")
    Observable<FujinBean> onGetFujin(@Header("userId") String userId,
                                  @Header("sessionId") String sessionId,
                                  @Query("longitude") String longitude,
                                  @Query("latitude") String latitude,
                                  @Query("page") String  page,
                                  @Query("count") String count);
    //http://172.17.8.100/movieApi/cinema/v1/findAllCinemas?page=1&count=10&cinemaName=北京
    @GET("cinema/v1/findAllCinemas")
    Observable<YingyuanSouBean>onGetYingyuansou(@Query("cinemaName")String cinemaName,@Query("page")String page,@Query("count")String count);
    //查询地区
    //http://172.17.8.100/movieApi/tool/v2/findRegionList
    @GET("tool/v2/findRegionList")
    Observable<QuyuBean> onGetQuyu();
    //http://172.17.8.100/movieApi/cinema/v1/findNearbyCinemas
    //根据地区查询影院
    @GET("cinema/v2/findCinemaByRegion")
    Observable<QuyuLiebiaoBean> onGetQuyuliebiao(@Query("regionId") String regionId);
    //查询电影信息明细
    //http://172.17.8.100/movieApi/cinema/v1/findCinemaInfo
    @GET("cinema/v1/findCinemaInfo")
    Observable<YingyuanXQBean> onGetYingyuanxq(@Query("cinemaId")String cinemaId);
    //http://172.17.8.100/movieApi/user/v2/login
    @FormUrlEncoded
    @POST("user/v2/login")
    Observable<LoginBean> onPostLogin(@Field("email")String email, @Field("pwd")String pwd);
    @GET("tool/v1/encrypt")
    Observable<JiaMiBean> onJiami(@Query("password")String sid);
    //查询一周排期的时间
    //http://172.17.8.100/movieApi/tool/v2/findDateList
    @GET("tool/v2/findDateList")
    Observable<PaiqiBean> getPaiqi();
    //排期展示
    //http://172.17.8.100/movieApi/cinema/v2/findCinemaScheduleList
    @GET("cinema/v2/findCinemaScheduleList")
    Observable<PaiqiShowBean> getPaiqishow(@Query("cinemaId")String cinemaId,
                                                     @Query("page")String page,
                                                     @Query("count")String count);
    //根据影厅id 查询座位信息
    @GET("movie/v2/findSeatInfo")
    Observable<ZuoBean> getZuo(@Query("hallId")String hallId);
    //根据电影ID和影院ID查询电影排期列表
    //http://172.17.8.100/movieApi/movie/v2/findMovieSchedule
    @GET("movie/v2/findMovieSchedule")
    Observable<BuyBean> getBuy(@Query("cinemaId")String cinemaId, @Query("movieId")String movieId);
    //购票下单
    //http://172.17.8.100/movieApi/movie/v2/verify/buyMovieTickets
    @FormUrlEncoded
    @POST("movie/v2/verify/buyMovieTickets")
    Observable<GoupiaoBean> getGoupiao(@Header("userId")String userId,
                                       @Header("sessionId")String sessionId,
                                       @Field("scheduleId")String scheduleId,
                                       @Field("seat")String seat,
                                       @Field("sign")String sign);
    //支付
    //http://172.17.8.100/movieApi/movie/v2/verify/pay
    @FormUrlEncoded
    @POST("movie/v2/verify/pay")
    Observable<ZhifuBean> getZhifu(@Header("userId")String userId,
                                   @Header("sessionId")String sessionId,
                                   @Field("payType")String payType,
                                   @Field("orderId")String orderId);
    //验证码
    @FormUrlEncoded
    @POST("user/v2/sendOutEmailCode")
    Observable<CodeBean>getCode(@Field("email")String email);
    //注册
    @FormUrlEncoded
    @POST("user2/register")
    Observable<RegisterBean>getRegister(@Query("nickName")String nickName, @Query("pwd")String pwd,
                                  @Field("email")String email, @Field("code")String code);
    //根据电影的id查询电影评论
    //http://172.17.8.100/movieApi/movie/v2/findAllMovieComment
    @GET("movie/v2/findAllMovieComment")
    Observable<XieyingpingBean> getXieyingping(@Query("movieId")String movieId, @Query("page")String page, @Query("count")String count);
}
