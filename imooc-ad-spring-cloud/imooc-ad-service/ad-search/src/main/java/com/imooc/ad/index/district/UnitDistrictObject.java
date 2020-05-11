package com.imooc.ad.index.district;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @auther BoHanMa
 * @date 2020/5/6 9:26
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UnitDistrictObject {

    private Long unitId;
    private String province;
    private String city;

    // <String,Set<Long>>
    //province-city



}
