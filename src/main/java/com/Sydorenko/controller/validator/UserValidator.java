package com.Sydorenko.controller.validator;


import com.Sydorenko.controller.Form.UserForm;
import com.Sydorenko.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
/** The implementation of basic Spring validation interface.
 * This class defines validation rules for user registration
 * form passed to controller from view.
 */
@Component
public class UserValidator implements Validator {
    @Autowired
    private UserService userService;
    /** The method for checking if the UserForm is
     * supported Java class
     */
    @Override
    public boolean supports ( Class<?> aClass ) {
        return UserForm.class.equals(aClass);
    }

    /** This method describes validation rules for each
     * validated UserForm field.
     * @param o - object to be validated
     * @param errors contains validation errors if
     * they exist
     */
    @Override
    public void validate ( Object o, Errors errors ) {
        UserForm user= (UserForm) o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty");
        if (user.getEmail().length() < 6 || user.getEmail().length() > 32) {
            errors.rejectValue("email", "Size.userForm.username");
        }
        if (userService.findByEmail(user.getEmail()) != null) {
            errors.rejectValue("email", "Duplicate.userForm.username");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
        if (user.getPassword().length() < 4 || user.getPassword().length() > 32) {
            errors.rejectValue("password", "Size.userForm.password");
        }

        if (!user.getConfirmPassword().equals(user.getPassword())) {
            errors.rejectValue("confirmPassword", "Diff.userForm.passwordConfirm");
        }
    }
}


