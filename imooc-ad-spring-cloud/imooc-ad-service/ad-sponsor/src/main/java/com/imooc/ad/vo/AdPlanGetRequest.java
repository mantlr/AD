package com.imooc.ad.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author Swallow
 * @auther BoHanMa
 * @date 2020/4/19 14:26
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AdPlanGetRequest {

    private Long userId;
    private List<Long> ids;

    public boolean validate(){
        return userId != null && !CollectionUtils.isEmpty(ids);
    }

}
