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

package com.fmarslan.sample.common.account.dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fmarslan.spring.base.common.dto.BaseDto;

public class RolDto extends BaseDto<Long> {

	private static final long serialVersionUID = 2886527734934147478L;

	private Long id;
	private List<AuthTagDto> auths;

	@Size(max = 32, min = 4, message = "must be between 4-32 chars")
	private String rolName;

	private Integer level = 0;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@JsonIgnore
	public RolDto addAuth(AuthTagDto auth) {
		getAuths().add(auth);
		return this;
	}

	public List<AuthTagDto> getAuths() {
		if (auths == null)
			auths = new ArrayList<AuthTagDto>();
		return auths;
	}

	public void setAuths(List<AuthTagDto> auths) {
		this.auths = auths;
	}

	public String getRolName() {
		return rolName;
	}

	public void setRolName(String rolName) {
		this.rolName = rolName;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.fmarslan.spring.base.common.shared.IHasPrimaryKey#getPrimaryKey()
	 */
	@Override
	public Long getPrimaryKey() {
		return id;
	}

}
