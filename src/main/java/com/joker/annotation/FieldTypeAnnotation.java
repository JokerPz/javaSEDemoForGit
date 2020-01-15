package com.joker.annotation;

import java.lang.annotation.*;

@Documented
@Inherited
@Target({ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface FieldTypeAnnotation {
    String type() default "ignore";
    int age() default 27;
    String[] hobby();
}
