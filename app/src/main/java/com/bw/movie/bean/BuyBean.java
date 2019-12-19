package com.bw.movie.bean;

import java.util.List;

public class BuyBean {

    /**
     * result : [{"begStringime":"17:00:00","endTime":"18:58:00","fare":0.01,"hallId":39,"id":16,"screeningHall":"杜比厅"},{"begStringime":"19:30:00","endTime":"21:28:00","fare":0.01,"hallId":40,"id":17,"screeningHall":"2号激光厅"},{"begStringime":"20:50:00","endTime":"22:48:00","fare":0.01,"hallId":41,"id":18,"screeningHall":"3号厅"}]
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
         * begtime : 17:00:00
         * endTime : 18:58:00
         * fare : 0.01
         * hallId : 39
         * id : 16
         * screeningHall : 杜比厅
         */

        private String beginTime;
        private String endTime;
        private double fare;
        private String hallId;
        private String id;
        private String screeningHall;

        public String getBeginTime() {
            return beginTime;
        }

        public void setBeginTime(String beginTime) {
            this.beginTime = beginTime;
        }

        public String getEndTime() {
            return endTime;
        }

        public void setEndTime(String endTime) {
            this.endTime = endTime;
        }

        public double getFare() {
            return fare;
        }

        public void setFare(double fare) {
            this.fare = fare;
        }

        public String getHallId() {
            return hallId;
        }

        public void setHallId(String hallId) {
            this.hallId = hallId;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getScreeningHall() {
            return screeningHall;
        }

        public void setScreeningHall(String screeningHall) {
            this.screeningHall = screeningHall;
        }
    }
}
