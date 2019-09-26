package com.hy.tt.https;

import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @auther thy
 * @date 2019/9/26
 */
@Configuration
public class TomcatConfig {

    @Bean
    TomcatServletWebServerFactory tomcatServletWebServerFactory(){
        TomcatServletWebServerFactory tomcatServletWebServerFactory = new TomcatServletWebServerFactory() {

            @Override
            protected void postProcessContext(Context context) {
                SecurityConstraint constraint = new SecurityConstraint();
                constraint.setUserConstraint("CONFIDENTIAL");
                SecurityCollection collection = new SecurityCollection();
                collection.addPattern("/*");
                constraint.addCollection(collection);
                context.addConstraint(constraint);
            }
        };
        tomcatServletWebServerFactory.addAdditionalTomcatConnectors(createTomcatConnector());
        return tomcatServletWebServerFactory;
    }

    private Connector createTomcatConnector() {
        Connector connector = new
                Connector("org.apache.coyote.http11.Http11NioProtocol");
        connector.setScheme("http");
        connector.setPort(8081);
        connector.setSecure(false);
        connector.setRedirectPort(8080);
        return connector;
    }
}
