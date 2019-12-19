package com.bw.movie.contract;

import com.bw.movie.bean.BuyBean;
import com.bw.movie.bean.CodeBean;
import com.bw.movie.bean.FujinBean;
import com.bw.movie.bean.GoupiaoBean;
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

public interface IHomeContract {
    //view interface
    interface Iview{
        //Xbanner
        void onHomeXbannerSuccess(XbannerBean data);
        void onHomeXbannerFailure(String e);
        //正在
        void onHomeZhengzaiSuccess(ZhengzaiBean data);
        void onHomeZhengzaiFailure(String e);
        //即将
        void onHomeJijiangSuccess(JijiangBean data);
        void onHomeJijiangFailure(String e);
        //热门
        void onHomeRemenSuccess(RemenBean data);
        void onHomeRemenFailure(String e);
        //详情
        void onHomeGetXiangqingSuccess(XiangqingBean data);
        void onHomeGetXiangqingFailure(String e);
        //搜索
        void onHomeGetSousuoSuccess(SousuoBean data);
        void onHomeGetSousuoFailure(String e);
        //影评
        void onHomeGetYingpingSuccess(YingpingBean data);
        void onHomeGetYingpingFailure(String e);
        //推荐影院
        void onHomeGetTuijianSuccess(TuijianBean data);
        void onHomeGetTuijianFailure(String e);
        //附近影院
        void onHomeGetFujinSuccess(FujinBean data);
        void onHomeGetFujinFailure(String e);
        //影院搜索
        void onHomeGetYingyuansouSuccess(YingyuanSouBean data);
        void onHomeGetYingyuansouFailure(String e);
        //区域
        void onHomeGetQuyuSuccess(QuyuBean data);
        void onHomeGetQuyuFailure(String e);
        //区域列表
        void onHomeGetQuyuliebiaoSuccess(QuyuLiebiaoBean data);
        void onHomeGetQuyuliebiaoFailure(String e);
        //影院详情
        void onHomeGetYingyuanXQSuccess(YingyuanXQBean data);
        void onHomeGetYingyuanXQFailure(String e);
        //登录
        void onHomePostLoginSuccess(LoginBean data);
        void onHomePostLoginFailure(String e);
        //排期
        void onHomeGetPaiqiSuccess(PaiqiBean data);
        void onHomeGetPaiqiFailure(String e);
        //排期展示
        void onHomeGetPaiqishowSuccess(PaiqiShowBean data);
        void onHomeGetPaiqishowFailure(String e);
        //选座那玩意
        void onHomeGetZuoSuccess(ZuoBean data);
        void onHomeGetZuoFailure(String e);
        //杜比厅那玩意
        void onHomeGetBuySuccess(BuyBean data);
        void onHomeGetBuyFailure(String e);
        //购票下单
        void onHomeGetGoupiaoSuccess(GoupiaoBean data);
        void onHomeGetGoupiaoFailure(String e);
        //支付
        void onHomeGetZhifuSuccess(ZhifuBean data);
        void onHomeGetZhifuFailure(String e);
        //注册
        void onHomeGetRegisterSuccess(RegisterBean data);
        void onHomeGetRegisterFailure(String e);
        //验证码
        void onHomeGetCodeSuccess(CodeBean data);
        void onHomeGetCodeFailure(String e);
        //写影评
        void onHomeGetXieyingpingSuccess(XieyingpingBean data);
        void onHomeGetXieyingpingFailure(String e);
    }
    //model interface
    interface Imodel{
        //正在
        void onGetZhengzaiData(String page,String count,IModelZhengzaiCallback iModelZhengzaiCallback);
        //即将
        void onGetJijiangData(String page,String count,IModelJijiangCallback iModelJijiangCallback);
        //热门
        void onGetRemenData(String page,String count,IModelRemenCallback iModelRemenCallback);
        //Xbanner
        void onGetXbannerData(IModelXbannerCallback iModelXbannerCallback);
        //详情
        void onGetXiangqingData(String userId,String sessionId,String movieId,IModelXiangqingCallback iModelXiangqingCallback);
        //搜索
        void onGetSousuoData(String keyword,String page,String count,IModelSousuoCallback iModelSousuoCallback);
        //影评
        void onGetYingpingData(String movieId,String page,String count,IModelYingpingCallback iModelYingpingCallback);
        //推荐影院
        void onGetTuijianData(String userId,String sessionId,String page,String count,IModelTuijianCallback iModelTuijianCallback);
        //附近影院
        void onGetFujinData(String userId,String sessionId,String longitude,String latitude,String page,String count,IModelFujinCallback iModelFujinCallback);
        //影院搜索
        void onGetYingyuansouData(String cinemaName,String page,String count,IModelYingyuansouCallback iModelYingyuansouCallback);
        //区域
        void onGetQuyuData(IModelQuyuCallback iModelQuyuCallback);
        //区域列表
        void onGetQutuliebiao(String regionId,IModelQuyuliebiaoCallback iModelQuyuliebiaoCallback);
        //影院详情
        void onGetYingyuanxq(String cinemaId,IModelYingyuanXQCallback iModelYingyuanXQCallback);
        //登录
        void onPostLoginData(String email,String pwd,IModelLoginCallback iModelLoginCallback);
        //排期
        void onPaiqiData(IModelPaiqiCallback iModelPaiqiCallback);
        //排期展示
        void onPaiqiShowData(String cinemaId,String page,String count,IModelPaiqishowCallback iModelPaiqishowCallback);
        //选座那玩意
        void onZuoData(String hallId,IModelZuoCallback iModelZuoCallback);
        //杜比厅那玩意
        void onBuyData(String cinemaId,String movieId,IModelBuyCallback iModelBuyCallback);
        //购票下单
        void onGoupiaoData(String userId,String sessionId,String scheduleId,String seat,String sign,IModelGoupiaoCallback iModelGoupiaoCallback);
        //支付
        void onZhifuData(String userId,String sessionId,String payType,String orderId,IModelZhifuCallback iModelZhifuCallback);
        //注册
        void onRegisterData(String nickName,String pwd,String email,String code,IModelRegisterCallback iModelRegisterCallback);
        //验证码
        void onCodeData(String email,IModelCodeCallback iModelCodeCallback);
        //写影评
        void onXieyingpingData(String movieId,String page,String count,IModelXieyingpingCallback iModelXieyingpingCallback);
        //正在
        interface IModelZhengzaiCallback{
            void onSuccess(ZhengzaiBean data);
            void onFailure(String e);
        }
        //即将
        interface IModelJijiangCallback{
            void onSuccess(JijiangBean data);
            void onFailure(String e);
        }
        //热门
        interface IModelRemenCallback{
            void onSuccess(RemenBean data);
            void onFailure(String e);
        }
        //Xbanner
        interface IModelXbannerCallback{
            void onSuccess(XbannerBean data);
            void onFailure(String e);
        }
        //详情
        interface IModelXiangqingCallback{
            void onSuccess(XiangqingBean data);
            void onFailure(String e);
        }
        //搜索
        interface IModelSousuoCallback{
            void onSuccess(SousuoBean data);
            void onFailure(String e);
        }
        //影评
        interface IModelYingpingCallback{
            void onSuccess(YingpingBean data);
            void onFailure(String e);
        }
        //推荐影院
        interface IModelTuijianCallback{
            void onSuccess(TuijianBean data);
            void onFailure(String e);
        }
        //附近影院
        interface IModelFujinCallback{
            void onSuccess(FujinBean data);
            void onFailure(String e);
        }
        //影院搜索
        interface IModelYingyuansouCallback{
            void onSuccess(YingyuanSouBean data);
            void onFailure(String e);
        }
        //区域
        interface IModelQuyuCallback{
            void onSuccess(QuyuBean data);
            void onFailure(String e);
        }
        //区域列表
        interface IModelQuyuliebiaoCallback{
            void onSuccess(QuyuLiebiaoBean data);
            void onFailure(String e);
        }
        //影院详情
        interface IModelYingyuanXQCallback{
            void onSuccess(YingyuanXQBean data);
            void onFailure(String e);
        }
        //登录
        interface IModelLoginCallback{
            void onSuccess(LoginBean data);
            void onFailure(String e);
        }
        //排期
        interface IModelPaiqiCallback{
            void onSuccess(PaiqiBean data);
            void onFailure(String e);
        }
        //排期展示
        interface IModelPaiqishowCallback{
            void onSuccess(PaiqiShowBean data);
            void onFailure(String e);
        }
        //选座那玩意
        interface IModelZuoCallback{
            void onSuccess(ZuoBean data);
            void onFailure(String e);
        }
        //杜比厅那玩意
        interface IModelBuyCallback{
            void onSuccess(BuyBean data);
            void onFailure(String e);
        }
        //购票下单
        interface IModelGoupiaoCallback{
            void onSuccess(GoupiaoBean data);
            void onFailure(String e);
        }
        //支付
        interface IModelZhifuCallback{
            void onSuccess(ZhifuBean data);
            void onFailure(String e);
        }
        //注册
        interface IModelRegisterCallback{
            void onSuccess(RegisterBean data);
            void onFailure(String e);
        }
        //验证码
        interface IModelCodeCallback{
            void onSuccess(CodeBean data);
            void onFailure(String e);
        }
        //写影评
        interface IModelXieyingpingCallback{
            void onSuccess(XieyingpingBean data);
            void onFailure(String e);
        }
    }
    //presenter interface
    interface Ipresenter{
        void attach(IHomeContract.Iview view);
        void detach();
        //正在
        void getZhengzaiPresenter(String page,String count);
        //即将
        void getJijiangPresenter(String page,String count);
        //热门
        void getRemenPresenter(String page,String count);
        //Xbanner
        void getXbannerPresenter();
        //详情
        void getXiangqingPresenter(String userId,String sessionId,String movieId);
        //搜索
        void getSousuoPresenter(String keyword,String page, String count);
        //影评
        void getYingpingPresenter(String movieId,String page,String count);
        //推荐影院
        void getTuijianPresenter(String userId,String sessionId,String page,String count);
        //附近影院
        void getFujinPresenter(String userId,String sessionId,String longitude,String latitude,String page,String count);
        //影院搜索
        void getYingyuansouPresenter(String cinemaName,String page,String count);
        //区域
        void getQuyuPresenter();
        //区域列表
        void getQuyuliebiaoPresenter(String regionId);
        //影院详情
        void getYingyuanXQPresenter(String cinemaId);
        //登录
        void postLoginPresenter(String email,String pwd);
        //排期
        void getPaiqiPresenter();
        //排期展示
        void getPaiqishowPresenter(String cinemaId,String page,String count);
        //选座那玩意
        void getZuoPresenter(String hallId);
        //杜比厅那玩意
        void getBuyPresenter(String cinemaId,String movieId);
        //购票下单
        void getGoupiaoPresenter(String userId,String sessionId,String scheduleId,String seat,String sign);
        //支付
        void getZhifuPresenter(String userId,String sessionId,String payType,String orderId);
        //注册
        void getRegisterPresenter(String nickName,String pwd,String email,String code);
        //验证码
        void getCodePresenter(String email);
        //写影评
        void getXieyingpingPresenter(String movieId,String page,String count);
    }
}
