package com.imooc.ad.index.adplan;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;


/**
 * @auther BoHanMa
 * @date 2020/4/26 10:55
 */
@Data
@NotNull
@AllArgsConstructor
public class AdPlanObject {


    private Long planId;
    private Long userId;
    private Integer status;
    private Date startDate;
    private Date endDate;


    public void update(AdPlanObject newObject){
        if(null != newObject.getPlanId()){
            this.planId = newObject.getPlanId();
        }
        if(null != newObject.getUserId()){
            this.userId = newObject.getUserId();
        }

        if(null != newObject.getStatus()){
            this.status = newObject.getStatus();
        }

        if(null != newObject.getStartDate()){
            this.startDate = newObject.getStartDate();
        }

        if(null != newObject.getEndDate()){
            this.endDate = newObject.getEndDate();
        }

    }


}
