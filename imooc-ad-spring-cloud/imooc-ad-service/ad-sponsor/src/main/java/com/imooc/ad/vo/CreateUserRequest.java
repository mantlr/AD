package com.imooc.ad.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang.StringUtils;

/**
 * @author Swallow
 * @auther BoHanMa
 * @date 2020/4/19 10:18
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserRequest {

    private String username;

    public boolean validate(){
        return !StringUtils.isEmpty(username);
    }

}
