package com.hy.ttt;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @auther thy
 * @date 2019/12/12
 */
@Data
@ConfigurationProperties(prefix = "tt.demo")
public class DemoProperties {

    private String id;

    private String name;

}
