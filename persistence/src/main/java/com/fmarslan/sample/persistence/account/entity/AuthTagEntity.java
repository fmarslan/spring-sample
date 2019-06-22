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

package com.fmarslan.sample.persistence.account.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fmarslan.sample.common.AppConstant;
import com.fmarslan.spring.base.persistence.BaseEntity;

@Entity
@Table(name = "tbl_auth_tag", uniqueConstraints = { 
		@UniqueConstraint(columnNames = { "auth_tag"}, name = "UQXX_AUTH_TAGXXAUTH_TAG" ) 
	})
public class AuthTagEntity extends BaseEntity<Long> {

	private static final long serialVersionUID = -1835339029925733450L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "seq_authtag")
	@SequenceGenerator(name = "seq_authtag")
	private Long id;

	@ManyToOne(cascade = CascadeType.DETACH, optional = true, fetch = FetchType.LAZY)
	@JoinColumn(name = "parent_id", foreignKey = @ForeignKey(name = "FK_XX_AUTH_TAGXX_AUTH_TAG"))
	private AuthTagEntity parent;

	@Pattern(regexp = AppConstant.AUTH_TAG, message = "may contain only [a-Z], [0-9], [_], [.]")
	@Size(max = 32, min = 4, message = "must be between 4-32 chars")
	@Column(name = "auth_tag", unique = true, nullable = false, length = 32)
	private String tag;

	@Column(name = "security_level", nullable = false)
	private Integer level = 0;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public AuthTagEntity getParent() {
		return parent;
	}

	public void setParent(AuthTagEntity parent) {
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.fmarslan.spring.base.persistence.BaseEntity#setPrimaryKey(java.io.
	 * Serializable)
	 */
	@Override
	public void setPrimaryKey(Long id) {
		this.id = id;
	}

}
