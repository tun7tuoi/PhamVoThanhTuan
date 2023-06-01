package lab4.phamvothanhtuan.Validator;

import lab4.phamvothanhtuan.entity.User;
import lab4.phamvothanhtuan.Validator.annotation.ValidUserId;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidUserIdValidator implements ConstraintValidator<ValidUserId,User> {

    @Override
    public boolean isValid(User user, ConstraintValidatorContext context){
        if ( user == null)
            return true;
        return user.getId() !=null;
    }
}
