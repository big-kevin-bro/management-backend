package com.bkb.management.backend.business.rsa.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bkb.management.backend.business.rsa.service.UserRsaInfoService;
import com.bkb.management.backend.domain.mapper.rsa.UserRsaInfoMapper;
import com.bkb.management.backend.domain.model.rsa.UserRsaInfoDO;
import org.springframework.stereotype.Service;

/**
 * @author big kevin bro
 */
@Service
public class UserRsaInfoServiceImpl extends ServiceImpl<UserRsaInfoMapper, UserRsaInfoDO> implements UserRsaInfoService {
}
