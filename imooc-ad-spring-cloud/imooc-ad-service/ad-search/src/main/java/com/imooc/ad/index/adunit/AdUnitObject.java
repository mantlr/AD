package com.imooc.ad.index.adunit;

import com.imooc.ad.client.vo.AdPlan;
import com.imooc.ad.index.adplan.AdPlanObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;

/**
 * @auther BoHanMa
 * @date 2020/4/26 11:11
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdUnitObject {

    private Long unitId;
    private Integer unitStatus;
    private Integer positionType;
    private Long planId;

    private AdPlanObject adPlanObject;

    void update(AdUnitObject newObject){

        if(null != newObject.getUnitId()){
            this.unitId = newObject.getUnitId();
        }

        if( null != newObject.getUnitStatus()){
            this.unitStatus = newObject.getUnitStatus();
        }

        if(null != newObject.getPositionType()){
            this.positionType = newObject.getPositionType();
        }

        if(null != newObject.getPlanId()){
            this.planId = newObject.getPlanId();
        }

        if(null != newObject.getAdPlanObject()){
            this.adPlanObject = newObject.getAdPlanObject();
        }


    }

}
