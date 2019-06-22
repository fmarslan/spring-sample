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

import java.util.List;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fmarslan.sample.common.AppConstant;
import com.fmarslan.sample.common.account.enums.EnumUserState;
import com.fmarslan.spring.base.common.dto.BaseDto;

public class UserDto extends BaseDto<Long> {

	private static final long serialVersionUID = 3258665597650672351L;

	private Long id;

	@Pattern(regexp = AppConstant.LOGIN_REGEX, message = "may contain only  [a-Z], [0-9], [-], [.]")
	@Size(max = 32, min = 4, message = "must be between 4-32 chars")
	private String username;

	@Size(max = 32, min = 6, message = "must be between 6-32 chars")
	private String password;

	private Integer loginTry = 0;

	@Size(max = 32, min = 2, message = "must be between 2-32 chars")
	private String firstName;

	@Size(max = 32, min = 2, message = "must be between 2-32 chars")
	private String lastName;

	private String email;

	private Long lastLogin;

	private EnumUserState state = EnumUserState.ACTIVE;

	private Integer level = 0;

	private List<RolDto> rols;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getLoginTry() {
		return loginTry;
	}

	public void setLoginTry(Integer loginTry) {
		this.loginTry = loginTry;
	}

	public Long getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Long lastLogin) {
		this.lastLogin = lastLogin;
	}

	public EnumUserState getState() {
		return state;
	}

	public void setState(EnumUserState state) {
		this.state = state;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public List<RolDto> getRols() {
		return rols;
	}

	public void setRols(List<RolDto> rols) {
		this.rols = rols;
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
