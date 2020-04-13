package com.binay.microservices.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

import com.binay.microservices.data.service.CustomUserDetailService;


@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {
	
	private static final String RESOURCE_ID = "TimesheetAndLeaveService";

	TokenStore tokenStore = new InMemoryTokenStore();
	
	@Autowired
	@Qualifier("authenticationManagerBean")
	AuthenticationManager authenticationManager;

	@Autowired
	CustomUserDetailService userDetailsService;
	
	@Bean
	@Primary
	public DefaultTokenServices tokenServices() {
		DefaultTokenServices tokenServices = new DefaultTokenServices();
		tokenServices.setTokenStore(this.tokenStore);
		return tokenServices;
	}
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		
		endpoints.tokenStore(tokenStore).authenticationManager(authenticationManager)
		.userDetailsService(userDetailsService);
	}
	
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
		//security.checkTokenAccess("permitAll()"); //if used permitAll() this will make oauth/check_token endpoint to be unsecure
	      security.tokenKeyAccess("permitAll()")
	      .allowFormAuthenticationForClients()
	      .checkTokenAccess("isAuthenticated()");
	      //.checkTokenAccess("hasAuthority('ROLE_APP')"); //secure the oauth/check_token endpoint
	   }
	
	
	
	
	 @Override
	   public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
	      clients
	            .inMemory()
	            .withClient(RESOURCE_ID)//client username: a
	            .secret(passwordEncoder.encode("9999"))//password: a
	            .resourceIds(RESOURCE_ID)
	            .scopes("all")
	            .authorizedGrantTypes("password", "refresh_token");
	   }

}
