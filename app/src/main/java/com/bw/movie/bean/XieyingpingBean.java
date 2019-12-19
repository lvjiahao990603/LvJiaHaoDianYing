package com.bw.movie.bean;

import java.util.List;

public class XieyingpingBean {

    /**
     * result : [{"commentContent":"啊啊啊","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/2019-12-05/20191205133233.jpg","commentId":2309,"commentTime":1575336764000,"commentUserId":13804,"commentUserName":"神奇动物","greatNum":0,"isGreat":0,"replyHeadPic":[],"replyNum":0,"score":4.5},{"commentContent":"呵呵","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/2019-11-29/20191129194354.jpg","commentId":2294,"commentTime":1575287999000,"commentUserId":13814,"commentUserName":"深海","greatNum":0,"isGreat":0,"replyHeadPic":[],"replyNum":0,"score":4.5},{"commentContent":"好看","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/2019-11-26/20191126151014.png","commentId":2291,"commentTime":1575287238000,"commentUserId":13774,"commentUserName":"你的益达啊","greatNum":0,"isGreat":0,"replyHeadPic":[],"replyNum":0,"score":4.5},{"commentContent":"电影好看","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/2019-11-15/20191115204235.unknown","commentId":2274,"commentTime":1575270940000,"commentUserId":13777,"commentUserName":"tian","greatNum":0,"isGreat":0,"replyHeadPic":[],"replyNum":0,"score":4.5},{"commentContent":"好看","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/2019-12-09/20191209145236.unknown","commentId":2256,"commentTime":1575199832000,"commentUserId":13692,"commentUserName":"Tow Smelly","greatNum":0,"isGreat":0,"replyHeadPic":[],"replyNum":0,"score":4.5}]
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
         * commentContent : 啊啊啊
         * commentHeadPic : http://172.17.8.100/images/movie/head_pic/2019-12-05/20191205133233.jpg
         * commentId : 2309
         * commentTime : 1575336764000
         * commentUserId : 13804
         * commentUserName : 神奇动物
         * greatNum : 0
         * isGreat : 0
         * replyHeadPic : []
         * replyNum : 0
         * score : 4.5
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
