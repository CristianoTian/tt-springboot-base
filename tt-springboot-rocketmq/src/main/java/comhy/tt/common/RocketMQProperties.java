package comhy.tt.common;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @auther thy
 * @date 2019/11/18
 */
@Getter
@Setter
@ToString
@Accessors(chain = true)
@Configuration
@ConfigurationProperties(prefix = "tt.rocketmq")
@PropertySource("classpath:config/rocketmq.properties")
public class RocketMQProperties {
}
