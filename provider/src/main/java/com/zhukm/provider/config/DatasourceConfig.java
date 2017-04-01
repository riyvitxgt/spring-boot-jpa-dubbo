package com.zhukm.provider.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import com.zhukm.provider.properties.DruidDataSourceProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by king on 2017/3/26.
 */
@Configuration
@ConditionalOnClass({DruidDataSource.class})
@ConditionalOnProperty(
        name = {"spring.datasource.type"},
        havingValue = "com.alibaba.druid.pool.DruidDataSource",
        matchIfMissing = true
)
@EnableConfigurationProperties(DruidDataSourceProperties.class)
public class DatasourceConfig {
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DruidDataSource dataSource(DataSourceProperties dataSourceProperties, DruidDataSourceProperties druidDataSourceProperties){
        DruidDataSource druidDataSource = (DruidDataSource)dataSourceProperties.initializeDataSourceBuilder().type(DruidDataSource.class).build();
        druidDataSource.configFromPropety(druidDataSourceProperties.toProperties());
        druidDataSource.setMaxActive(druidDataSourceProperties.getMaxActive());
        druidDataSource.setInitialSize(druidDataSourceProperties.getInitialSize());
        druidDataSource.setMaxWait(druidDataSourceProperties.getMaxWait());
        druidDataSource.setMinIdle(druidDataSourceProperties.getMinIdle());
        return druidDataSource;
    }

    @Bean
    public ServletRegistrationBean druidServlet(DruidDataSourceProperties druidDataSourceProperties) {
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        //白名单(不设置则默认所有IP都可访问)
        servletRegistrationBean.addInitParameter("allow", druidDataSourceProperties.getAllow());
        //IP黑名单(IP即在白名单又在黑名单时,优先黑名单)
        servletRegistrationBean.addInitParameter("deny", druidDataSourceProperties.getDeny());
        //登录用户名和密码
        servletRegistrationBean.addInitParameter("loginUsername", druidDataSourceProperties.getLoginUsername());
        servletRegistrationBean.addInitParameter("loginPassword", druidDataSourceProperties.getLoginPassword());
        //是否能够重置数据
        servletRegistrationBean.addInitParameter("resetEnable", druidDataSourceProperties.getResetEnable().toString());
        return servletRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new WebStatFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        return filterRegistrationBean;
    }
}
