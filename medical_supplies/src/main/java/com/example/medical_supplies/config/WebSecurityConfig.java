package com.example.medical_supplies.config;
import com.example.medical_supplies.security.jwt.JwtAuthenticationFilter;
import com.example.medical_supplies.service.impl.MyUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * This class configures web security for the application.
 *
 * @author: NamND
 * @date: 10/101/2024
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    @Autowired
    private MyUserDetailService myUserDetailService;

    /**
     * Creates an authentication manager.
     *
     * @param authConfig The authentication configuration.
     * @return The authentication manager.
     * @throws Exception If an error occurs while creating the authentication manager.
     * @author: NamND
     * @date: 10/01/2024
     */
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }

    /**
     * Creates a password encoder using BCrypt.
     *
     * @return The BCrypt password encoder.
     * @author: NamND
     * @date: 10/01/2024
     * @return The BCrypt password encoder.
     */
    @Bean
    public PasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder();
    }

    /**
     * Creates a JWT authentication filter bean.
     *
     * @return The JWT authentication filter.
     * @author: NamND
     * @date: 10/01/2024
     */
    @Bean
    public JwtAuthenticationFilter authenticationJwtTokenFilter() {
        return new JwtAuthenticationFilter();
    }

    /**
     * Creates an authentication provider for DAO.
     *
     * @return The DAO authentication provider.
     * @author: NamND
     * @date: 10/01/2024
     * @return The DAO authentication provider.
     */
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(myUserDetailService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    /**
     * Configures security filters for HTTP requests.
     *
     * @param http The HTTP security configuration.
     * @return The built security filter chain.
     * @throws Exception If an error occurs while configuring the security filters.
     * @author: NamND
     * @date: 10/01/2024
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .cors(Customizer.withDefaults())
                .authorizeHttpRequests((requests) -> requests
//                        Trang không cần đăng nhập
                                .requestMatchers("/api/news/**","/api/category").permitAll()
                                .requestMatchers("/api/login").permitAll()
                                .requestMatchers("/api/employee/**","/api/products/**","/api/productions/**","/api/type_products/**").permitAll()
                                .requestMatchers("/api/product/size", "/api/product/promotion", "/api/product/category").permitAll()
                                .requestMatchers("/api/invoices/**", "/api/invoice-details/**").permitAll()
                                .requestMatchers("/api/home/**").permitAll()
                                .requestMatchers("/api/recoverPassword").permitAll()
                                .requestMatchers("/api/sendMail", "/api/customerType","/api/resetPassword/**").permitAll()
//                        Trang cần có quyền hợp lệ

                                .requestMatchers("/api/notification/view", "/api/customer/**", "/api/customerType","/api/overview/**").hasAnyRole("ADMIN", "ACCOUNTANT", "SALESMAN")
//                                .requestMatchers("/api/notification/add/**","/api/sales-report/**").hasRole("MANAGER")
//                                .requestMatchers("/api/sale/**", "/api/sales/**").hasRole("SALE")
//                                .requestMatchers("/api/product/create").hasRole("WAREHOUSE")
//                                .requestMatchers("/api/warehouses/**").hasRole("WAREHOUSE")
//                                .requestMatchers("/api/size-detail/**").hasRole("WAREHOUSE")
//                                .requestMatchers("/api/sales-report/**").hasRole("MANAGER")
//                                .requestMatchers("/api/invoices/**", "/api/sales/**").hasRole("SALE")
//                                .requestMatchers("/api/employee/**", "/api/product/list").authenticated()
//                                .requestMatchers("/api/product/**").authenticated()
//                                .requestMatchers("/api/employee/**").authenticated()
//                                .requestMatchers("/api/changePassword").authenticated()
//                                .requestMatchers("/api/customer/**").authenticated()
//                                .anyRequest().authenticated()
                )
                .csrf(AbstractHttpConfigurer::disable)
                .addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class)
                .formLogin((form) -> form.disable())
                .logout((logout) -> logout.permitAll());


        return http.build();
    }
}
