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

import com.fmarslan.sample.common.account.dto.RolDto;
import com.fmarslan.sample.persistence.account.entity.RolEntity;
import com.fmarslan.spring.base.service.AbstractMapper;

public class RolMapper extends AbstractMapper<Long, RolEntity, RolDto> {

	private final int serializeLevel;

	public RolMapper(int serializeLevel) {
		this.serializeLevel = serializeLevel;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.fmarslan.spring.base.service.AbstractMapper#toDto(com.fmarslan.spring.
	 * base.persistence.BaseEntity)
	 */
	@Override
	protected RolDto toDto(RolEntity entity) {
		RolDto dto = new RolDto();
		dto.setLevel(entity.getLevel());
		dto.setRolName(entity.getRolName());
		if (serializeLevel > 0) {
			AuthTagMapper authTagMapper = new AuthTagMapper();
			dto.setAuths(authTagMapper.convertToDtoList(entity.getAuths()));
		}
		return dto;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.fmarslan.spring.base.service.AbstractMapper#toEntity(com.fmarslan.spring.
	 * base.common.dto.BaseDto)
	 */
	@Override
	protected RolEntity toEntity(RolDto dto) {
		RolEntity entity = new RolEntity();
		entity.setLevel(dto.getLevel());
		entity.setRolName(dto.getRolName());
		AuthTagMapper authTagMapper = new AuthTagMapper();
		entity.setAuths(authTagMapper.convertToEntityList(dto.getAuths()));
		return entity;
	}

}
