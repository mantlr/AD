package com.imooc.ad.dump;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Swallow
 * @auther BoHanMa
 * @date 2020/5/12 16:47
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdUnitTable {

    private Long unitId;
    private Integer unitStaus;
    private Integer positionType;

    private Long planId;

}
