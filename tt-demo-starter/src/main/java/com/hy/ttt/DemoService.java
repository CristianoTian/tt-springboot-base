package com.hy.ttt;

/**
 * @auther thy
 * @date 2019/12/12
 */
public class DemoService {

    private DemoProperties demoProperties;

    public DemoService(DemoProperties demoProperties) {
        this.demoProperties = demoProperties;
    }

    public String getObject(){
        return "配置的ID = " + demoProperties.getId() + "|||" + "配置的name = " + demoProperties.getName();
    }
}
