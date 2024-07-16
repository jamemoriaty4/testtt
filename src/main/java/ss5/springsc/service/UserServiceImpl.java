package ss5.springsc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import ss5.springsc.model.entity.User;
import ss5.springsc.repository.UserRepository;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{


    @Autowired
    private UserRepository userRepository;
    @Override
    public void register(User user) {
        String passwordHash = BCrypt.hashpw(user.getPassword(),BCrypt.gensalt(12));
        user.setPassword(passwordHash);
        userRepository.save(user);
    }
//    @Override
//    public User login(User user) {
//        User userFromDB = userRepository.findUserByUserName(user.getUserName());
//        if(userFromDB!=null){
//            if(BCrypt.checkpw(user.getPassword(),userFromDB.getPassword())){
//                return userFromDB;
//            }
//        }
//        return null;
//    }
}
