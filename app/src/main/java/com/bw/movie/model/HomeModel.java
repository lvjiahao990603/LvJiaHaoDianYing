package com.bw.movie.model;

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
import com.bw.movie.utils.RetrofitUtils;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class HomeModel implements IHomeContract.Imodel {

    private Observable<ZhengzaiBean> zhengzaiBeanObservable;
    private Observer<ZhengzaiBean> observer;
    private Observable<JijiangBean> jijiangBeanObservable;
    private Observer<JijiangBean> observer1;
    private Observable<RemenBean> remenBeanObservable;
    private Observer<RemenBean> observer2;
    private Observable<XbannerBean> xbannerBeanObservable;
    private Observer<XbannerBean> observer3;
    private Observable<XiangqingBean> xiangqingBeanObservable;
    private Observer<XiangqingBean> observer4;
    private Observable<SousuoBean> sousuoBeanObservable;
    private Observer<SousuoBean> observer5;
    private Observable<YingpingBean> yingpingBeanObservable;
    private Observer<YingpingBean> observer6;
    private Observable<TuijianBean> tuijianBeanObservable;
    private Observer<TuijianBean> observer7;
    private Observable<FujinBean> fujinBeanObservable;
    private Observer<FujinBean> observer8;
    private Observable<YingyuanSouBean> yingyuanSouBeanObservable;
    private Observer<YingyuanSouBean> observer9;
    private Observable<QuyuBean> quyuBeanObservable;
    private Observer<QuyuBean> observer10;
    private Observable<QuyuLiebiaoBean> quyuLiebiaoBeanObservable;
    private Observer<QuyuLiebiaoBean> observer11;
    private Observable<YingyuanXQBean> yingyuanXQBeanObservable;
    private Observer<YingyuanXQBean> observer12;
    private Observable<LoginBean> loginBeanObservable;
    private Observer<LoginBean> observer13;
    private Observable<PaiqiBean> paiqiBeanObservable;
    private Observer<PaiqiBean> observer14;
    private Observable<PaiqiShowBean> paiqiShowBeanObservable;
    private Observer<PaiqiShowBean> observer15;
    private Observable<ZuoBean> zuoBeanObservable;
    private Observer<ZuoBean> observer16;
    private Observable<BuyBean> buyBeanObservable;
    private Observer<BuyBean> observer17;
    private Observable<GoupiaoBean> goupiaoBeanObservable;
    private Observer<GoupiaoBean> observer18;
    private Observable<ZhifuBean> zhifuBeanObservable;
    private Observer<ZhifuBean> observer19;
    private Observable<RegisterBean> registerBeanObservable;
    private Observer<RegisterBean> observer20;
    private Observable<CodeBean> codeBeanObservable;
    private Observer<CodeBean> observer21;
    private Observable<XieyingpingBean> xieyingpingBeanObservable;
    private Observer<XieyingpingBean> observer22;

    @Override
    public void onGetZhengzaiData(String page, String count, final IModelZhengzaiCallback iModelZhengzaiCallback) {
        zhengzaiBeanObservable = RetrofitUtils.getApiServer().onGetZhengzai(page, count);
        observer = new Observer<ZhengzaiBean>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(ZhengzaiBean zhengzaiBean) {
                iModelZhengzaiCallback.onSuccess(zhengzaiBean);
            }

            @Override
            public void onError(Throwable e) {
                iModelZhengzaiCallback.onFailure(e.getMessage().toString());
            }

            @Override
            public void onComplete() {

            }
        };
        zhengzaiBeanObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    @Override
    public void onGetJijiangData(String page, String count, final IModelJijiangCallback iModelJijiangCallback) {
        jijiangBeanObservable = RetrofitUtils.getApiServer().onGetJijiang(page, count);
        observer1 = new Observer<JijiangBean>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(JijiangBean jijiangBean) {
                iModelJijiangCallback.onSuccess(jijiangBean);
            }

            @Override
            public void onError(Throwable e) {
                iModelJijiangCallback.onFailure(e.getMessage().toString());
            }

            @Override
            public void onComplete() {

            }
        };
        jijiangBeanObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer1);
    }

    @Override
    public void onGetRemenData(String page, String count, final IModelRemenCallback iModelRemenCallback) {
        remenBeanObservable = RetrofitUtils.getApiServer().onGetRenmen(page, count);
        observer2 = new Observer<RemenBean>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(RemenBean remenBean) {
                iModelRemenCallback.onSuccess(remenBean);
            }

            @Override
            public void onError(Throwable e) {
                iModelRemenCallback.onFailure(e.getMessage().toString());
            }

            @Override
            public void onComplete() {

            }
        };
        remenBeanObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer2);
    }

    @Override
    public void onGetXbannerData(final IModelXbannerCallback iModelXbannerCallback) {
        xbannerBeanObservable = RetrofitUtils.getApiServer().onGetXbanner();
        observer3 = new Observer<XbannerBean>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(XbannerBean xbannerBean) {
                iModelXbannerCallback.onSuccess(xbannerBean);
            }

            @Override
            public void onError(Throwable e) {
                iModelXbannerCallback.onFailure(e.getMessage().toString());
            }

            @Override
            public void onComplete() {

            }
        };
        xbannerBeanObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer3);
    }

    @Override
    public void onGetXiangqingData(String userId, String sessionId, String movieId, IModelXiangqingCallback iModelXiangqingCallback) {
        xiangqingBeanObservable = RetrofitUtils.getApiServer().onGetXiangqing(userId, sessionId, movieId);
        observer4 = new Observer<XiangqingBean>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(XiangqingBean xiangqingBean) {
                iModelXiangqingCallback.onSuccess(xiangqingBean);
            }

            @Override
            public void onError(Throwable e) {
                iModelXiangqingCallback.onFailure(e.getMessage().toString());
            }

            @Override
            public void onComplete() {

            }
        };
        xiangqingBeanObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer4);
    }

    @Override
    public void onGetSousuoData(String keyword, String page, String count, IModelSousuoCallback iModelSousuoCallback) {
        sousuoBeanObservable = RetrofitUtils.getApiServer().onGetSousuo(keyword, page, count);
        observer5 = new Observer<SousuoBean>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(SousuoBean sousuoBean) {
                iModelSousuoCallback.onSuccess(sousuoBean);
            }

            @Override
            public void onError(Throwable e) {
                iModelSousuoCallback.onFailure(e.getMessage().toString());
            }

            @Override
            public void onComplete() {

            }
        };
        sousuoBeanObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer5);
    }

    @Override
    public void onGetYingpingData(String movieId, String page, String count, IModelYingpingCallback iModelYingpingCallback) {
        yingpingBeanObservable = RetrofitUtils.getApiServer().onGetYingping(movieId, page, count);
        observer6 = new Observer<YingpingBean>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(YingpingBean yingpingBean) {
                iModelYingpingCallback.onSuccess(yingpingBean);
            }

            @Override
            public void onError(Throwable e) {
                iModelYingpingCallback.onFailure(e.getMessage().toString());
            }

            @Override
            public void onComplete() {

            }
        };
        yingpingBeanObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer6);
    }

    @Override
    public void onGetTuijianData(String userId, String sessionId, String page, String count, IModelTuijianCallback iModelTuijianCallback) {
        tuijianBeanObservable = RetrofitUtils.getApiServer().onGetTuijian(userId, sessionId, page, count);
        observer7 = new Observer<TuijianBean>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(TuijianBean tuijianBean) {
                iModelTuijianCallback.onSuccess(tuijianBean);
            }

            @Override
            public void onError(Throwable e) {
                iModelTuijianCallback.onFailure(e.getMessage().toString());
            }

            @Override
            public void onComplete() {

            }
        };
        tuijianBeanObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer7);
    }

    @Override
    public void onGetFujinData(String userId, String sessionId, String longitude, String latitude, String page, String count, IModelFujinCallback iModelFujinCallback) {
        fujinBeanObservable = RetrofitUtils.getApiServer().onGetFujin(userId, sessionId, longitude, latitude, page, count);
        observer8 = new Observer<FujinBean>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(FujinBean fujinBean) {
                iModelFujinCallback.onSuccess(fujinBean);
            }

            @Override
            public void onError(Throwable e) {
                iModelFujinCallback.onFailure(e.getMessage().toString());
            }

            @Override
            public void onComplete() {

            }
        };
        fujinBeanObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer8);
    }

    @Override
    public void onGetYingyuansouData(String cinemaName, String page, String count, IModelYingyuansouCallback iModelYingyuansouCallback) {
        yingyuanSouBeanObservable = RetrofitUtils.getApiServer().onGetYingyuansou(cinemaName, page, count);
        observer9 = new Observer<YingyuanSouBean>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(YingyuanSouBean yingyuanSouBean) {
                iModelYingyuansouCallback.onSuccess(yingyuanSouBean);
            }

            @Override
            public void onError(Throwable e) {
                iModelYingyuansouCallback.onFailure(e.getMessage().toString());
            }

            @Override
            public void onComplete() {

            }
        };
        yingyuanSouBeanObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer9);
    }

    @Override
    public void onGetQuyuData(IModelQuyuCallback iModelQuyuCallback) {
        quyuBeanObservable = RetrofitUtils.getApiServer().onGetQuyu();
        observer10 = new Observer<QuyuBean>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(QuyuBean quyuBean) {
                iModelQuyuCallback.onSuccess(quyuBean);
            }

            @Override
            public void onError(Throwable e) {
                iModelQuyuCallback.onFailure(e.getMessage().toString());
            }

            @Override
            public void onComplete() {

            }
        };
        quyuBeanObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer10);
    }

    @Override
    public void onGetQutuliebiao(String regionId, IModelQuyuliebiaoCallback iModelQuyuliebiaoCallback) {
        quyuLiebiaoBeanObservable = RetrofitUtils.getApiServer().onGetQuyuliebiao(regionId);
        observer11 = new Observer<QuyuLiebiaoBean>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(QuyuLiebiaoBean quyuLiebiaoBean) {
                iModelQuyuliebiaoCallback.onSuccess(quyuLiebiaoBean);
            }

            @Override
            public void onError(Throwable e) {
                iModelQuyuliebiaoCallback.onFailure(e.getMessage().toString());
            }

            @Override
            public void onComplete() {

            }
        };
        quyuLiebiaoBeanObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer11);
    }

    @Override
    public void onGetYingyuanxq(String cinemaId, IModelYingyuanXQCallback iModelYingyuanXQCallback) {
        yingyuanXQBeanObservable = RetrofitUtils.getApiServer().onGetYingyuanxq(cinemaId);
        observer12 = new Observer<YingyuanXQBean>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(YingyuanXQBean yingyuanXQBean) {
                iModelYingyuanXQCallback.onSuccess(yingyuanXQBean);
            }

            @Override
            public void onError(Throwable e) {
                iModelYingyuanXQCallback.onFailure(e.getMessage().toString());
            }

            @Override
            public void onComplete() {

            }
        };
        yingyuanXQBeanObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer12);
    }

    @Override
    public void onPostLoginData(String email, String pwd, IModelLoginCallback iModelLoginCallback) {
        loginBeanObservable = RetrofitUtils.getApiServer().onPostLogin(email, pwd);
        observer13 = new Observer<LoginBean>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(LoginBean loginBean) {
                iModelLoginCallback.onSuccess(loginBean);
            }

            @Override
            public void onError(Throwable e) {
                iModelLoginCallback.onFailure(e.getMessage().toString());
            }

            @Override
            public void onComplete() {

            }
        };
        loginBeanObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer13);
    }

    @Override
    public void onPaiqiData(IModelPaiqiCallback iModelPaiqiCallback) {
        paiqiBeanObservable = RetrofitUtils.getApiServer().getPaiqi();
        observer14 = new Observer<PaiqiBean>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(PaiqiBean paiqiBean) {
                iModelPaiqiCallback.onSuccess(paiqiBean);
            }

            @Override
            public void onError(Throwable e) {
                iModelPaiqiCallback.onFailure(e.getMessage().toString());
            }

            @Override
            public void onComplete() {

            }
        };
        paiqiBeanObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer14);
    }

    @Override
    public void onPaiqiShowData(String cinemaId, String page, String count, IModelPaiqishowCallback iModelPaiqishowCallback) {
        paiqiShowBeanObservable = RetrofitUtils.getApiServer().getPaiqishow(cinemaId, page, count);
        observer15 = new Observer<PaiqiShowBean>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(PaiqiShowBean paiqiShowBean) {
                iModelPaiqishowCallback.onSuccess(paiqiShowBean);
            }

            @Override
            public void onError(Throwable e) {
                iModelPaiqishowCallback.onFailure(e.getMessage().toString());
            }

            @Override
            public void onComplete() {

            }
        };
        paiqiShowBeanObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer15);
    }

    @Override
    public void onZuoData(String hallId, IModelZuoCallback iModelZuoCallback) {
        zuoBeanObservable = RetrofitUtils.getApiServer().getZuo(hallId);
        observer16 = new Observer<ZuoBean>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(ZuoBean zuoBean) {
                iModelZuoCallback.onSuccess(zuoBean);
            }

            @Override
            public void onError(Throwable e) {
                iModelZuoCallback.onFailure(e.getMessage().toString());
            }

            @Override
            public void onComplete() {

            }
        };
        zuoBeanObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer16);
    }

    @Override
    public void onBuyData(String cinemaId, String movieId, IModelBuyCallback iModelBuyCallback) {
        buyBeanObservable = RetrofitUtils.getApiServer().getBuy(cinemaId, movieId);
        observer17 = new Observer<BuyBean>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(BuyBean buyBean) {
                iModelBuyCallback.onSuccess(buyBean);
            }

            @Override
            public void onError(Throwable e) {
                iModelBuyCallback.onFailure(e.getMessage().toString());
            }

            @Override
            public void onComplete() {

            }
        };
        buyBeanObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer17);
    }

    @Override
    public void onGoupiaoData(String userId, String sessionId, String scheduleId, String seat, String sign, IModelGoupiaoCallback iModelGoupiaoCallback) {
        goupiaoBeanObservable = RetrofitUtils.getApiServer().getGoupiao(userId, sessionId, scheduleId, seat, sign);
        observer18 = new Observer<GoupiaoBean>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(GoupiaoBean goupiaoBean) {
                iModelGoupiaoCallback.onSuccess(goupiaoBean);
            }

            @Override
            public void onError(Throwable e) {
                iModelGoupiaoCallback.onFailure(e.getMessage().toString());
            }

            @Override
            public void onComplete() {

            }
        };
        goupiaoBeanObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer18);
    }

    @Override
    public void onZhifuData(String userId, String sessionId, String payType, String orderId, IModelZhifuCallback iModelZhifuCallback) {
        zhifuBeanObservable = RetrofitUtils.getApiServer().getZhifu(userId, sessionId, payType, orderId);
        observer19 = new Observer<ZhifuBean>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(ZhifuBean zhifuBean) {
                iModelZhifuCallback.onSuccess(zhifuBean);
            }

            @Override
            public void onError(Throwable e) {
                iModelZhifuCallback.onFailure(e.getMessage().toString());
            }

            @Override
            public void onComplete() {

            }
        };
        zhifuBeanObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer19);
    }

    @Override
    public void onRegisterData(String nickName, String pwd, String email, String code, IModelRegisterCallback iModelRegisterCallback) {
        registerBeanObservable = RetrofitUtils.getApiServer().getRegister(nickName, pwd, email, code);
        observer20 = new Observer<RegisterBean>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(RegisterBean registerBean) {
                iModelRegisterCallback.onSuccess(registerBean);
            }

            @Override
            public void onError(Throwable e) {
                iModelRegisterCallback.onFailure(e.getMessage().toString());
            }

            @Override
            public void onComplete() {

            }
        };
        registerBeanObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer20);
    }

    @Override
    public void onCodeData(String email, IModelCodeCallback iModelCodeCallback) {
        codeBeanObservable = RetrofitUtils.getApiServer().getCode(email);
        observer21 = new Observer<CodeBean>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(CodeBean codeBean) {
                iModelCodeCallback.onSuccess(codeBean);
            }

            @Override
            public void onError(Throwable e) {
                iModelCodeCallback.onFailure(e.getMessage().toString());
            }

            @Override
            public void onComplete() {

            }
        };
        codeBeanObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer21);
    }

    @Override
    public void onXieyingpingData(String movieId, String page, String count, IModelXieyingpingCallback iModelXieyingpingCallback) {
        xieyingpingBeanObservable = RetrofitUtils.getApiServer().getXieyingping(movieId, page, count);
        observer22 = new Observer<XieyingpingBean>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(XieyingpingBean xieyingpingBean) {
                iModelXieyingpingCallback.onSuccess(xieyingpingBean);
            }

            @Override
            public void onError(Throwable e) {
                iModelXieyingpingCallback.onFailure(e.getMessage().toString());
            }

            @Override
            public void onComplete() {

            }
        };
        xieyingpingBeanObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer22);
    }
}
