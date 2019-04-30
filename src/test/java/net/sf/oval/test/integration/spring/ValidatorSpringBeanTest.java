/*********************************************************************
 * Copyright 2005-2019 by Sebastian Thomschke and others.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *********************************************************************/
package net.sf.oval.test.integration.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import junit.framework.TestCase;
import net.sf.oval.Validator;
import net.sf.oval.test.validator.XMLConfigurationTest;

/**
 * @author Sebastian Thomschke
 */
public class ValidatorSpringBeanTest extends TestCase {

   public void testValidatorSpringBean() {
      final ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("ValidatorSpringBeanTest.xml", ValidatorSpringBeanTest.class);
      try {
         final Validator validator = ctx.getBean("validator", Validator.class);
         new XMLConfigurationTest().validateUser(validator);
      } finally {
         ctx.close();
      }
   }

}
