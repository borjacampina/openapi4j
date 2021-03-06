package org.openapi4j.parser.validation.v3;

import org.openapi4j.core.validation.ValidationResults;
import org.openapi4j.core.validation.ValidationSeverity;
import org.openapi4j.parser.model.v3.ExternalDocs;
import org.openapi4j.parser.model.v3.OpenApi3;
import org.openapi4j.parser.validation.Validator;

import static org.openapi4j.parser.validation.v3.OAI3Keywords.EXTENSIONS;
import static org.openapi4j.parser.validation.v3.OAI3Keywords.EXTERNALDOCS;

class ExternalDocsValidator extends Validator3Base<OpenApi3, ExternalDocs> {
  private static final Validator<OpenApi3, ExternalDocs> INSTANCE = new ExternalDocsValidator();

  private ExternalDocsValidator() {
  }

  public static Validator<OpenApi3, ExternalDocs> instance() {
    return INSTANCE;
  }

  @Override
  public void validate(OpenApi3 api, ExternalDocs externalDocs, ValidationResults results) {
    // VALIDATION EXCLUSIONS :
    // description
    validateMap(api, externalDocs.getExtensions(), results, false, EXTENSIONS, Regexes.EXT_REGEX, null);
    validateUrl(externalDocs.getUrl(), results, true, false, EXTERNALDOCS, ValidationSeverity.ERROR);
  }
}
