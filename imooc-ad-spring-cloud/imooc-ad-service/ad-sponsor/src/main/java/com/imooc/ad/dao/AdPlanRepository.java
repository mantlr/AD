package com.imooc.ad.dao;

import com.imooc.ad.entity.AdPlan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Swallow
 */
public interface AdPlanRepository extends JpaRepository<AdPlan,Long> {

    /**
     * 根据id和用户id查询广告
     * @param id
     * @param userId
     * @return
     */
    AdPlan findByIdAndUserId(Long id,Long userId);

    /**
     * 根据id列表和用户列表
     * @param ids
     * @param userId
     * @return
     */
    List<AdPlan> findAllByIdInAndUserId(List<Long>ids,Long userId);

    /**
     * 根据
     * @param userId
     * @param planName
     * @return
     */
    AdPlan findByUserIdAndPlanName(Long userId,String planName);

    /**
     * 根据状态查询多个广告
     * @param status
     * @return
     */
    List<AdPlan> findAllByPlanStatus(Integer status);
}
