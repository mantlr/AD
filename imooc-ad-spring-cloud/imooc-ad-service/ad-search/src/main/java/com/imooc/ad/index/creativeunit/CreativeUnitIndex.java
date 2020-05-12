package com.imooc.ad.index.creativeunit;

import com.imooc.ad.index.IndexAware;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

 import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;


/**
 * @author Swallow
 * @auther BoHanMa
 * @date 2020/5/11 15:25
 */
@Component
@Slf4j
public class CreativeUnitIndex implements IndexAware<String,CreativeUnitObject> {

    /*
    <adId-unitId, CreativeUnitObject>
     */
    private static Map<String, CreativeUnitObject> objectMap;

    /*
      <adId, unitId Set>
     */
    private static Map<Long, Set<Long>> creativeUintMap;

    /*
    <unitId, adId Set>
     */
    private static Map<Long,Set<Long>> unitCreativeMap;

    static {
        objectMap = new ConcurrentHashMap<>();
        creativeUintMap = new ConcurrentHashMap<>();
        unitCreativeMap = new ConcurrentHashMap<>();
    }

    @Override
    public CreativeUnitObject get(String key) {
        return objectMap.get(key);
    }

    @Override
    public void add(String key, CreativeUnitObject value) {
    log.info("before add: {}",objectMap);

    objectMap.put(key, value);
    Set<Long> unitSet = creativeUintMap.get(value.getAdId());
    if(CollectionUtils.isEmpty(unitSet)){
        unitSet = new ConcurrentSkipListSet<>();
        creativeUintMap.put(value.getAdId(),unitSet);
    }
    unitSet.add(value.getUnitId());
    Set<Long> creativeSet = unitCreativeMap.get(value.getUnitId());
    if(CollectionUtils.isEmpty(creativeSet)){
        creativeSet = new ConcurrentSkipListSet<>();
        unitCreativeMap.put(value.getUnitId(),creativeSet);
    }
    creativeSet.add(value.getAdId());
    log.info("after add: {}",objectMap);
    }

    @Override
    public void update(String key, CreativeUnitObject value) {

        log.info("CreativeUnitIndex is not support update");

    }

    @Override
    public void delete(String key, CreativeUnitObject value) {
        log.info("before delete: {}",objectMap);
        objectMap.remove(key);
        Set<Long> unitSet = creativeUintMap.get(value.getAdId());
        if(CollectionUtils.isEmpty(unitSet)){
            unitSet.remove(value.getUnitId());
        }
        Set<Long> creativeSet = unitCreativeMap.get(value.getUnitId());
        if(CollectionUtils.isEmpty(creativeSet)){
            creativeSet.remove(value.getAdId());
        }
        log.info("after delete: {}",objectMap);
    }
}
