package tn.cni.services.impl;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;

import tn.cni.domain.UserEntity;
import tn.cni.services.UserAuthenticationProviderService;

/**
 * provides processing service to set user authentication session
 * @author hasna
 *
 */
public class UserAuthenticationProviderServiceImpl implements UserAuthenticationProviderService{

	
	private AuthenticationManager authenticationManager;
	
	public boolean processUserAuthentication(UserEntity user) {
		try{
			Authentication request = new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword());
			Authentication result = authenticationManager.authenticate(request);
			SecurityContextHolder.getContext().setAuthentication(result);
			return true;
		}catch(AuthenticationException e){
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), "Soryy !"));
			
			return false;
		}
		
	}

	public AuthenticationManager getAuthenticationManager() {
		return authenticationManager;
	}

	public void setAuthenticationManager(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}
	
	

}
