package com.imooc.ad.creative;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @auther BoHanMa
 * @date 2020/5/6 11:10
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreativeObject {

    private Long adId;
    private String name;
    private Integer type;
    private Integer materialType;
    private Integer height;
    private Integer width;
    private Integer auditStatus;
    private String adUrl;

    public void update(CreativeObject newObject){

        if(null != newObject.getAdId() ){
            this.adId = newObject.getAdId();
        }
        if(null != newObject.getName()){
            this.name = newObject.getName();
        }
    }

}
