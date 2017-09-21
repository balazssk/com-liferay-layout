/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.layout.page.template.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.GroupedModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the LayoutPageTemplateFolder service. Represents a row in the &quot;LayoutPageTemplateFolder&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.layout.page.template.model.impl.LayoutPageTemplateFolderModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.layout.page.template.model.impl.LayoutPageTemplateFolderImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LayoutPageTemplateFolder
 * @see com.liferay.layout.page.template.model.impl.LayoutPageTemplateFolderImpl
 * @see com.liferay.layout.page.template.model.impl.LayoutPageTemplateFolderModelImpl
 * @generated
 */
@ProviderType
public interface LayoutPageTemplateFolderModel extends BaseModel<LayoutPageTemplateFolder>,
	GroupedModel, ShardedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a layout page template folder model instance should use the {@link LayoutPageTemplateFolder} interface instead.
	 */

	/**
	 * Returns the primary key of this layout page template folder.
	 *
	 * @return the primary key of this layout page template folder
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this layout page template folder.
	 *
	 * @param primaryKey the primary key of this layout page template folder
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the layout page template folder ID of this layout page template folder.
	 *
	 * @return the layout page template folder ID of this layout page template folder
	 */
	public long getLayoutPageTemplateFolderId();

	/**
	 * Sets the layout page template folder ID of this layout page template folder.
	 *
	 * @param layoutPageTemplateFolderId the layout page template folder ID of this layout page template folder
	 */
	public void setLayoutPageTemplateFolderId(long layoutPageTemplateFolderId);

	/**
	 * Returns the group ID of this layout page template folder.
	 *
	 * @return the group ID of this layout page template folder
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this layout page template folder.
	 *
	 * @param groupId the group ID of this layout page template folder
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this layout page template folder.
	 *
	 * @return the company ID of this layout page template folder
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this layout page template folder.
	 *
	 * @param companyId the company ID of this layout page template folder
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this layout page template folder.
	 *
	 * @return the user ID of this layout page template folder
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this layout page template folder.
	 *
	 * @param userId the user ID of this layout page template folder
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this layout page template folder.
	 *
	 * @return the user uuid of this layout page template folder
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this layout page template folder.
	 *
	 * @param userUuid the user uuid of this layout page template folder
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this layout page template folder.
	 *
	 * @return the user name of this layout page template folder
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this layout page template folder.
	 *
	 * @param userName the user name of this layout page template folder
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this layout page template folder.
	 *
	 * @return the create date of this layout page template folder
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this layout page template folder.
	 *
	 * @param createDate the create date of this layout page template folder
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this layout page template folder.
	 *
	 * @return the modified date of this layout page template folder
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this layout page template folder.
	 *
	 * @param modifiedDate the modified date of this layout page template folder
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the name of this layout page template folder.
	 *
	 * @return the name of this layout page template folder
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this layout page template folder.
	 *
	 * @param name the name of this layout page template folder
	 */
	public void setName(String name);

	/**
	 * Returns the description of this layout page template folder.
	 *
	 * @return the description of this layout page template folder
	 */
	@AutoEscape
	public String getDescription();

	/**
	 * Sets the description of this layout page template folder.
	 *
	 * @param description the description of this layout page template folder
	 */
	public void setDescription(String description);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(LayoutPageTemplateFolder layoutPageTemplateFolder);

	@Override
	public int hashCode();

	@Override
	public CacheModel<LayoutPageTemplateFolder> toCacheModel();

	@Override
	public LayoutPageTemplateFolder toEscapedModel();

	@Override
	public LayoutPageTemplateFolder toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}