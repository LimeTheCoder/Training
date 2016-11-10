package com.training.reflection;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Custom annotation for training purpose to annotate some methods
 * and check java reflection in action
 *
 * @version 09 Nov 2016
 * @author Taras Sakharchuk
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CustomAnnotation {}
