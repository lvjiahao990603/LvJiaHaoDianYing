package com.bw.movie.bean;

import java.util.List;

public class YingyuanSouBean {

    /**
     * result : [{"address":"育知东路30号华联商厦4层","commentTotal":0,"distance":0,"followCinema":0,"id":20,"logo":"http://172.17.8.100/images/movie/logo/wmyc.jpg","name":"北京沃美影城"},{"address":"悦秀路99号二层大地影院","commentTotal":0,"distance":0,"followCinema":0,"id":19,"logo":"http://172.17.8.100/images/movie/logo/ddyy.jpg","name":"大地影院-北京海淀西三旗物美"},{"address":"上地南口华联商厦4F","commentTotal":0,"distance":0,"followCinema":0,"id":18,"logo":"http://172.17.8.100/images/movie/logo/ctjh.jpg","name":"橙天嘉禾影城北京上地店"},{"address":"黄平路19号院龙旗购物中心3层","commentTotal":0,"distance":0,"followCinema":0,"id":17,"logo":"http://172.17.8.100/images/movie/logo/blgj.jpg","name":"保利国际影城北京龙旗广场店"},{"address":"中关村大街19号新中关购物中心B1层","commentTotal":0,"distance":0,"followCinema":0,"id":15,"logo":"http://172.17.8.100/images/movie/logo/jy.jpg","name":"金逸北京中关村店"},{"address":"新街口外大街25号","commentTotal":0,"distance":0,"followCinema":0,"id":14,"logo":"http://172.17.8.100/images/movie/logo/zygj.jpg","name":"中影国际影城北京小西天店"},{"address":"复兴路69号五棵松卓展时代百货五层东侧","commentTotal":0,"distance":0,"followCinema":0,"id":13,"logo":"http://172.17.8.100/images/movie/logo/bjalclgj.jpg","name":"北京耀莱成龙国际影城"},{"address":"崇文门外大街18号国瑞城首层、地下二层","commentTotal":0,"distance":0,"followCinema":0,"id":9,"logo":"http://172.17.8.100/images/movie/logo/blh.jpg","name":"北京百老汇影城国瑞购物中心店"},{"address":"三丰北里2号楼悠唐广场B1层","commentTotal":0,"distance":0,"followCinema":0,"id":8,"logo":"http://172.17.8.100/images/movie/logo/bn.jpg","name":"北京博纳影城朝阳门旗舰店"},{"address":"建国门外大街1号国贸商城区域三地下一层3B120","commentTotal":0,"distance":0,"followCinema":0,"id":7,"logo":"http://172.17.8.100/images/movie/logo/blg.jpg","name":"北京百丽宫影城"}]
     * message : 查询成功
     * status : 0000
     */

    private String message;
    private String status;
    private List<ResultBean> result;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * address : 育知东路30号华联商厦4层
         * commentTotal : 0
         * distance : 0
         * followCinema : 0
         * id : 20
         * logo : http://172.17.8.100/images/movie/logo/wmyc.jpg
         * name : 北京沃美影城
         */

        private String address;
        private int commentTotal;
        private int distance;
        private int followCinema;
        private int id;
        private String logo;
        private String name;

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public int getCommentTotal() {
            return commentTotal;
        }

        public void setCommentTotal(int commentTotal) {
            this.commentTotal = commentTotal;
        }

        public int getDistance() {
            return distance;
        }

        public void setDistance(int distance) {
            this.distance = distance;
        }

        public int getFollowCinema() {
            return followCinema;
        }

        public void setFollowCinema(int followCinema) {
            this.followCinema = followCinema;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getLogo() {
            return logo;
        }

        public void setLogo(String logo) {
            this.logo = logo;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
