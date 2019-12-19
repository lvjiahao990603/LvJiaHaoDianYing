package com.bw.movie.presenter;

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
import com.bw.movie.contract.IHomeContract;
import com.bw.movie.model.HomeModel;

import java.lang.ref.WeakReference;

public class HomePresenter implements IHomeContract.Ipresenter {

    private HomeModel homeModel;
    private WeakReference<IHomeContract.Iview> viewWeakReference;

    @Override
    public void attach(IHomeContract.Iview view) {
        homeModel = new HomeModel();
        viewWeakReference = new WeakReference<>(view);
    }
    public IHomeContract.Iview getView(){
        return viewWeakReference.get();
    }

    @Override
    public void detach() {
        if (viewWeakReference!=null){
            viewWeakReference.clear();
            viewWeakReference=null;
        }
    }

    @Override
    public void getZhengzaiPresenter(String page, String count) {
        homeModel.onGetZhengzaiData(page, count, new IHomeContract.Imodel.IModelZhengzaiCallback() {
            @Override
            public void onSuccess(ZhengzaiBean data) {
                getView().onHomeZhengzaiSuccess(data);
            }

            @Override
            public void onFailure(String e) {
                getView().onHomeZhengzaiFailure(e);
            }
        });
    }

    @Override
    public void getJijiangPresenter(String page, String count) {
        homeModel.onGetJijiangData(page, count, new IHomeContract.Imodel.IModelJijiangCallback() {
            @Override
            public void onSuccess(JijiangBean data) {
                getView().onHomeJijiangSuccess(data);
            }

            @Override
            public void onFailure(String e) {
                getView().onHomeJijiangFailure(e);
            }
        });
    }

    @Override
    public void getRemenPresenter(String page, String count) {
        homeModel.onGetRemenData(page, count, new IHomeContract.Imodel.IModelRemenCallback() {
            @Override
            public void onSuccess(RemenBean data) {
                getView().onHomeRemenSuccess(data);
            }

            @Override
            public void onFailure(String e) {
                getView().onHomeRemenFailure(e);
            }
        });
    }

    @Override
    public void getXbannerPresenter() {
        homeModel.onGetXbannerData(new IHomeContract.Imodel.IModelXbannerCallback() {
            @Override
            public void onSuccess(XbannerBean data) {
                getView().onHomeXbannerSuccess(data);
            }

            @Override
            public void onFailure(String e) {
                getView().onHomeXbannerFailure(e);
            }
        });
    }

    @Override
    public void getXiangqingPresenter(String userId, String sessionId, String movieId) {
        homeModel.onGetXiangqingData(userId, sessionId, movieId, new IHomeContract.Imodel.IModelXiangqingCallback() {
            @Override
            public void onSuccess(XiangqingBean data) {
                getView().onHomeGetXiangqingSuccess(data);
            }

            @Override
            public void onFailure(String e) {
                getView().onHomeGetXiangqingFailure(e);
            }
        });
    }

    @Override
    public void getSousuoPresenter(String keyword, String page, String count) {
        homeModel.onGetSousuoData(keyword, page, count, new IHomeContract.Imodel.IModelSousuoCallback() {
            @Override
            public void onSuccess(SousuoBean data) {
                getView().onHomeGetSousuoSuccess(data);
            }

            @Override
            public void onFailure(String e) {
                getView().onHomeGetSousuoFailure(e);
            }
        });
    }

    @Override
    public void getYingpingPresenter(String movieId, String page, String count) {
        homeModel.onGetYingpingData(movieId, page, count, new IHomeContract.Imodel.IModelYingpingCallback() {
            @Override
            public void onSuccess(YingpingBean data) {
                getView().onHomeGetYingpingSuccess(data);
            }

            @Override
            public void onFailure(String e) {
                getView().onHomeGetYingpingFailure(e);
            }
        });
    }

    @Override
    public void getTuijianPresenter(String userId, String sessionId, String page, String count) {
        homeModel.onGetTuijianData(userId, sessionId, page, count, new IHomeContract.Imodel.IModelTuijianCallback() {
            @Override
            public void onSuccess(TuijianBean data) {
                getView().onHomeGetTuijianSuccess(data);
            }

            @Override
            public void onFailure(String e) {
                getView().onHomeGetTuijianFailure(e);
            }
        });
    }

    @Override
    public void getFujinPresenter(String userId, String sessionId, String longitude, String latitude, String page, String count) {
        homeModel.onGetFujinData(userId, sessionId, longitude, latitude, page, count, new IHomeContract.Imodel.IModelFujinCallback() {
            @Override
            public void onSuccess(FujinBean data) {
                getView().onHomeGetFujinSuccess(data);
            }

            @Override
            public void onFailure(String e) {
                getView().onHomeGetFujinFailure(e);
            }
        });
    }

    @Override
    public void getYingyuansouPresenter(String cinemaName, String page, String count) {
        homeModel.onGetYingyuansouData(cinemaName, page, count, new IHomeContract.Imodel.IModelYingyuansouCallback() {
            @Override
            public void onSuccess(YingyuanSouBean data) {
                getView().onHomeGetYingyuansouSuccess(data);
            }

            @Override
            public void onFailure(String e) {
                getView().onHomeGetYingyuansouFailure(e);
            }
        });
    }

    @Override
    public void getQuyuPresenter() {
        homeModel.onGetQuyuData(new IHomeContract.Imodel.IModelQuyuCallback() {
            @Override
            public void onSuccess(QuyuBean data) {
                getView().onHomeGetQuyuSuccess(data);
            }

            @Override
            public void onFailure(String e) {
                getView().onHomeGetQuyuFailure(e);
            }
        });
    }

