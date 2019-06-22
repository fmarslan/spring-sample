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

package com.fmarslan.sample.persistence.account.repository;

import com.fmarslan.sample.persistence.account.entity.AuthTagEntity;
import com.fmarslan.spring.base.persistence.AbstractRepository;

public class AuthTagRepository extends AbstractRepository<Long, AuthTagEntity> {

	public AuthTagRepository() {
		super(AuthTagEntity.class);
	}

}