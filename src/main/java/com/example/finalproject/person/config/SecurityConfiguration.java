package com.example.finalproject.person.config;

import com.example.finalproject.person.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * Изучи методы внедрения зависимостей и как их реализовывать (в поле, через конструктор или через сеттер).
 * Вроде внедряешь в поле (объявил в поле переменную сервиса и поставил над ней аннотацию @Autowired),
 * но потом поставил над классом ломбоковские аннотации для создания конструкторов. Получается что эти аннотации здесь
 * не играют никакой роли. Предпочтительно реализовывать внедрение зависимостей через конструктор
 */
@AllArgsConstructor
//@NoArgsConstructor
@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    //Внедрение зависимостей - основа spring - без нее тут никуда
    private final UserService userService;

    @Bean
    public static BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable)
                //Вообще лучше (даже обязательно, потому что таков порядок фильтрации) начинать с перечисления тех эндпойнтов которые ЗАКРЫТЫ (т.е доступны только авторизованым пользователя или пользователям с определенной ролью)
                .authorizeHttpRequests((authorize) ->
                        authorize
                                .requestMatchers("/employees/**").hasAnyRole("USER")
                                .requestMatchers("/login/**").permitAll()
                                .requestMatchers("/registration**").permitAll()
                                .anyRequest().authenticated()

                ).formLogin(
                        form -> form
                                .loginPage("/login")
                ).logout(
                        logout -> logout
                                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                                .permitAll()
                );
        return http.build();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userService)
                .passwordEncoder(passwordEncoder());
    }
}
