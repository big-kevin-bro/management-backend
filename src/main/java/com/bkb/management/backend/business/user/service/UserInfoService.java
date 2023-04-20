package com.bkb.management.backend.business.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bkb.management.backend.domain.dto.user.UserInfoDTO;
import com.bkb.management.backend.domain.model.user.UserInfoDO;
import com.bkb.management.backend.domain.vo.user.UserInfoVO;

import java.util.List;

/**
 * @author big kevin bro
 */
public interface UserInfoService extends IService<UserInfoDO> {
    Boolean add(UserInfoVO vo);

    Boolean updateUser(UserInfoVO vo);

    List<UserInfoDTO> getUserInfo(UserInfoVO vo);
}
