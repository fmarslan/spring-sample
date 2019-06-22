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

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fmarslan.sample.common.AppConstant;
import com.fmarslan.spring.base.common.dto.BaseDto;

public class AuthTagDto extends BaseDto<Long> {

	private static final long serialVersionUID = -2472522393871615423L;

	private Long id;
	private AuthTagDto parent;

	@Pattern(regexp = AppConstant.AUTH_TAG, message = "may contain only [a-Z], [0-9], [_], [.]")
	@Size(max = 32, min = 4, message = "must be between 4-32 chars")
	private String tag;

	private Integer level = 0;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public AuthTagDto getParent() {
		return parent;
	}

	public void setParent(AuthTagDto parent) {
		this.parent = parent;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
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
