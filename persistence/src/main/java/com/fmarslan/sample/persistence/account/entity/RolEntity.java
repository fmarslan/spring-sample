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

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Size;

import org.hibernate.annotations.BatchSize;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fmarslan.spring.base.persistence.BaseEntity;

@Entity
@Table(name = "tbl_rol", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "rol_name" }, name = "UQXX_ROLXXROL_NAME") })
public class RolEntity extends BaseEntity<Long> {

	private static final long serialVersionUID = -1835339029925733450L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "seq_rol")
	@SequenceGenerator(name = "seq_rol")
	private Long id;

	@ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
	@JoinTable(name = "tbl_rol_auth_Tag", joinColumns = {
			@JoinColumn(name = "rol_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_XX_ROLXX_AUTH_TAG")) }, inverseJoinColumns = {
					@JoinColumn(name = "auth_tag_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_XX_AUTH_TAGXX_ROL")) })
	@BatchSize(size = 20)
	private List<AuthTagEntity> auths;

	@Size(max = 32, min = 4, message = "must be between 4-32 chars")
	@Column(name = "rol_name", unique = true, nullable = false, length = 32)
	private String rolName;

	@Column(name = "security_level", nullable = false)
	private Integer level = 0;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@JsonIgnore
	public RolEntity addAuth(AuthTagEntity auth) {
		getAuths().add(auth);
		return this;
	}

	public List<AuthTagEntity> getAuths() {
		if (auths == null)
			auths = new ArrayList<AuthTagEntity>();
		return auths;
	}

	public void setAuths(List<AuthTagEntity> auths) {
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
