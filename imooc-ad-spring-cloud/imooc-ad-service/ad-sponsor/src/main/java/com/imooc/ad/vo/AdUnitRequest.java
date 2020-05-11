package com.imooc.ad.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang.StringUtils;


/**
 * @auther BoHanMa
 * @date 2020/4/20 9:51
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdUnitRequest {

    private Long planId;
    private String unitName;

    private Integer positionType;
    private Long budget;

    public boolean createValidate(){
        return null != planId
                && !StringUtils.isEmpty(unitName)
                && positionType != null
                && budget != null;
    }

}
