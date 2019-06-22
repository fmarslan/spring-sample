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

package com.fmarslan.sample.service.account.helper;

import com.fmarslan.sample.common.account.dto.AuthTagDto;
import com.fmarslan.sample.persistence.account.entity.AuthTagEntity;
import com.fmarslan.spring.base.service.AbstractMapper;

public class AuthTagMapper extends AbstractMapper<Long, AuthTagEntity, AuthTagDto> {

	/* (non-Javadoc)
	 * @see com.fmarslan.spring.base.service.AbstractMapper#toDto(com.fmarslan.spring.base.persistence.BaseEntity)
	 */
	@Override
	protected AuthTagDto toDto(AuthTagEntity entity) {
		AuthTagDto dto = new AuthTagDto();
		dto.setLevel(entity.getLevel());
		dto.setTag(entity.getTag());
		dto.setParent(convertToDto(entity));
		return dto;
	}

	/* (non-Javadoc)
	 * @see com.fmarslan.spring.base.service.AbstractMapper#toEntity(com.fmarslan.spring.base.common.dto.BaseDto)
	 */
	@Override
	protected AuthTagEntity toEntity(AuthTagDto dto) {
		AuthTagEntity entity = new AuthTagEntity();
		entity.setLevel(dto.getLevel());
		entity.setTag(dto.getTag());
		entity.setParent(convertToEntity(dto));
		return entity;
	}


}
