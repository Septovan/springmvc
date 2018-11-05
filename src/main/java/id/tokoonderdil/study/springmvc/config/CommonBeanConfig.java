package id.tokoonderdil.study.springmvc.config;

import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommonBeanConfig {

    @Bean
    public StrongPasswordEncryptor strongPasswordEncryptor() {
        StrongPasswordEncryptor strongPasswordEncryptor = new StrongPasswordEncryptor();
        return strongPasswordEncryptor;
    }
}
