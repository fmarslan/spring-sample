/**
 * 
 * Copyright 2019 FMARSLAN
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */

package com.fmarslan.sample.application.api.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fmarslan.sample.common.account.dto.RolDto;
import com.fmarslan.sample.service.account.RolService;
import com.fmarslan.spring.application.AbstractApi;

@Repository("/api/user")
public class RolApi extends AbstractApi<Long, RolDto> {

	@Autowired
	RolService service;

	@Override
	protected RolService getService() {
		return service;
	}

}
