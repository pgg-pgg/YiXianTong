package com.server.yixiantong.service;



import com.server.yixiantong.domain.ClassifyItemEntity;
import com.server.yixiantong.domain.ClassifyTypeEntity;

public interface ClassifyTypeEbi {


    String insertClassifyType(ClassifyTypeEntity classifyTypeEntity);

    String getAllClassifyType();

    String getClassifyItemByPosition(int classifyTypeId);
}
