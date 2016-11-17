package com.example.dllo.gifttalk.beans;

import com.litesuits.orm.db.annotation.PrimaryKey;
import com.litesuits.orm.db.enums.AssignType;

/**
 * Created by dllo on 16/11/15.
 */
public class ProfileBean {

    // 自增ID
    @PrimaryKey(AssignType.AUTO_INCREMENT)
    // bmob ID代码 objectID String
    private String objectId;

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }
}
