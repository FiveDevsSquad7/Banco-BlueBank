package com.banco.bluebank.utils;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = TipoPessoaValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface TipoPessoa {
	
    String message() default "O tipo de pessoa deve ser 'F' para física ou 'J' para jurídica";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}