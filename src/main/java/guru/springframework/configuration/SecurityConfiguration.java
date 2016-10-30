package guru.springframework.configuration;

import guru.springframework.domain.User;
import guru.springframework.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserRepository userRepository;

    public UserRepository getUserRepository() {
        return userRepository;
    }

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {


        httpSecurity
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/user/save").anonymous()
                .antMatchers("/user/register").permitAll()
                .antMatchers("/resources/**").permitAll()
                .antMatchers("/css/**").permitAll()
                .antMatchers("/webjars/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/user/login")
                .defaultSuccessUrl("/usercabinet").permitAll()
                .and()
                .logout().permitAll();

        httpSecurity.exceptionHandling().accessDeniedPage("/403");

        httpSecurity.csrf().disable();
        httpSecurity.authorizeRequests();

    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                User user = userRepository.getUserByLogin(username);
                if (user == null) {
                    throw new UsernameNotFoundException("user with login " + username + " was not found");
                }
                return new org.springframework.security.core.userdetails.User(
                        username, user.getPassword(), true, true, true, true, Arrays.asList(new SimpleGrantedAuthority("USER")));
            }
        });
        // auth.inMemoryAuthentication().withUser("user").password("user").roles("USER");
    }

}

