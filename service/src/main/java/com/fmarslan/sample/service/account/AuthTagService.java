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

import com.fmarslan.sample.common.account.dto.AuthTagDto;
import com.fmarslan.sample.persistence.account.entity.AuthTagEntity;
import com.fmarslan.sample.service.account.helper.AuthTagMapper;
import com.fmarslan.sample.service.account.logic.AuthTagLogic;
import com.fmarslan.spring.base.common.request.ListRequest;
import com.fmarslan.spring.base.common.response.ListModel;
import com.fmarslan.spring.base.service.AbstractService;
import com.fmarslan.spring.base.service.security.Auth;

@Service
public class AuthTagService extends AbstractService<Long, AuthTagDto, AuthTagEntity> {

	@Autowired
	AuthTagLogic logic;

	@Autowired
	AuthTagMapper mapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.fmarslan.spring.base.service.AbstractService#getLogic()
	 */
	@Override
	protected AuthTagLogic getLogic() {
		return logic;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.fmarslan.spring.base.service.AbstractService#getMapper()
	 */
	@Override
	protected AuthTagMapper getMapper() {
		return mapper;
	}

	
	/* (non-Javadoc)
	 * @see com.fmarslan.spring.base.service.AbstractService#findByID(java.io.Serializable)
	 */
	@Override
	@Auth("AUTHTAG_GET")
	public AuthTagDto findByID(Long id) {
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
	@Auth("AUTHTAG_CREATE")
	public AuthTagDto create(AuthTagDto dto) {
		return super.create(dto);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.fmarslan.spring.base.service.AbstractService#create(java.util.List)
	 */
	@Override
	@Auth("AUTHTAG_CREATE")
	public List<AuthTagDto> create(List<AuthTagDto> dtoList) {
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
	@Auth("AUTHTAG_UPDATE")
	public AuthTagDto update(AuthTagDto dto) {
		return super.update(dto);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.fmarslan.spring.base.service.AbstractService#update(java.util.List)
	 */
	@Override
	@Auth("AUTHTAG_UPDATE")
	public List<AuthTagDto> update(List<AuthTagDto> dtoList) {
		return super.update(dtoList);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.fmarslan.spring.base.service.AbstractService#getAll()
	 */
	@Override
	@Auth("AUTHTAG_LIST")
	public List<AuthTagDto> getAll() {
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
	@Auth("AUTHTAG_LIST")
	public ListModel<AuthTagDto> getPage(ListRequest request) {
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
	@Auth("AUTHTAG_DELETE")
	public void delete(AuthTagDto dto) {
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
	@Auth("AUTHTAG_HARDDELETE")
	public void delete(AuthTagDto dto, boolean hardDelete) {
		super.delete(dto, hardDelete);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.fmarslan.spring.base.service.AbstractService#delete(java.util.List)
	 */
	@Override
	@Auth("AUTHTAG_DELETE")
	public void delete(List<AuthTagDto> dtoList) {
		super.delete(dtoList);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.fmarslan.spring.base.service.AbstractService#delete(java.util.List,
	 * boolean)
	 */
	@Override
	@Auth("AUTHTAG_HARDDELETE")
	public void delete(List<AuthTagDto> dtoList, boolean hardDelete) {
		super.delete(dtoList, hardDelete);
	}

}
