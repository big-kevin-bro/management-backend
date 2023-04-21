package com.bkb.management.backend.business.login.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bkb.management.backend.business.login.service.LoginUserInfoService;
import com.bkb.management.backend.business.rsa.service.UserRsaInfoService;
import com.bkb.management.backend.config.props.AppProps;
import com.bkb.management.backend.config.utils.RsaUtils;
import com.bkb.management.backend.domain.base.BaseResponse;
import com.bkb.management.backend.domain.dto.login.LoginUserInfoDTO;
import com.bkb.management.backend.domain.mapper.login.LoginUserInfoMapper;
import com.bkb.management.backend.domain.model.login.LoginUserInfoDO;
import com.bkb.management.backend.domain.model.rsa.UserRsaInfoDO;
import com.bkb.management.backend.domain.vo.login.LoginUserVO;
import io.micrometer.common.util.StringUtils;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * @author big kevin bro
 */
@Service
public class LoginUserInfoServiceImpl extends ServiceImpl<LoginUserInfoMapper, LoginUserInfoDO> implements LoginUserInfoService {

    @Resource
    private HttpServletRequest request;

    @Resource
    private AppProps appProps;

    @Resource
    private UserRsaInfoService userRsaInfoService;

    /**
     * @param userName 用户名
     * @return 登录用户信息
     */
    @Override
    public LoginUserInfoDO getByUserName(String userName) {
        LambdaQueryWrapper<LoginUserInfoDO> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(LoginUserInfoDO::getUserName, userName);
        return getOne(wrapper);
    }

    /**
     * @param vo 入参
     * @return 是否注册成功
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public BaseResponse<Boolean, ?> signUp(LoginUserVO vo) {
        LambdaQueryWrapper<LoginUserInfoDO> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(LoginUserInfoDO::getUserName, vo.getUserName());
        LoginUserInfoDO loginUserInfo = this.getOne(wrapper);
        if (loginUserInfo != null) {
            return BaseResponse.fail("500", "用户名已存在");
        }
        loginUserInfo = new LoginUserInfoDO();
        loginUserInfo.setUserName(vo.getUserName());
        this.save(loginUserInfo);
        String password = this.passwordHandle(vo.getPassword(), loginUserInfo.getId());
        if (StringUtils.isBlank(password)) {
            return BaseResponse.fail("500", "创建账号失败");
        }
        loginUserInfo.setPassword(password);
        return BaseResponse.success(this.updateById(loginUserInfo));
    }

    /**
     * @return 登录用户信息
     */
    @Override
    public LoginUserInfoDTO getUserInfoByToken() {
        String userId = (String) request.getAttribute("id");
        if (StringUtils.isBlank(userId)) {
            return null;
        }
        LoginUserInfoDO userInfo = this.getById(userId);
        LoginUserInfoDTO dto = new LoginUserInfoDTO();
        BeanUtil.copyProperties(userInfo, dto);
        return dto;
    }

    private String passwordHandle(String password, String userId) {
        // 用公有的私钥解密
        String plaintext = RsaUtils.decrypt(password, appProps.getRsa().getPrivateKey());
        // 生成私有的秘钥
        Map<String, String> stringStringMap = RsaUtils.generateKeyPair();
        if (stringStringMap != null) {
            String rsaPublicKey = stringStringMap.get("RSAPublicKey");
            String rsaPrivateKey = stringStringMap.get("RSAPrivateKey");
            UserRsaInfoDO userRsaInfo = new UserRsaInfoDO();
            userRsaInfo.setUserId(userId);
            userRsaInfo.setPublicKey(rsaPublicKey);
            userRsaInfo.setPrivateKey(rsaPrivateKey);
            userRsaInfoService.save(userRsaInfo);
            return RsaUtils.encrypt(plaintext, rsaPublicKey);
        }
        return null;
    }

    @Override
    public BaseResponse<String, ?> test(String password) {
        return BaseResponse.success(RsaUtils.encrypt(password, appProps.getRsa().getPublicKey()));
    }
}
