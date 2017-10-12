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

package com.liferay.layout.page.template.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;

import com.liferay.layout.page.template.model.LayoutPageTemplateFolder;
import com.liferay.layout.page.template.model.LayoutPageTemplateFolderModel;
import com.liferay.layout.page.template.model.LayoutPageTemplateFolderSoap;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the LayoutPageTemplateFolder service. Represents a row in the &quot;LayoutPageTemplateFolder&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link LayoutPageTemplateFolderModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link LayoutPageTemplateFolderImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LayoutPageTemplateFolderImpl
 * @see LayoutPageTemplateFolder
 * @see LayoutPageTemplateFolderModel
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class LayoutPageTemplateFolderModelImpl extends BaseModelImpl<LayoutPageTemplateFolder>
	implements LayoutPageTemplateFolderModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a layout page template folder model instance should use the {@link LayoutPageTemplateFolder} interface instead.
	 */
	public static final String TABLE_NAME = "LayoutPageTemplateFolder";
	public static final Object[][] TABLE_COLUMNS = {
			{ "layoutPageTemplateFolderId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "name", Types.VARCHAR },
			{ "description", Types.VARCHAR }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("layoutPageTemplateFolderId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("name", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("description", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE = "create table LayoutPageTemplateFolder (layoutPageTemplateFolderId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,name VARCHAR(75) null,description VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table LayoutPageTemplateFolder";
	public static final String ORDER_BY_JPQL = " ORDER BY layoutPageTemplateFolder.name ASC";
	public static final String ORDER_BY_SQL = " ORDER BY LayoutPageTemplateFolder.name ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.layout.page.template.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.com.liferay.layout.page.template.model.LayoutPageTemplateFolder"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.layout.page.template.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.com.liferay.layout.page.template.model.LayoutPageTemplateFolder"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.layout.page.template.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.liferay.layout.page.template.model.LayoutPageTemplateFolder"),
			true);
	public static final long GROUPID_COLUMN_BITMASK = 1L;
	public static final long NAME_COLUMN_BITMASK = 2L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static LayoutPageTemplateFolder toModel(
		LayoutPageTemplateFolderSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		LayoutPageTemplateFolder model = new LayoutPageTemplateFolderImpl();

		model.setLayoutPageTemplateFolderId(soapModel.getLayoutPageTemplateFolderId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setName(soapModel.getName());
		model.setDescription(soapModel.getDescription());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<LayoutPageTemplateFolder> toModels(
		LayoutPageTemplateFolderSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<LayoutPageTemplateFolder> models = new ArrayList<LayoutPageTemplateFolder>(soapModels.length);

		for (LayoutPageTemplateFolderSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.layout.page.template.service.util.ServiceProps.get(
				"lock.expiration.time.com.liferay.layout.page.template.model.LayoutPageTemplateFolder"));

	public LayoutPageTemplateFolderModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _layoutPageTemplateFolderId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setLayoutPageTemplateFolderId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _layoutPageTemplateFolderId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return LayoutPageTemplateFolder.class;
	}

	@Override
	public String getModelClassName() {
		return LayoutPageTemplateFolder.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("layoutPageTemplateFolderId",
			getLayoutPageTemplateFolderId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("name", getName());
		attributes.put("description", getDescription());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long layoutPageTemplateFolderId = (Long)attributes.get(
				"layoutPageTemplateFolderId");

		if (layoutPageTemplateFolderId != null) {
			setLayoutPageTemplateFolderId(layoutPageTemplateFolderId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}
	}

	@JSON
	@Override
	public long getLayoutPageTemplateFolderId() {
		return _layoutPageTemplateFolderId;
	}

	@Override
	public void setLayoutPageTemplateFolderId(long layoutPageTemplateFolderId) {
		_layoutPageTemplateFolderId = layoutPageTemplateFolderId;
	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException pe) {
			return StringPool.BLANK;
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	@JSON
	@Override
	public String getUserName() {
		if (_userName == null) {
			return StringPool.BLANK;
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@JSON
	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		_modifiedDate = modifiedDate;
	}

	@JSON
	@Override
	public String getName() {
		if (_name == null) {
			return StringPool.BLANK;
		}
		else {
			return _name;
		}
	}

	@Override
	public void setName(String name) {
		_columnBitmask = -1L;

		if (_originalName == null) {
			_originalName = _name;
		}

		_name = name;
	}

	public String getOriginalName() {
		return GetterUtil.getString(_originalName);
	}

	@JSON
	@Override
	public String getDescription() {
		if (_description == null) {
			return StringPool.BLANK;
		}
		else {
			return _description;
		}
	}

	@Override
	public void setDescription(String description) {
		_description = description;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			LayoutPageTemplateFolder.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public LayoutPageTemplateFolder toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (LayoutPageTemplateFolder)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		LayoutPageTemplateFolderImpl layoutPageTemplateFolderImpl = new LayoutPageTemplateFolderImpl();

		layoutPageTemplateFolderImpl.setLayoutPageTemplateFolderId(getLayoutPageTemplateFolderId());
		layoutPageTemplateFolderImpl.setGroupId(getGroupId());
		layoutPageTemplateFolderImpl.setCompanyId(getCompanyId());
		layoutPageTemplateFolderImpl.setUserId(getUserId());
		layoutPageTemplateFolderImpl.setUserName(getUserName());
		layoutPageTemplateFolderImpl.setCreateDate(getCreateDate());
		layoutPageTemplateFolderImpl.setModifiedDate(getModifiedDate());
		layoutPageTemplateFolderImpl.setName(getName());
		layoutPageTemplateFolderImpl.setDescription(getDescription());

		layoutPageTemplateFolderImpl.resetOriginalValues();

		return layoutPageTemplateFolderImpl;
	}

	@Override
	public int compareTo(LayoutPageTemplateFolder layoutPageTemplateFolder) {
		int value = 0;

		value = getName().compareTo(layoutPageTemplateFolder.getName());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LayoutPageTemplateFolder)) {
			return false;
		}

		LayoutPageTemplateFolder layoutPageTemplateFolder = (LayoutPageTemplateFolder)obj;

		long primaryKey = layoutPageTemplateFolder.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		LayoutPageTemplateFolderModelImpl layoutPageTemplateFolderModelImpl = this;

		layoutPageTemplateFolderModelImpl._originalGroupId = layoutPageTemplateFolderModelImpl._groupId;

		layoutPageTemplateFolderModelImpl._setOriginalGroupId = false;

		layoutPageTemplateFolderModelImpl._setModifiedDate = false;

		layoutPageTemplateFolderModelImpl._originalName = layoutPageTemplateFolderModelImpl._name;

		layoutPageTemplateFolderModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<LayoutPageTemplateFolder> toCacheModel() {
		LayoutPageTemplateFolderCacheModel layoutPageTemplateFolderCacheModel = new LayoutPageTemplateFolderCacheModel();

		layoutPageTemplateFolderCacheModel.layoutPageTemplateFolderId = getLayoutPageTemplateFolderId();

		layoutPageTemplateFolderCacheModel.groupId = getGroupId();

		layoutPageTemplateFolderCacheModel.companyId = getCompanyId();

		layoutPageTemplateFolderCacheModel.userId = getUserId();

		layoutPageTemplateFolderCacheModel.userName = getUserName();

		String userName = layoutPageTemplateFolderCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			layoutPageTemplateFolderCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			layoutPageTemplateFolderCacheModel.createDate = createDate.getTime();
		}
		else {
			layoutPageTemplateFolderCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			layoutPageTemplateFolderCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			layoutPageTemplateFolderCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		layoutPageTemplateFolderCacheModel.name = getName();

		String name = layoutPageTemplateFolderCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			layoutPageTemplateFolderCacheModel.name = null;
		}

		layoutPageTemplateFolderCacheModel.description = getDescription();

		String description = layoutPageTemplateFolderCacheModel.description;

		if ((description != null) && (description.length() == 0)) {
			layoutPageTemplateFolderCacheModel.description = null;
		}

		return layoutPageTemplateFolderCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{layoutPageTemplateFolderId=");
		sb.append(getLayoutPageTemplateFolderId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(31);

		sb.append("<model><model-name>");
		sb.append(
			"com.liferay.layout.page.template.model.LayoutPageTemplateFolder");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>layoutPageTemplateFolderId</column-name><column-value><![CDATA[");
		sb.append(getLayoutPageTemplateFolderId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = LayoutPageTemplateFolder.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			LayoutPageTemplateFolder.class
		};
	private long _layoutPageTemplateFolderId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private String _name;
	private String _originalName;
	private String _description;
	private long _columnBitmask;
	private LayoutPageTemplateFolder _escapedModel;
}