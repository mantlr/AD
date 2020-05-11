package com.imooc.ad.dao;

import com.imooc.ad.entity.AdUnit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Swallow
 */
public interface AdUnitRepository extends JpaRepository<AdUnit,Long> {

    /**
     * 根据id和name 确定推广单元
     * @param planId
     * @param unitName
     * @return
     */
    AdUnit findByPlanIdAndUnitName(Long planId, String unitName);

    List<AdUnit> findAllByUnitStatus(Integer uintStatus);




}
