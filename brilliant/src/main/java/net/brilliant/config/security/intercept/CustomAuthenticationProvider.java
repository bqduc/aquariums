package net.brilliant.config.security.intercept;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import net.brilliant.framework.component.CompCore;

/**
 * Created by aLeXcBa1990 on 24/11/2018.
 * 
 */
@Named
@Component
public class CustomAuthenticationProvider extends CompCore implements AuthenticationProvider {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8355652678792800184L;

	@Inject
	private MVPCustomAuthenticationProvider mvpCustomAuthenticationProvider;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		return mvpCustomAuthenticationProvider.authenticate(authentication);
	}

	@Override
	public boolean supports(Class<? extends Object> authentication) {
		return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
	}
}
