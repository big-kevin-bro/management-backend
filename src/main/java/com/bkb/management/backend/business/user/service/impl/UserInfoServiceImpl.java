package com.bkb.management.backend.business.user.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bkb.management.backend.business.user.service.UserInfoService;
import com.bkb.management.backend.domain.dto.user.UserInfoDTO;
import com.bkb.management.backend.domain.mapper.user.UserInfoMapper;
import com.bkb.management.backend.domain.model.user.UserInfoDO;
import com.bkb.management.backend.domain.vo.user.UserInfoVO;
import io.micrometer.common.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author big kevin bro
 */
@Service
@Slf4j
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfoDO> implements UserInfoService {

    /**
     * 添加用户
     *
     * @param vo 入参
     * @return 是否添加成功
     */
    @Override
    public Boolean add(UserInfoVO vo) {
        UserInfoDO userInfo = new UserInfoDO();
        BeanUtil.copyProperties(vo, userInfo);
        return this.save(userInfo);
    }

    /**
     * 更新用户信息
     *
     * @param vo 入参
     * @return 是否更新成功
     */
    @Override
    public Boolean updateUser(UserInfoVO vo) {
        UserInfoDO userInfo = this.getById(vo.getId());
        userInfo.setName(vo.getName());
        userInfo.setRemarks(vo.getRemarks());
        return this.updateById(userInfo);
    }

    /**
     * 获取用户信息
     *
     * @param vo 入参
     * @return 用户信息
     */
    @Override
    public List<UserInfoDTO> getUserInfo(UserInfoVO vo) {
        log.info("获取用户信息: {}", JSONUtil.toJsonStr(vo));
        LambdaQueryWrapper<UserInfoDO> wrapper = new LambdaQueryWrapper<>();
        if (StringUtils.isNotBlank(vo.getId())) {
            wrapper.eq(UserInfoDO::getId, vo.getId());
        }
        if (StringUtils.isNotBlank(vo.getName())) {
            wrapper.like(UserInfoDO::getName, vo.getName());
        }
        if (StringUtils.isNotBlank(vo.getRemarks())) {
            wrapper.like(UserInfoDO::getRemarks, vo.getRemarks());
        }
        List<UserInfoDO> list = this.list(wrapper);
        List<UserInfoDTO> result = new ArrayList<>();
        for (UserInfoDO userInfo : list) {
            UserInfoDTO dto = new UserInfoDTO();
            BeanUtil.copyProperties(userInfo, dto);
            result.add(dto);
        }
        return result;
    }
}
