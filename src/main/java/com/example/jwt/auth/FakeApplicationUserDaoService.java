
package com.example.jwt.auth;

import com.example.jwt.UserModel;
import com.example.jwt.UserService;
import com.example.jwt.jwt.UsernameAndPasswordAuthenticationRequest;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import static com.example.jwt.security.ApplicationUserRole.*;

@Repository("fake")
public class FakeApplicationUserDaoService implements ApplicationUserDao {

    private final PasswordEncoder passwordEncoder;

    
    @Autowired
    private UserService userService;

    @Autowired
    public FakeApplicationUserDaoService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Optional<ApplicationUser> selectApplicationUserByUsername(String username) {
    	
    	
    	Set<SimpleGrantedAuthority> sets= null;
    	List<UserModel> list= userService.findUserByEmail(username);
    	if(list.get(0).getUserrole().equals("ADMIN")) {
    		sets  =  ADMIN.getGrantedAuthorities();
    	}else if(list.get(0).getUserrole().equals("DOCTOR")) {
    		sets  =  DOCTOR.getGrantedAuthorities();
    	}
    	else {
    		sets  =  USER.getGrantedAuthorities();
    	}
//    	return 
    	List<ApplicationUser> user= Lists.newArrayList(
    			new ApplicationUser(list.get(0).getEmail(), 
    					passwordEncoder.encode(list.get(0).getPassword()),
    					sets,
    					true,
    					true,
    					true,
    					true)
    			);
        return user
                .stream()
                .filter(applicationUser -> username.equals(applicationUser.getUsername()))
                .findFirst();
    }
//
//    private List<ApplicationUser> getApplicationUsers() {
//    	
//    	
//        List<ApplicationUser> applicationUsers = Lists.newArrayList(
//                new ApplicationUser(
//                        "annasmith",
//                        passwordEncoder.encode("password"),
//                        STUDENT.getGrantedAuthorities(),
//                        true,
//                        true,
//                        true,
//                        true
//                ),
//                new ApplicationUser(
//                        "linda",
//                        passwordEncoder.encode("password"),
//                        ADMIN.getGrantedAuthorities(),
//                        true,
//                        true,
//                        true,
//                        true
//                ),
//                new ApplicationUser(
//                        "tom",
//                        passwordEncoder.encode("password"),
//                        ADMINTRAINEE.getGrantedAuthorities(),
//                        true,
//                        true,
//                        true,
//                        true
//                )
//        );
//
//        return applicationUsers;
//    }

}
