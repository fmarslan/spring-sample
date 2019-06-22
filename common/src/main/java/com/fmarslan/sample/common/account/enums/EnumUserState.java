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

package com.fmarslan.sample.common.account.enums;

import com.fmarslan.spring.base.common.shared.IEnum;

/**
 * @author DURU
 *
 */
public enum EnumUserState implements IEnum<Integer> {
	ACTIVE(0), PASSIVE(1), BLOCKED(2);

	Integer value;

	EnumUserState(int val) {
		value = val;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.fmarslan.spring.base.common.shared.IEnum#getValue()
	 */
	@Override
	public Integer getValue() {
		return value;
	}
}
