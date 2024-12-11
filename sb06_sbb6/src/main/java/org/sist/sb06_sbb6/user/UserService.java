package org.sist.sb06_sbb6.user;

import java.security.Principal;
import java.util.Optional;

import org.sist.sb06_sbb6.exception.DataNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {

   private final UserRepository userRepository;
   
   private final PasswordEncoder passwordEncoder;
   
   public SiteUser create(String username, String email, String password) {
      SiteUser user = new SiteUser(); // 엔터티 객체 생성
      user.setUsername(username);
      user.setEmail(email);
      
      // BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
      user.setPassword(passwordEncoder.encode(password));
         
      return this.userRepository.save(user);
      // return user;
   }

   public SiteUser getUser(String username) {
      Optional<SiteUser> siteUser = this.userRepository.findByUsername(username);
      if (siteUser.isPresent()) {
         return siteUser.get(); // SiteUser
      } else {
         throw new DataNotFoundException("siteUser not found");
      }
      
   }

public SiteUser getUser(Principal principal, SiteUser siteUser) {
	// TODO Auto-generated method stub
	return null;
}
   
} // class
