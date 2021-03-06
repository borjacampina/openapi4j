package org.openapi4j.parser.validation.v3;

import org.junit.Test;
import org.openapi4j.core.validation.ValidationException;
import org.openapi4j.parser.Checker;

public class ContactTest extends Checker {
  @Test
  public void contact() throws Exception {
    validate("/validation/v3/contact/valid/contact.yaml");
  }

  //////////////////////////////////////////////////////////////
  // INVALID
  //////////////////////////////////////////////////////////////
  @Test(expected = ValidationException.class)
  public void serverInvalid() throws Exception {
    validate("/validation/v3/contact/invalid/contact.yaml");
  }
}
