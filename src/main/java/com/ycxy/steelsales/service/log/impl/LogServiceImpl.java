package com.ycxy.steelsales.service.log.impl;

import com.ycxy.steelsales.mapper.es.EsLogRepository;
import com.ycxy.steelsales.mapper.log.SteelsaleLogMapper;
import com.ycxy.steelsales.pojo.es.EsLog;
import com.ycxy.steelsales.pojo.log.SteelsaleLog;
import com.ycxy.steelsales.pojo.log.SteelsaleLogExample;
import com.ycxy.steelsales.pojo.log.SteelsaleLogWithBLOBs;
import com.ycxy.steelsales.service.log.LogService;
import com.ycxy.steelsales.service.login.LoginService;
import com.ycxy.steelsales.util.ResultMessage;
import com.ycxy.steelsales.util.SteelSaleResult;
import jdk.nashorn.internal.ir.CallNode;
import org.elasticsearch.index.query.DisMaxQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogServiceImpl implements LogService {
    @Autowired
    private SteelsaleLogMapper logMapper;

    @Autowired
    private EsLogRepository esLogRepository;

    @Override
    public Boolean addLog(SteelsaleLogWithBLOBs steelsaleLog) {
        //添加到数据库 并且添加到es 搜索库中
        int i = logMapper.insert(steelsaleLog);
        if (i > 0) {
            Long id= steelsaleLog.getId();
            //System.out.println(id);
            SteelsaleLogWithBLOBs log1 = logMapper.selectByPrimaryKey(id);
            EsLog goods = new EsLog(log1.getId(),log1.getLogTime(),log1.getLogLoginName(),log1.getLogRemoteAddr(),log1.getLogUri(),log1.getLogParam(),log1.getLogDesc());
             esLogRepository.save(goods);
//            System.out.println("goods>>>>>>"+save);
            return true;
        } else {
            return false;
        }

    }

    //查询日志 "id","logTime","logLoginName","logRemoteAddr","logUri","logParam","logDesc"
    @Override
    public ResultMessage showLog(String keyword) {
        SteelsaleLogExample logExample = new SteelsaleLogExample();
        logExample.createCriteria();

        if (keyword != null && keyword != "") {
            DisMaxQueryBuilder disMaxQueryBuilder = QueryBuilders.disMaxQuery();
            //判断是否是日期 不是日期执行
            if (keyword.indexOf("-") == -1) {
                QueryBuilder queryBuilder1 = QueryBuilders.matchQuery("logDesc", keyword).boost(2f);
                QueryBuilder queryBuilder2 = QueryBuilders.matchQuery("logDesc.pinyin", keyword).boost(1.5f);
                QueryBuilder queryBuilder3 = QueryBuilders.matchQuery("logRemoteAddr", keyword).boost(1f);
                QueryBuilder queryBuilder5 = QueryBuilders.matchQuery("logLoginName", keyword).boost(2.5f);
                QueryBuilder queryBuilder6 = QueryBuilders.matchQuery("logLogUri", keyword).boost(2.5f);
                disMaxQueryBuilder.add(queryBuilder1);
                disMaxQueryBuilder.add(queryBuilder2);
                disMaxQueryBuilder.add(queryBuilder3);
                disMaxQueryBuilder.add(queryBuilder5);
                disMaxQueryBuilder.add(queryBuilder6);
            } else {
                QueryBuilder queryBuilder4 = QueryBuilders.matchQuery("logTime", keyword).boost(2f);
                disMaxQueryBuilder.add(queryBuilder4);
            }
            NativeSearchQuery searchQuery = new NativeSearchQuery(disMaxQueryBuilder);
            Page<EsLog> search = esLogRepository.search(searchQuery);
            System.out.println("============================================"+search.getTotalPages());
            return new ResultMessage(0, "查询成功", search.getNumber(), search.getContent());
        } else {
            List<SteelsaleLogWithBLOBs> log = logMapper.selectByExampleWithBLOBs(logExample);
            System.out.println("直接查询");
            return new ResultMessage(200, "查询成功", log.size(), log);
        }

    }


}
