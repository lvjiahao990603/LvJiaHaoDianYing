package com.bw.movie.bean;

import java.util.List;

public class YingpingBean {

    /**
     * result : [{"commentContent":"好","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/2019-12-12/20191212135215.png","commentId":2372,"commentTime":1576155578000,"commentUserId":13645,"commentUserName":"太子10","greatNum":0,"isGreat":0,"replyHeadPic":[],"replyNum":0,"score":5.5},{"commentContent":"电影好看","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/2019-11-07/20191107204040.png","commentId":2369,"commentTime":1576129691000,"commentUserId":13597,"commentUserName":"狂饮风中血","greatNum":0,"isGreat":0,"replyHeadPic":[],"replyNum":0,"score":4.5},{"commentContent":"1231","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/2019-12-10/20191210204906.jpg","commentId":2364,"commentTime":1575979715000,"commentUserId":13876,"commentUserName":"杨琰","greatNum":0,"isGreat":0,"replyHeadPic":[],"replyNum":0,"score":4.5},{"commentContent":"aaaaaaa擦","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/bwjy.jpg","commentId":2340,"commentTime":1575548832000,"commentUserId":13871,"commentUserName":"阿斯蒂","greatNum":0,"isGreat":0,"replyHeadPic":[],"replyNum":0,"score":10},{"commentContent":"感觉还不错。。。。","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/2019-12-03/20191203203854.jpg","commentId":2333,"commentTime":1575461160000,"commentUserId":13786,"commentUserName":"yidong11","greatNum":2,"isGreat":0,"replyHeadPic":[],"replyNum":0,"score":9}]
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
         * commentContent : 好
         * commentHeadPic : http://172.17.8.100/images/movie/head_pic/2019-12-12/20191212135215.png
         * commentId : 2372
         * commentTime : 1576155578000
         * commentUserId : 13645
         * commentUserName : 太子10
         * greatNum : 0
         * isGreat : 0
         * replyHeadPic : []
         * replyNum : 0
         * score : 5.5
         */

        private String commentContent;
        private String commentHeadPic;
        private String commentId;
        private long commentTime;
        private String commentUserId;
        private String commentUserName;
        private String greatNum;
        private String isGreat;
        private String replyNum;
        private double score;
        private List<?> replyHeadPic;

        public String getCommentContent() {
            return commentContent;
        }

        public void setCommentContent(String commentContent) {
            this.commentContent = commentContent;
        }

        public String getCommentHeadPic() {
            return commentHeadPic;
        }

        public void setCommentHeadPic(String commentHeadPic) {
            this.commentHeadPic = commentHeadPic;
        }

        public String getCommentId() {
            return commentId;
        }

        public void setCommentId(String commentId) {
            this.commentId = commentId;
        }

        public long getCommentTime() {
            return commentTime;
        }

        public void setCommentTime(long commentTime) {
            this.commentTime = commentTime;
        }

        public String getCommentUserId() {
            return commentUserId;
        }

        public void setCommentUserId(String commentUserId) {
            this.commentUserId = commentUserId;
        }

        public String getCommentUserName() {
            return commentUserName;
        }

        public void setCommentUserName(String commentUserName) {
            this.commentUserName = commentUserName;
        }

        public String getGreatNum() {
            return greatNum;
        }

        public void setGreatNum(String greatNum) {
            this.greatNum = greatNum;
        }

        public String getIsGreat() {
            return isGreat;
        }

        public void setIsGreat(String isGreat) {
            this.isGreat = isGreat;
        }

        public String getReplyNum() {
            return replyNum;
        }

        public void setReplyNum(String replyNum) {
            this.replyNum = replyNum;
        }

        public double getScore() {
            return score;
        }

        public void setScore(double score) {
            this.score = score;
        }

        public List<?> getReplyHeadPic() {
            return replyHeadPic;
        }

        public void setReplyHeadPic(List<?> replyHeadPic) {
            this.replyHeadPic = replyHeadPic;
        }
    }
}
