package br.com.mariah.contabilidade.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import java.util.Arrays;


@Configuration
public class HttpSecurityConfiguration {

    public static final String DEVELOPMENT_PROFILE_NAME = "dev";
    private final Environment environment;

    public HttpSecurityConfiguration(Environment environment) {
        this.environment = environment;
    }

    @Bean
    public SecurityFilterChain filterChainDev(HttpSecurity http) throws Exception {
        if (Arrays.asList(environment.getActiveProfiles()).contains(DEVELOPMENT_PROFILE_NAME)) {
            return http
                    .csrf(csrf -> csrf.disable())
                    .authorizeHttpRequests(auth ->
                            auth.anyRequest().permitAll())
                    .httpBasic(Customizer.withDefaults())
                    .build();
        } else return http.build();
    }


}

