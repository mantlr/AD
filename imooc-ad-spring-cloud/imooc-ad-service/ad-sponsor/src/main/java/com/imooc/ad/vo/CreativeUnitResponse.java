package com.imooc.ad.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @auther BoHanMa
 * @date 2020/4/20 13:52
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreativeUnitResponse {
    private List<Long> ids;
}
