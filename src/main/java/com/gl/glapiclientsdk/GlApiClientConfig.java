package com.gl.glapiclientsdk;

import com.gl.glapiclientsdk.client.GlApiClient;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("glapi.client")
@Data
@ComponentScan
public class GlApiClientConfig {

    private String accessKey;

    private String secretKey;

    @Bean
    public GlApiClient yuApiClient() {
        return new GlApiClient(accessKey, secretKey);
    }
}
