package com.me.only.config.redis;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;


/**
 * @description redis配置
 * @author peiqi
 */
@Component
@Configuration
@ConfigurationProperties(prefix = "spring.redis")
public class RedisProperties {
    private String host;
    private String port;
    private int database;

    public String getHost() {
        return host;
    }
    public void setHost(String host) {
        this.host = host;
    }
    public String getPort() {
        return port;
    }
    public void setPort(String port) {
        this.port = port;
    }

    public int getDatabase() {
        return database;
    }
    public void setDatabase(int database) {
        this.database = database;
    }
}
