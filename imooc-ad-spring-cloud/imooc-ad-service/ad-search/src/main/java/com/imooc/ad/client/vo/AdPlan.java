package com.imooc.ad.client.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @auther BoHanMa
 * @date 2020/4/24 14:33
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdPlan {

    private Long id;
    private Long userId;
    private String planName;
    private Integer planStatus;
    private Date startDate;
    private Date endDate;
    private Date CreateTime;
    private Date updateTime;

}
