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

import java.sql.Timestamp;

import com.fmarslan.sample.common.account.dto.UserDto;
import com.fmarslan.sample.persistence.account.entity.UserEntity;
import com.fmarslan.spring.base.service.AbstractMapper;

public class UserMapper extends AbstractMapper<Long, UserEntity, UserDto> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.fmarslan.spring.base.service.AbstractMapper#toDto(com.fmarslan.spring.
	 * base.persistence.BaseEntity)
	 */
	@Override
	protected UserDto toDto(UserEntity entity) {
		UserDto dto = new UserDto();
		dto.setLevel(entity.getLevel());
		dto.setEmail(entity.getEmail());
		dto.setFirstName(entity.getFirstName());
		if (entity.getLastLogin() != null)
			dto.setLastLogin(entity.getLastLogin().getTime());
		dto.setLastName(entity.getLastName());
		dto.setLoginTry(entity.getLoginTry());
		dto.setState(entity.getState());
		dto.setUsername(entity.getUsername());
		RolMapper rolMapper = new RolMapper(0);
		dto.setRols(rolMapper.convertToDtoList(entity.getRols()));
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
	protected UserEntity toEntity(UserDto dto) {
		UserEntity entity = new UserEntity();
		entity.setLevel(dto.getLevel());
		entity.setEmail(dto.getEmail());
		entity.setFirstName(dto.getFirstName());
		if (dto.getLastLogin() != null)
			entity.setLastLogin(new Timestamp(dto.getLastLogin()));
		entity.setLastName(dto.getLastName());
		entity.setLoginTry(dto.getLoginTry());
		entity.setState(dto.getState());
		entity.setUsername(dto.getUsername());
		RolMapper rolMapper = new RolMapper(0);
		entity.setRols(rolMapper.convertToEntityList(dto.getRols()));
		return entity;
	}

}
