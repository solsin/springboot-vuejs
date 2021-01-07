package sampleshop.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Configuration;

@ConditionalOnProperty(prefix = "nodejs", name = "proxy", havingValue = "enabled")
@Configuration
@EnableZuulProxy
public class ProxyConfig {

}
