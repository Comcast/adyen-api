/*
 * Copyright 2015 Willian Oki
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
package com.adyen.payment.api.model;

import org.apache.commons.lang3.StringUtils;

/**
 * @author Willian Oki &lt;willian.oki@gmail.com&gt;
 *
 */
public class ModificationRequestBuilder {
	private ModificationRequestBuilder() {
	}

	public static IOriginalReference merchantAccount(String account) {
		return new Builder(account);
	}

	public interface IOriginalReference {
		IBuilder originalReference(String reference);
	}

	public interface IBuilder {
		IBuilder additionalData(String key, String value);

		IBuilder authorisationCode(String code);

		IBuilder reference(String reference);

		IBuilder modificationAmount(Amount amount);

		ModificationRequest build();
	}

	private static class Builder implements IOriginalReference, IBuilder {
		private ModificationRequest request;

		Builder(String merchantAccount) {
			if (StringUtils.isNotBlank(merchantAccount)) {
				request = new ModificationRequest();
				request.setMerchantAccount(merchantAccount);
			} else {
				// warn throw new
				// IllegalArgumentException("blank: merchantAccount");
			}
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * com.adyen.payment.api.model.CaptureRequestBuilder.IBuilder#reference
		 * (java.lang.String)
		 */
		@Override
		public IBuilder reference(String reference) {
			if (StringUtils.isNotBlank(reference)) {
				request.setReference(reference);
			} else {
				// warn
			}
			return this;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * com.adyen.payment.api.model.CaptureRequestBuilder.IBuilder#build()
		 */
		@Override
		public ModificationRequest build() {
			return request;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * com.adyen.payment.api.model.CaptureRequestBuilder.IOriginalReference
		 * #originalReference(java.lang.String)
		 */
		@Override
		public IBuilder originalReference(String reference) {
			if (StringUtils.isNotBlank(reference)) {
				request.setOriginalReference(reference);
			} else {
				// warn
			}
			return this;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see com.adyen.payment.api.model.ModificationRequestBuilder.IBuilder#
		 * modificationAmount(com.adyen.payment.api.model.Amount)
		 */
		@Override
		public IBuilder modificationAmount(Amount amount) {
			if (amount != null) {
				request.setModificationAmount(amount);
			} else {
				// warn
			}
			return this;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see com.adyen.payment.api.model.ModificationRequestBuilder.IBuilder#
		 * authorisationCode(java.lang.String)
		 */
		@Override
		public IBuilder authorisationCode(String code) {
			if (StringUtils.isNotBlank(code)) {
				request.setAuthorisationCode(code);
			} else {
				// warn
			}
			return this;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see com.adyen.payment.api.model.ModificationRequestBuilder.IBuilder#
		 * additionalData(java.lang.String, java.lang.String)
		 */
		@Override
		public IBuilder additionalData(String key, String value) {
			if (StringUtils.isNotBlank(key) && StringUtils.isNotBlank(value)) {
				request.getAdditionalData().put(key, value);
			} else {
				// warn
			}
			return this;
		}
	}
}
