package ru.mephi.pp.utils.validators

import jakarta.validation.Constraint
import jakarta.validation.ConstraintValidator
import jakarta.validation.ConstraintValidatorContext
import jakarta.validation.Payload
import kotlin.reflect.KClass

@Target(AnnotationTarget.FIELD)
@Constraint(validatedBy = [NotBlankOrNullValidator::class])
annotation class NotBlankOrNull(
    val message: String = "must not be blank or must be null",
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
