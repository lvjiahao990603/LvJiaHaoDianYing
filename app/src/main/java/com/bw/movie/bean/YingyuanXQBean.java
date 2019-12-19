package com.bw.movie.bean;

public class YingyuanXQBean {

    /**
     * result : {"address":"建国路93号万达广场三层","businessHoursContent":"星期一 至 星期日   早09:00:00 - 晚24:00:00","commentTotal":0,"distance":0,"followCinema":2,"id":6,"label":"3D眼镜,儿童优惠","logo":"http://172.17.8.100/images/movie/logo/wd.jpg","name":"北京CBD万达广场店","phone":"010-59603399","vehicleRoute":"公交车1.57等路在郎家园下车；地铁1号线大望路下车，往西走500米。"}
     * message : 查询成功
     * status : 0000
     */

    private ResultBean result;
    private String message;
    private String status;

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

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

    public static class ResultBean {
        /**
         * address : 建国路93号万达广场三层
         * businessHoursContent : 星期一 至 星期日   早09:00:00 - 晚24:00:00
         * commentTotal : 0
         * distance : 0
         * followCinema : 2
         * id : 6
         * label : 3D眼镜,儿童优惠
         * logo : http://172.17.8.100/images/movie/logo/wd.jpg
         * name : 北京CBD万达广场店
         * phone : 010-59603399
         * vehicleRoute : 公交车1.57等路在郎家园下车；地铁1号线大望路下车，往西走500米。
         */

        private String address;
        private String businessHoursContent;
        private String commentTotal;
        private String distance;
        private String followCinema;
        private String id;
        private String label;
        private String logo;
        private String name;
        private String phone;
        private String vehicleRoute;

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getBusinessHoursContent() {
            return businessHoursContent;
        }

        public void setBusinessHoursContent(String businessHoursContent) {
            this.businessHoursContent = businessHoursContent;
        }

        public String getCommentTotal() {
            return commentTotal;
        }

        public void setCommentTotal(String commentTotal) {
            this.commentTotal = commentTotal;
        }

        public String getDistance() {
            return distance;
        }

        public void setDistance(String distance) {
            this.distance = distance;
        }

        public String getFollowCinema() {
            return followCinema;
        }

        public void setFollowCinema(String followCinema) {
            this.followCinema = followCinema;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            this.label = label;
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

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getVehicleRoute() {
            return vehicleRoute;
        }

        public void setVehicleRoute(String vehicleRoute) {
            this.vehicleRoute = vehicleRoute;
        }
    }
}
