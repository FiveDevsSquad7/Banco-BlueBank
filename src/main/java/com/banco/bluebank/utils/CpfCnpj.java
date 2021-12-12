package com.banco.bluebank.utils;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CpfCnpjValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface CpfCnpj {
	
    String message() default "Documento Inválido";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}