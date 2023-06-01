package lab4.phamvothanhtuan.Validator;

import lab4.phamvothanhtuan.repository.IuserRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lab4.phamvothanhtuan.Validator.annotation.ValidUsername;
import org.springframework.beans.factory.annotation.Autowired;

import java.awt.*;

public class ValidUsernameValidator implements ConstraintValidator<ValidUsername, String> {
    @Autowired
    private IuserRepository userRepository;
    @Override
    public boolean isValid(String username, ConstraintValidatorContext context){
        if (userRepository == null)
            return  true;
        return userRepository.findByUsername(username) == null;
    }
}
