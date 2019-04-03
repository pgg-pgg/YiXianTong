package com.server.yixiantong.service;


import com.server.yixiantong.domain.Banner;

import java.util.List;

public interface BannerEbi {


    String insertBanner(Banner banner);

    List<Banner> getBannerList();
}
