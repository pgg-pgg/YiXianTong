package com.server.yixiantong.service.impl;

import com.alibaba.fastjson.JSON;
import com.server.yixiantong.dao.BannerDao;
import com.server.yixiantong.domain.Banner;
import com.server.yixiantong.domain.ResponseMessage;
import com.server.yixiantong.service.BannerEbi;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service
public class BannerEbo implements BannerEbi {
    @Resource
    public BannerDao bannerDao;

    @Override
    public String insertBanner(Banner banner) {
        bannerDao.insertBanner(banner);
        ResponseMessage<Banner> responseMessage = new ResponseMessage<>(0,"插入成功",banner);
        return JSON.toJSONString(responseMessage);
    }

    @Override
    public List<Banner> getBannerList() {
        List<Banner> bannerList = bannerDao.getBannerList();
        return bannerList;
    }
}