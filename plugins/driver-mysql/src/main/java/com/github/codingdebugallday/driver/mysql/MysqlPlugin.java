package com.github.codingdebugallday.driver.mysql;

import com.github.codingdebugallday.realize.BasePlugin;
import lombok.extern.slf4j.Slf4j;
import org.pf4j.PluginWrapper;

/**
 * <p>
 * MysqlPlugin
 * </p>
 *
 * @author isaac 2020/6/30 13:39
 * @since 1.0
 */
@Slf4j
public class MysqlPlugin extends BasePlugin {

    public MysqlPlugin(PluginWrapper wrapper) {
        super(wrapper);
    }

    @Override
    protected void startEvent() {
        log.info("mysql plugin start...");
    }

    @Override
    protected void deleteEvent() {
        log.info("mysql plugin delete...");
    }

    @Override
    protected void stopEvent() {
        log.info("mysql plugin stop...");
    }
}
