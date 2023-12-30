package com.davis.auth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    private final CorsConfigurationProps corsConfigurationProps;

    public SecurityConfiguration(CorsConfigurationProps corsConfigurationProps) {
        this.corsConfigurationProps = corsConfigurationProps;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .cors(cors -> {
                    CorsConfiguration config = new CorsConfiguration();
                    config.setAllowedOrigins(corsConfigurationProps.getAllowedOrigins());
                    config.setAllowedMethods(corsConfigurationProps.getAllowedMethods());
                    config.setAllowedHeaders(corsConfigurationProps.getAllowedHeaders());
                    config.setExposedHeaders(corsConfigurationProps.getExposedHeaders());
                    config.setAllowCredentials(corsConfigurationProps.isAllowCredentials());
                    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
                    source.registerCorsConfiguration("/**", config);
                    cors.configurationSource(source);
                })
                .authorizeHttpRequests(authorizeHttpRequests -> {
                    authorizeHttpRequests.anyRequest()
                            .authenticated();
                })
                .sessionManagement(manager -> manager.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .oauth2ResourceServer(serverConfigurer -> serverConfigurer.jwt(Customizer.withDefaults()));

        return http.build();
    };
}
