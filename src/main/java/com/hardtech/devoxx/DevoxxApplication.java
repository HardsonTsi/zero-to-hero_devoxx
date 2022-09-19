package com.hardtech.devoxx;

import com.hardtech.devoxx.domain.Speaker;
import com.hardtech.devoxx.domain.SpeakerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class DevoxxApplication implements CommandLineRunner {

    @Autowired
    private SpeakerRepository speakerRepository;

    public static void main(String[] args) {
        SpringApplication.run(DevoxxApplication.class, args);
    }

    void addSpeaker() {
        Speaker dave = speakerRepository.save(new Speaker("David", "Syer", "dave_syer"));
        Speaker nicoll = speakerRepository.save(new Speaker("Stéphane", "Nicoll", "stephane_nicoll"));
        Speaker clozel = speakerRepository.save(new Speaker("brian", "clozel", "brian_clozel"));
    }

    @Override
    public void run(String... args) throws Exception {
        addSpeaker();
    }


    @Configuration
    static class SecurityConfig extends GlobalAuthenticationConfigurerAdapter {

        @Bean
        public BCryptPasswordEncoder passwordEncoder() {
            return new BCryptPasswordEncoder();
        }

        @Override
        public void init(AuthenticationManagerBuilder auth) throws Exception {
            auth.inMemoryAuthentication()
                    .withUser("user").password(passwordEncoder().encode("user")).roles("USER")
                    .and()
                    .withUser("hero").password(passwordEncoder().encode("user")).roles("HERO");
        }
    }
}
