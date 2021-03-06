package org.openapi4j.schema.validator.v3;

import com.fasterxml.jackson.databind.JsonNode;

import org.openapi4j.core.model.v3.OAI3;
import org.openapi4j.core.validation.ValidationResults;
import org.openapi4j.schema.validator.BaseJsonValidator;
import org.openapi4j.schema.validator.ValidationContext;

import static org.openapi4j.core.model.v3.OAI3SchemaKeywords.MAXPROPERTIES;

/**
 * maxProperties keyword validator.
 * <p/>
 * <a href="https://github.com/OAI/OpenAPI-Specification/blob/master/versions/3.0.2.md#schemaObject" />
 * <p/>
 * <a href="https://tools.ietf.org/html/draft-wright-json-schema-validation-00#page-9" />
 */
class MaxPropertiesValidator extends BaseJsonValidator<OAI3> {
  private static final String ERR_MSG = "Maximum is '%s', found '%s'.";

  private final Integer max;

  static MaxPropertiesValidator create(ValidationContext<OAI3> context, JsonNode schemaNode, JsonNode schemaParentNode, SchemaValidator parentSchema) {
    return new MaxPropertiesValidator(context, schemaNode, schemaParentNode, parentSchema);
  }

  private MaxPropertiesValidator(final ValidationContext<OAI3> context, final JsonNode schemaNode, final JsonNode schemaParentNode, final SchemaValidator parentSchema) {
    super(context, schemaNode, schemaParentNode, parentSchema);

    max
      = schemaNode.isIntegralNumber()
      ? schemaNode.intValue()
      : null;
  }

  @Override
  public void validate(final JsonNode valueNode, final ValidationResults results) {
    if (max == null || !valueNode.isObject()) {
      return;
    }

    if (valueNode.size() > max) {
      results.addError(String.format(ERR_MSG, max, valueNode.size()), MAXPROPERTIES);
    }
  }
}
