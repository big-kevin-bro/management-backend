package com.bkb.management.backend.business.demo.service.impl;

import com.bkb.management.backend.business.demo.service.DemoService;
import com.bkb.management.backend.domain.dto.TestDTO;
import com.bkb.management.backend.domain.vo.TestVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author big kevin bro
 */
@Service
@Slf4j
public class DemoServiceImpl implements DemoService {

    /**
     * @param vo 入参
     * @return 结果
     */
    @Override
    public TestDTO test(TestVO vo) {
        log.info("{}牛逼", "大凯哥");
        TestDTO dto = new TestDTO();
        dto.setResult(vo.getText() + " 大凯哥");
        return dto;
    }
}
