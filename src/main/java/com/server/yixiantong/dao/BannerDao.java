package com.server.yixiantong.dao;


import com.server.yixiantong.domain.Banner;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface BannerDao {

    void insertBanner(Banner banner);

    List<Banner> getBannerList();

}
