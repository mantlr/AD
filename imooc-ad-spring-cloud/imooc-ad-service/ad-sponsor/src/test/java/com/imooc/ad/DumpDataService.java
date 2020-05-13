package com.imooc.ad;

import com.alibaba.fastjson.JSON;
import com.imooc.ad.constant.CommonStatus;
import com.imooc.ad.dao.AdPlanRepository;
import com.imooc.ad.dao.AdUnitRepository;
import com.imooc.ad.dao.CreativeRepository;
import com.imooc.ad.dao.unit_condition.AdUnitDistrictRepository;
import com.imooc.ad.dao.unit_condition.AdUnitItRepository;
import com.imooc.ad.dao.unit_condition.AdUnitKeywordRepository;
import com.imooc.ad.dao.unit_condition.CreativeUnitRepository;
import com.imooc.ad.dump.AdCreativeTable;
import com.imooc.ad.dump.AdCreativeUnitTable;
import com.imooc.ad.dump.AdPlanTable;
import com.imooc.ad.dump.AdUnitTable;
import com.imooc.ad.entity.AdPlan;
import com.imooc.ad.entity.AdUnit;
import com.imooc.ad.entity.Creative;
import com.imooc.ad.entity.unit_condition.AdUnitKeyword;
import com.imooc.ad.entity.unit_condition.CreativeUnit;
import lombok.extern.slf4j.Slf4j;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.CollectionUtils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * @auther BoHanMa
 * @date 2020/5/13 10:46
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class},
        webEnvironment = SpringBootTest.WebEnvironment.NONE)
@Slf4j
public class DumpDataService {

    @Autowired
    private AdPlanRepository adPlanRepository;
    @Autowired
    private AdUnitRepository adUnitRepository;
    @Autowired
    private CreativeRepository creativeRepository;
    @Autowired
    private CreativeUnitRepository creativeUnitRepository;
    @Autowired
    private AdUnitDistrictRepository adUnitDistrictRepository;
    @Autowired
    private AdUnitItRepository adUnitItRepository;
    @Autowired
    private AdUnitKeywordRepository adUnitKeywordRepository;

    private void dumpAdPlanTable(String fileName){
        List<AdPlan> adPlans =adPlanRepository.findAllByPlanStatus(
                CommonStatus.VALID.getStatus()
        );
        if(CollectionUtils.isEmpty(adPlans)){
            return;
        }

        List<AdPlanTable> planTables = new ArrayList<>();
        adPlans.forEach(p -> planTables.add(
                new AdPlanTable(
                        p.getId(),
                        p.getUserId(),
                        p.getPlanStatus(),
                        p.getStartDate(),
                        p.getEndDate()
                )
        ) );

        Path path = Paths.get(fileName);
        try(BufferedWriter writer = Files.newBufferedWriter(path)){
            for (AdPlan palnTable:adPlans){
                writer.write(JSON.toJSONString(palnTable));
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            log.error("dumpAdPlanTable error");
        }
    }


    private void dumpAdUnitTable(String fileName){

        List<AdUnit> adUnits = adUnitRepository.findAllByUnitStatus(
                CommonStatus.VALID.getStatus()
        );
        if(CollectionUtils.isEmpty(adUnits)){
            return;
        }

        List<AdUnitTable> unitTables = new ArrayList<>();

        adUnits.forEach(u -> unitTables.add(
                new AdUnitTable(
                        u.getId(),
                        u.getUnitStatus(),
                        u.getPositionType(),
                        u.getPlanId()
                )
        ) );

        Path path = Paths.get(fileName);
        try(BufferedWriter writer =
                    Files.newBufferedWriter(path)){
            for (AdUnitTable unitTable : unitTables){
                writer.write(JSON.toJSONString(unitTable));
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            log.error("dumpAdUnitTable error");
        }
    }

    private void dumpAdCreativeTable(String fileName){

        List<Creative> creatives = creativeRepository.findAll();
        if(CollectionUtils.isEmpty(creatives)){
            return;
        }

        List<AdCreativeTable> creativeTables = new ArrayList<>();
        creatives.forEach(c -> creativeTables.add(
                new AdCreativeTable(

                        c.getId(),
                        c.getName(),
                        c.getType(),
                        c.getMaterialType(),
                        c.getHeight(),
                        c.getWidth(),
                        c.getAuditStatus(),
                        c.getUrl()

                )
        ));

        Path path = Paths.get(fileName);
        try(BufferedWriter writer =
                    Files.newBufferedWriter(path)){

            for (AdCreativeTable creativeTable: creativeTables){
                writer.write(JSON.toJSONString(creativeTable));
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            log.error("dumpAdCreativeTable error");
        }
    }

    private void dumpAdCreativeUnitTable(String fileName){
        List<CreativeUnit> creativeUnits = creativeUnitRepository.findAll();
        if(CollectionUtils.isEmpty(creativeUnits)){
            return;
        }

        List<AdCreativeUnitTable> creativeUnitTables = new ArrayList<>();
        creativeUnitTables.forEach(c -> creativeUnitTables.add(
                new AdCreativeUnitTable(
                        c.getCreativeId(),
                        c.getUnitId()
                )
        ));

        Path path = Paths.get(fileName);
        try(BufferedWriter writer = Files.newBufferedWriter(path)){

            for (AdCreativeUnitTable creativeUnitTable: creativeUnitTables){
                writer.write(JSON.toJSONString(creativeUnitTable));
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            log.error("dumpAdCreativeUnitTable error");
        }

    }



}
