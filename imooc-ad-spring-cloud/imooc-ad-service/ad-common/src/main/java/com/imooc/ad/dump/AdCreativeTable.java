package com.imooc.ad.dump;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @auther BoHanMa
 * @date 2020/5/13 10:36
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdCreativeTable {

    private Long adId;
    private String name;
    private Integer type;
    private Integer materialType;
    private Integer height;
    private Integer width;
    private Integer auditStatus;
    private String adUrl;
}
