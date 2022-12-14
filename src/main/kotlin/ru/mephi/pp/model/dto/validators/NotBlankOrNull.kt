package ru.mephi.pp.model.dto.validators

import javax.validation.Constraint
import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext
import javax.validation.Payload
import kotlin.reflect.KClass

@Target(AnnotationTarget.FIELD)
@Constraint(validatedBy = [NotBlankOrNullValidator::class])
annotation class NotBlankOrNull(
    val message: String = "{ru.mephi.pp.dto.validation.NotBlankOrNull.message}",
    val groups: Array<KClass<*>> = [],
    val payload: Array<KClass<out Payload>> = []
)

class NotBlankOrNullValidator : ConstraintValidator<NotBlankOrNull, String> {
    override fun isValid(value: String?, context: ConstraintValidatorContext?): Boolean {
        return when (value == null) {
            true -> true
            false -> value.isNotBlank()
        }
    }
}
