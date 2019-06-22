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

package com.fmarslan.sample.service.account;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fmarslan.sample.common.account.dto.UserDto;
import com.fmarslan.sample.persistence.account.entity.UserEntity;
import com.fmarslan.sample.service.account.helper.UserMapper;
import com.fmarslan.sample.service.account.logic.UserLogic;
import com.fmarslan.spring.base.common.request.ListRequest;
import com.fmarslan.spring.base.common.response.ListModel;
import com.fmarslan.spring.base.service.AbstractService;
import com.fmarslan.spring.base.service.security.Auth;

@Service
public class UserService extends AbstractService<Long, UserDto, UserEntity> {

	@Autowired
	UserLogic logic;

	@Autowired
	UserMapper mapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.fmarslan.spring.base.service.AbstractService#getLogic()
	 */
	@Override
	protected UserLogic getLogic() {
		return logic;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.fmarslan.spring.base.service.AbstractService#getMapper()
	 */
	@Override
	protected UserMapper getMapper() {
		return mapper;
	}


	
	/* (non-Javadoc)
	 * @see com.fmarslan.spring.base.service.AbstractService#findByID(java.io.Serializable)
	 */
	@Override
	@Auth("USER_GET")
	public UserDto findByID(Long id) {
		return super.findByID(id);
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.fmarslan.spring.base.service.AbstractService#create(com.fmarslan.spring.
	 * base.common.dto.BaseDto)
	 */
	@Override
	@Auth("USER_CREATE")
	public UserDto create(UserDto dto) {
		return super.create(dto);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.fmarslan.spring.base.service.AbstractService#create(java.util.List)
	 */
	@Override
	@Auth("USER_CREATE")
	public List<UserDto> create(List<UserDto> dtoList) {
		return super.create(dtoList);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.fmarslan.spring.base.service.AbstractService#update(com.fmarslan.spring.
	 * base.common.dto.BaseDto)
	 */
	@Override
	@Auth("USER_UPDATE")
	public UserDto update(UserDto dto) {
		return super.update(dto);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.fmarslan.spring.base.service.AbstractService#update(java.util.List)
	 */
	@Override
	@Auth("USER_UPDATE")
	public List<UserDto> update(List<UserDto> dtoList) {
		return super.update(dtoList);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.fmarslan.spring.base.service.AbstractService#getAll()
	 */
	@Override
	@Auth("USER_LIST")
	public List<UserDto> getAll() {
		return super.getAll();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.fmarslan.spring.base.service.AbstractService#getPage(com.fmarslan.spring.
	 * base.common.request.ListRequest)
	 */
	@Override
	@Auth("USER_LIST")
	public ListModel<UserDto> getPage(ListRequest request) {
		return super.getPage(request);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.fmarslan.spring.base.service.AbstractService#delete(com.fmarslan.spring.
	 * base.common.dto.BaseDto)
	 */
	@Override
	@Auth("USER_DELETE")
	public void delete(UserDto dto) {
		super.delete(dto);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.fmarslan.spring.base.service.AbstractService#delete(com.fmarslan.spring.
	 * base.common.dto.BaseDto, boolean)
	 */
	@Override
	@Auth("USER_HARDDELETE")
	public void delete(UserDto dto, boolean hardDelete) {
		super.delete(dto, hardDelete);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.fmarslan.spring.base.service.AbstractService#delete(java.util.List)
	 */
	@Override
	@Auth("USER_DELETE")
	public void delete(List<UserDto> dtoList) {
		super.delete(dtoList);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.fmarslan.spring.base.service.AbstractService#delete(java.util.List,
	 * boolean)
	 */
	@Override
	@Auth("USER_HARDDELETE")
	public void delete(List<UserDto> dtoList, boolean hardDelete) {
		super.delete(dtoList, hardDelete);
	}
	
}
