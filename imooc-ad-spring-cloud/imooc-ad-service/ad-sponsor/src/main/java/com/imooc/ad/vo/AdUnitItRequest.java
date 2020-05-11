package com.imooc.ad.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @auther BoHanMa
 * @date 2020/4/20 10:22
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdUnitItRequest {


    private List<UnitIt> unitIts;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UnitIt{
        private Long unitId;
        private String itTag;

    }

}
