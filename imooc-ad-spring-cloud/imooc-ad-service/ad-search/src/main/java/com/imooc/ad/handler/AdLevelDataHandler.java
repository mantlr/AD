package com.imooc.ad.handler;

import com.imooc.ad.client.vo.AdPlan;
import com.imooc.ad.creative.CreativeIndex;
import com.imooc.ad.creative.CreativeObject;
import com.imooc.ad.dump.*;
import com.imooc.ad.index.DataTable;
import com.imooc.ad.index.IndexAware;
import com.imooc.ad.index.adplan.AdPlanIndex;
import com.imooc.ad.index.adplan.AdPlanObject;
import com.imooc.ad.index.adunit.AdUnitIndex;
import com.imooc.ad.index.adunit.AdUnitObject;
import com.imooc.ad.mysql.constant.OpType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;

import java.awt.font.OpenType;

/**
 * 1. 索引之间存在层级的划分，也就是依赖关系的划分
 * 2. 加载全量索引其实是增量索引，“添加”的一种特殊实现
 * @auther BoHanMa
 * @date 2020/5/18 15:11
 */
@Slf4j
public class AdLevelDataHandler {


    public static void handleLevel2(AdPlanTable planTable,OpType type){
        AdPlanObject planObject = new AdPlanObject(
                planTable.getId(),
                planTable.getUserId(),
                planTable.getPlanStatus(),
                planTable.getStartDate(),
                planTable.getEndDate()

        );
        handlerBinlogEvent(DataTable.of(AdPlanIndex.class),
                planObject.getPlanId(),
                planObject,
                type
                );
    }

    public static void handleLevel2(AdCreativeTable creativeTable,OpType type){
        CreativeObject creativeObject = new CreativeObject(
                creativeTable.getAdId(),
                creativeTable.getName(),
                creativeTable.getType(),
                creativeTable.getMaterialType(),
                creativeTable.getHeight(),
                creativeTable.getWidth(),
                creativeTable.getAuditStatus(),
                creativeTable.getAdUrl()
        );
        handlerBinlogEvent(DataTable.of(CreativeIndex.class),
                creativeObject.getAdId(),
                creativeObject,
                type
                );
    }

    public static void handleLevel3(AdCreativeUnitTable adCreativeUnitTable, OpType type){
        if(type == OpType.UPDATE){
            log.error("CreativeUnitTable not support update ");
            return;
        }



    }

    public static void handleLevel3(AdUnitTable unitTable,OpType type){
        AdPlanObject adPlanObject = DataTable.of(AdPlanIndex.class)
                .get(unitTable.getPlanId());
        if(null == adPlanObject){
            log.error("handlelevel not found AdPlanObject error: {}",unitTable.getPlanId());
            return;
        }

        AdUnitObject unitObject = new AdUnitObject(
          unitTable.getUnitId(),
          unitTable.getUnitStaus(),
          unitTable.getPositionType(),
          unitTable.getPlanId(),
          adPlanObject
        );
        handlerBinlogEvent(DataTable.of(AdUnitIndex.class),
                unitTable.getUnitId(),
                unitObject,
                type);
    }




    private static <K,V> void handlerBinlogEvent(
            IndexAware<K,V> index,
            K key,
            V value,
            OpType type
    ){
        switch (type){
            case ADD:
                index.add(key,value);
                break;
            case UPDATE:
                index.update(key,value);
                break;
            case DELETE:
                index.delete(key,value);
                break;
            default:
                break;
        }
    }

}
