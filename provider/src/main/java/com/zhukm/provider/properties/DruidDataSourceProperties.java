package com.zhukm.provider.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Properties;

/**
 * Created by king on 2017/3/27.
 */
@Data
@ConfigurationProperties("spring.datasource.druid")
public class DruidDataSourceProperties {
    private int maxActive = 20;
    private int initialSize = 5;
    private int minIdle = 5;
    private Long maxWait = 60000L;
    private Long timeBetweenEvictionRunsMillis = 60000L;
    private Long minEvictableIdleTimeMillis = 60000L;
    private String validationQuery = "SELECT 'x' FROM DUAL";
    private Boolean testWhileIdle = false;
    private Boolean testOnBorrow = false;
    private Boolean testOnReturn = false;
    private String filters;

    private String allow;
    private String deny;
    private String loginUsername;
    private String loginPassword;
    private Boolean resetEnable;

    public Properties toProperties(){
        Properties properties = new Properties();
        notNullAdd(properties, "timeBetweenEvictionRunsMillis", this.timeBetweenEvictionRunsMillis);
        notNullAdd(properties, "minEvictableIdleTimeMillis", this.minEvictableIdleTimeMillis);
        notNullAdd(properties, "validationQuery", this.validationQuery);
        notNullAdd(properties, "testWhileIdle", this.testWhileIdle);
        notNullAdd(properties, "testOnBorrow", this.testOnBorrow);
        notNullAdd(properties, "testOnReturn", this.testOnReturn);
        notNullAdd(properties, "filters", this.filters);
        return properties;
    }

    private void notNullAdd(Properties properties, String key, Object value) {
        if(value != null) {
            properties.put("druid." + key, value.toString());
        }
    }
}
