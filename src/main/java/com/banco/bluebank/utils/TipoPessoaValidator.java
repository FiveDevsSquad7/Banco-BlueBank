package com.banco.bluebank.utils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.InputMismatchException;
import java.util.Locale;

public class TipoPessoaValidator implements ConstraintValidator<TipoPessoa, String> {

  @Override
  public void initialize(TipoPessoa constraintAnnotation) {}

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    return value != null && (value.toUpperCase().equals("F") || value.toUpperCase().equals("J"));
  }
}