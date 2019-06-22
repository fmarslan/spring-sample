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

import java.sql.Timestamp;
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
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.BatchSize;

import com.fmarslan.sample.common.AppConstant;
import com.fmarslan.sample.common.account.enums.EnumUserState;
import com.fmarslan.spring.base.common.shared.ISoftDelete;
import com.fmarslan.spring.base.persistence.BaseEntity;

@Entity
@Table(name = "tbl_user", uniqueConstraints = { 
		@UniqueConstraint(columnNames = { "username"}, name = "UQXX_USERXXUSERNAME" ),
		@UniqueConstraint(columnNames = { "email"}, name = "UQXX_USERXXEMAIL" )
	})
public class UserEntity extends BaseEntity<Long> implements ISoftDelete {

	private static final long serialVersionUID = -5220330273390667916L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "seq_user")
	@SequenceGenerator(name = "seq_user")
	private Long id;

	@Pattern(regexp = AppConstant.LOGIN_REGEX, message = "may contain only  [a-Z], [0-9], [-], [.]")
	@Size(max = 32, min = 4, message = "must be between 4-32 chars")
	@Column(name = "username", unique = true, nullable = false, length = 32)
	private String username;

	@Size(max = 32, min = 6, message = "must be between 6-32 chars")
	@Column(name = "password", nullable = false)
	private String password;

	@Column(name = "login_try", nullable = true)
	private Integer loginTry = 0;

	@Size(max = 32, min = 2, message = "must be between 2-32 chars")
	@Column(name = "first_name", nullable = false)
	private String firstName;

	@Size(max = 32, min = 2, message = "must be between 2-32 chars")
	@Column(name = "last_name", nullable = false)
	private String lastName;

	@Column(name = "google_key", unique = true, nullable = true)
	private String googleKey;

	@Column(name = "email", unique = true, nullable = false)
	private String email;

	@Column(name = "last_login", nullable = true)
	private Timestamp lastLogin;

	@Column(name = "is_deleted", nullable = false)
	private boolean deleted = false;

	@Column(name = "user_sate", nullable = false)
	private EnumUserState state = EnumUserState.ACTIVE;

	@Column(name = "security_level", nullable = false)
	private Integer level = 0;

	@ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
	@JoinTable(name = "tbl_user_rol", joinColumns = {
			@JoinColumn(name = "user_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_XX_USERXX_ROL")) }, inverseJoinColumns = {
					@JoinColumn(name = "rol_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_XX_ROLXX_USER")) })
	@BatchSize(size = 20)
	private List<RolEntity> rols;
	
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

	public String getGoogleKey() {
		return googleKey;
	}

	public void setGoogleKey(String googleKey) {
		this.googleKey = googleKey;
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

	public Timestamp getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Timestamp lastLogin) {
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

	public List<RolEntity> getRols() {
		return rols;
	}

	public void setRols(List<RolEntity> auths) {
		this.rols = auths;
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
	 * @see com.fmarslan.spring.base.common.shared.ISoftDelete#isDeleted()
	 */
	@Override
	public boolean isDeleted() {
		return deleted;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.fmarslan.spring.base.common.shared.ISoftDelete#setDeleted(boolean)
	 */
	@Override
	public void setDeleted(boolean delete) {
		this.deleted = delete;

	}

}
