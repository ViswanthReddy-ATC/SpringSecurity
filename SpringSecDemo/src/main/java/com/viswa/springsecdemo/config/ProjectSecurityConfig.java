
package com.viswa.springsecdemo.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.password.CompromisedPasswordChecker;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.password.HaveIBeenPwnedRestApiPasswordChecker;

@Configuration
public class ProjectSecurityConfig {


 /*   @Bean
    UserDetailsService userDetailsService() {
        UserDetails userDetails = User.withUsername("user").password("{noop}viswa@123").authorities("read").build();
        UserDetails adminDetails = User.withUsername("admin")
                .password("{bcrypt}$2a$12$/bScyuD2rCdlsrBdCCgVx.O63mHEfnRPvj2YtMLfCpfJdEvFP48Vm").authorities("admin")
                .build();
        return new InMemoryUserDetailsManager(userDetails, adminDetails);
    }
	  */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

  /*  @Bean
    public CompromisedPasswordChecker compromisedPasswordChecker() {
        return new HaveIBeenPwnedRestApiPasswordChecker();
    }*/

    /*
     * @Bean UserDetailsService userDetailsService(DataSource dataSource) { return
     * new JdbcUserDetailsManager(dataSource);
     *
     * //}
     */
    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity httpSec) {

        httpSec.csrf(csrfSecConfig -> csrfSecConfig.disable())
                .authorizeHttpRequests((request) -> request
                .requestMatchers("/accountDetails", "/balanceDetails", "/cardDetails", "/loanDetails").authenticated()
                .requestMatchers("/contactDetails", "/noticeDetails", "/register").permitAll())
                .httpBasic(Customizer.withDefaults());
        httpSec.formLogin(flc -> flc.disable());
       // httpSec.httpBasic(hbc -> hbc.disable());
        return httpSec.build();
    }

}
