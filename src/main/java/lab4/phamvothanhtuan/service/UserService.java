package lab4.phamvothanhtuan.service;

import lab4.phamvothanhtuan.entity.User;
import lab4.phamvothanhtuan.repository.IuserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private IuserRepository userRepository;
    public void save (User user){
        userRepository.save(user);
    }
}
