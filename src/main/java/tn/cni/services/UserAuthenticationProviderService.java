package tn.cni.services;

import tn.cni.domain.UserEntity;

/**
 * provides processing service to set user authentication session
 * @author hasna
 *
 */
public interface UserAuthenticationProviderService {

	boolean processUserAuthentication(UserEntity user);
}
