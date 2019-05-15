package com.hy.tt;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @auther thy
 * @date 2019/5/15
 */
@Component
//@PropertySource("classpath:config/my.prop") 2211可以指定读取配置文件
@ConfigurationProperties(prefix = "tt")
public class StarterHelloProperties {

    private String name = "defaultName";

    private String hobby = "defaultHobby";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }
}