    @Override
    public void getQuyuliebiaoPresenter(String regionId) {
        homeModel.onGetQutuliebiao(regionId, new IHomeContract.Imodel.IModelQuyuliebiaoCallback() {
            @Override
            public void onSuccess(QuyuLiebiaoBean data) {
                getView().onHomeGetQuyuliebiaoSuccess(data);
            }

            @Override
            public void onFailure(String e) {
                getView().onHomeGetQuyuliebiaoFailure(e);
            }
        });
    }

    @Override
    public void getYingyuanXQPresenter(String cinemaId) {
        homeModel.onGetYingyuanxq(cinemaId, new IHomeContract.Imodel.IModelYingyuanXQCallback() {
            @Override
            public void onSuccess(YingyuanXQBean data) {
                getView().onHomeGetYingyuanXQSuccess(data);
            }

            @Override
            public void onFailure(String e) {
                getView().onHomeGetYingyuanXQFailure(e);
            }
        });
    }

    @Override
    public void postLoginPresenter(String email, String pwd) {
        homeModel.onPostLoginData(email, pwd, new IHomeContract.Imodel.IModelLoginCallback() {
            @Override
            public void onSuccess(LoginBean data) {
                getView().onHomePostLoginSuccess(data);
            }

            @Override
            public void onFailure(String e) {
                getView().onHomePostLoginFailure(e);
            }
        });
    }

    @Override
    public void getPaiqiPresenter() {
        homeModel.onPaiqiData(new IHomeContract.Imodel.IModelPaiqiCallback() {
            @Override
            public void onSuccess(PaiqiBean data) {
                getView().onHomeGetPaiqiSuccess(data);
            }

            @Override
            public void onFailure(String e) {
                getView().onHomeGetPaiqiFailure(e);
            }
        });
    }

    @Override
    public void getPaiqishowPresenter(String cinemaId, String page, String count) {
        homeModel.onPaiqiShowData(cinemaId, page, count, new IHomeContract.Imodel.IModelPaiqishowCallback() {
            @Override
            public void onSuccess(PaiqiShowBean data) {
                getView().onHomeGetPaiqishowSuccess(data);
            }

            @Override
            public void onFailure(String e) {
                getView().onHomeGetPaiqishowFailure(e);
            }
        });
    }

    @Override
    public void getZuoPresenter(String hallId) {
        homeModel.onZuoData(hallId, new IHomeContract.Imodel.IModelZuoCallback() {
            @Override
            public void onSuccess(ZuoBean data) {
                getView().onHomeGetZuoSuccess(data);
            }

            @Override
            public void onFailure(String e) {
                getView().onHomeGetZuoFailure(e);
            }
        });
    }

    @Override
    public void getBuyPresenter(String cinemaId, String movieId) {
        homeModel.onBuyData(cinemaId, movieId, new IHomeContract.Imodel.IModelBuyCallback() {
            @Override
            public void onSuccess(BuyBean data) {
                getView().onHomeGetBuySuccess(data);
            }

            @Override
            public void onFailure(String e) {
                getView().onHomeGetBuyFailure(e);
            }
        });
    }

    @Override
    public void getGoupiaoPresenter(String userId, String sessionId, String scheduleId, String seat, String sign) {
        homeModel.onGoupiaoData(userId, sessionId, scheduleId, seat, sign, new IHomeContract.Imodel.IModelGoupiaoCallback() {
            @Override
            public void onSuccess(GoupiaoBean data) {
                getView().onHomeGetGoupiaoSuccess(data);
            }

            @Override
            public void onFailure(String e) {
                getView().onHomeGetGoupiaoFailure(e);
            }
        });
    }

    @Override
    public void getZhifuPresenter(String userId, String sessionId, String payType, String orderId) {
        homeModel.onZhifuData(userId, sessionId, payType, orderId, new IHomeContract.Imodel.IModelZhifuCallback() {
            @Override
            public void onSuccess(ZhifuBean data) {
                getView().onHomeGetZhifuSuccess(data);
            }

            @Override
            public void onFailure(String e) {
                getView().onHomeGetZhifuFailure(e);
            }
        });
    }

    @Override
    public void getRegisterPresenter(String nickName, String pwd, String email, String code) {
        homeModel.onRegisterData(nickName, pwd, email, code, new IHomeContract.Imodel.IModelRegisterCallback() {
            @Override
            public void onSuccess(RegisterBean data) {
                getView().onHomeGetRegisterSuccess(data);
            }

            @Override
            public void onFailure(String e) {
                getView().onHomeGetRegisterFailure(e);
            }
        });
    }

    @Override
    public void getCodePresenter(String email) {
        homeModel.onCodeData(email, new IHomeContract.Imodel.IModelCodeCallback() {
            @Override
            public void onSuccess(CodeBean data) {
                getView().onHomeGetCodeSuccess(data);
            }

            @Override
            public void onFailure(String e) {
                getView().onHomeGetCodeFailure(e);
            }
        });
    }

    @Override
    public void getXieyingpingPresenter(String movieId, String page, String count) {
        homeModel.onXieyingpingData(movieId, page, count, new IHomeContract.Imodel.IModelXieyingpingCallback() {
            @Override
            public void onSuccess(XieyingpingBean data) {
                getView().onHomeGetXieyingpingSuccess(data);
            }

            @Override
            public void onFailure(String e) {
                getView().onHomeGetXieyingpingFailure(e);
            }
        });
    }
}
