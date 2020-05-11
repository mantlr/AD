package com.imooc.ad.index.creativeunit;

import com.imooc.ad.index.IndexAware;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


/**
 * @auther BoHanMa
 * @date 2020/5/11 15:25
 */
@Component
@Slf4j
public class CreativeUnitIndex implements IndexAware<String,CreativeUnitObject> {
    @Override
    public CreativeUnitObject get(String key) {
        return null;
    }

    @Override
    public void add(String key, CreativeUnitObject value) {

    }

    @Override
    public void update(String key, CreativeUnitObject value) {

    }

    @Override
    public void delete(String key, CreativeUnitObject value) {

    }
}
