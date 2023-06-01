package lab4.phamvothanhtuan.service;

import lab4.phamvothanhtuan.repository.IuserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import lab4.phamvothanhtuan.entity.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import lab4.phamvothanhtuan.entity.CustomUserDetail;
import org.springframework.stereotype.Service;



@Service

public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    private IuserRepository   userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        User user   = userRepository.findByUsername(username);
        if (user == null)
            throw new UsernameNotFoundException("User not found");
        return new CustomUserDetail(user, userRepository);
    }

}
