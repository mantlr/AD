package com.imooc.ad.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @auther BoHanMa
 * @date 2020/4/20 13:50
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreativeUnitRequest {

    private List<CreativeUnitItem> unitItems;
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CreativeUnitItem{

        private Long creativeId;
        private Long unitId;

    }


}
