package com.team2.sportsleague.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UsernameOrEmailValidator implements ConstraintValidator<ValidUsernameOrEmail, String> {
    private static final String EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@(creditsafe\\.(com|be|co\\.uk|co\\.in|co\\.jp|dk|fi|fr|hu|ie|it|lu|nl|no|se)|creditsafede\\.com|creditsafemail\\.com|creditsafenl\\.com|creditsafeuk\\.com|creditsafeusa\\.com|graydoncreditsafe\\.(be|com|lu|nl)|safeinformationgroup\\.com)$";
    private static final String USERNAME_REGEX = "^[0-9]{6,10}$";

    @Override
    public boolean isValid(String input, ConstraintValidatorContext context) {
        return input != null && (input.matches(EMAIL_REGEX) || input.matches(USERNAME_REGEX));
    }
}

