package fr.ebiz.cdb.model.dto;

import javax.validation.Constraint;
import javax.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by Bertrand Pestre on 22/03/17.
 */
@Target({TYPE, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = DatesValidator.class)
@Documented
public @interface ValidDates {

    String message() default "{fr.ebiz.cdb.model.dto.validdates}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String introduced();

    String discontinued();
}
