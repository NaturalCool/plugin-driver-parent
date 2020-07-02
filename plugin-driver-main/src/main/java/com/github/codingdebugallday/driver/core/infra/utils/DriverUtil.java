package com.github.codingdebugallday.driver.core.infra.utils;

import com.github.codingdebugallday.driver.common.exception.DriverException;
import com.github.codingdebugallday.driver.common.utils.JsonUtil;
import com.github.codingdebugallday.driver.core.domain.entity.CommonDatasourceSettingInfo;
import com.github.codingdebugallday.driver.core.domain.entity.Datasource;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.util.StringUtils;

/**
 * <p>
 * description
 * </p>
 *
 * @author isaac 2020/7/1 20:52
 * @since 1.0
 */
public class DriverUtil {

    private DriverUtil() {
        throw new IllegalStateException("util class");
    }

    public static HikariDataSource entityToHikariDataSource(Datasource entity) {
        String settingsInfo = entity.getSettingsInfo();
        if (StringUtils.isEmpty(settingsInfo)) {
            throw new DriverException("the datasource settingsInfo cannot be empty");
        }
        CommonDatasourceSettingInfo commonDatasourceSettingInfo =
                JsonUtil.toObj(settingsInfo, CommonDatasourceSettingInfo.class);
        return new HikariDataSource(genHikariConfig(commonDatasourceSettingInfo));
    }

    public static HikariConfig genHikariConfig(CommonDatasourceSettingInfo commonDatasourceSettingInfo) {
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl(commonDatasourceSettingInfo.getJdbcUrl());
        hikariConfig.setUsername(commonDatasourceSettingInfo.getUsername());
        hikariConfig.setPassword(commonDatasourceSettingInfo.getPassword());
        hikariConfig.setCatalog(commonDatasourceSettingInfo.getDefaultDatabase());
        return hikariConfig;
    }
}