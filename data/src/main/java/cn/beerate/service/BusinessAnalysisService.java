package cn.beerate.service;

import cn.beerate.dao.Impl.BusinessAnalysisDaoImpl;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * 经营分析
 */
@Component
public class BusinessAnalysisService {

    @Autowired
    private BusinessAnalysisDaoImpl analysisDao;

    private Log log = LogFactory.getLog(BusinessAnalysisService.class);


}
