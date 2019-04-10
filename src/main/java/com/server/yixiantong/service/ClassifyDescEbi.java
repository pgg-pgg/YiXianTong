package com.server.yixiantong.service;



import com.server.yixiantong.domain.ClassifyDescEntity;

public interface ClassifyDescEbi {
    String insertClassifyType(ClassifyDescEntity classifyDescEntity);

    String getAllClassifyDesc(int classifyTypeId);
}
