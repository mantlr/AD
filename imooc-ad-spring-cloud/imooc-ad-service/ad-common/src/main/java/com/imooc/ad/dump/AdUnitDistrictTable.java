package com.imooc.ad.dump;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @auther BoHanMa
 * @date 2020/5/13 10:35
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdUnitDistrictTable {

    private Long unitId;
    private String province;
    private String city;

}
