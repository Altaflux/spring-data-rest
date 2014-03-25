/*
 * Copyright 2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.data.rest.webmvc.alps;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.AbstractControllerIntegrationTests;
import org.springframework.data.rest.webmvc.jpa.JpaRepositoryConfig;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * @author Oliver Gierke
 */
@WebAppConfiguration
@ContextConfiguration(classes = JpaRepositoryConfig.class)
public class AlpsControllerIntegrationTests extends AbstractControllerIntegrationTests {

	@Autowired WebApplicationContext context;

	protected MockMvc mvc;

	@Before
	public void setUp() {

		mvc = MockMvcBuilders.webAppContextSetup(context).build();
	}

	@Test
	public void foo() throws Exception {

		mvc.perform(get("/")).andDo(print());

		mvc.perform(get("/alps")).andDo(print());

		mvc.perform(get("/alps/orders")).andDo(print());
		mvc.perform(get("/alps/people")).andDo(print());
	}
}