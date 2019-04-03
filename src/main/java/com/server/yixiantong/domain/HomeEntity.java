package com.server.yixiantong.domain;

import java.util.List;

public class HomeEntity {

    private List<Banner> bannerEntities;
    private List<Channel> channelEntities;
    private List<Comment> commentEntities;
    private List<TopNews> topNewsEntities;
    private List<Recommend> recommendEntities;

    public List<Banner> getBannerEntities() {
        return bannerEntities;
    }

    public void setBannerEntities(List<Banner> bannerEntities) {
        this.bannerEntities = bannerEntities;
    }

    public List<Channel> getChannelEntities() {
        return channelEntities;
    }

    public void setChannelEntities(List<Channel> channelEntities) {
        this.channelEntities = channelEntities;
    }

    public List<Comment> getCommentEntities() {
        return commentEntities;
    }

    public void setCommentEntities(List<Comment> commentEntities) {
        this.commentEntities = commentEntities;
    }

    public List<TopNews> getTopNewsEntities() {
        return topNewsEntities;
    }

    public void setTopNewsEntities(List<TopNews> topNewsEntities) {
        this.topNewsEntities = topNewsEntities;
    }

    public List<Recommend> getRecommendEntities() {
        return recommendEntities;
    }

    public void setRecommendEntities(List<Recommend> recommendEntities) {
        this.recommendEntities = recommendEntities;
    }
}
