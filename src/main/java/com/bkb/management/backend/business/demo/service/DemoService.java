package com.bkb.management.backend.business.demo.service;

import com.bkb.management.backend.domain.dto.TestDTO;
import com.bkb.management.backend.domain.vo.TestVO;

/**
 * @author big kevin bro
 */
public interface DemoService {
    TestDTO test(TestVO vo);
}
