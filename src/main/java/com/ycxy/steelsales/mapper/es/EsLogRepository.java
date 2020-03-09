package com.ycxy.steelsales.mapper.es;

import com.ycxy.steelsales.pojo.es.EsLog;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * ES 搜索仓库
 */
@Repository
public interface EsLogRepository extends ElasticsearchRepository<EsLog,Integer> {


}
