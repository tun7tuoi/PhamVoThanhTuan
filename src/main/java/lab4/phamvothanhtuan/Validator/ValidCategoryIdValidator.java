package lab4.phamvothanhtuan.Validator;

import lab4.phamvothanhtuan.Validator.annotation.ValidUserId;
import lab4.phamvothanhtuan.entity.Category;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidCategoryIdValidator implements ConstraintValidator<ValidUserId, Category> {
    @Override
    public  boolean isValid(Category category, ConstraintValidatorContext context) {
        return category != null && category.getId() != null;
    }

}