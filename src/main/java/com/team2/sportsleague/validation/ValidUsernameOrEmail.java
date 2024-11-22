package com.team2.sportsleague.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = UsernameOrEmailValidator.class)
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidUsernameOrEmail {
    String message() default "Enter a valid email or a username.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

