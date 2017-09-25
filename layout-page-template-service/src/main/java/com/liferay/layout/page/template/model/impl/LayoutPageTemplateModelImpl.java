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

import com.liferay.layout.page.template.model.LayoutPageTemplate;
import com.liferay.layout.page.template.model.LayoutPageTemplateModel;
import com.liferay.layout.page.template.model.LayoutPageTemplateSoap;

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
 * The base model implementation for the LayoutPageTemplate service. Represents a row in the &quot;LayoutPageTemplate&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link LayoutPageTemplateModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link LayoutPageTemplateImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LayoutPageTemplateImpl
 * @see LayoutPageTemplate
 * @see LayoutPageTemplateModel
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class LayoutPageTemplateModelImpl extends BaseModelImpl<LayoutPageTemplate>
	implements LayoutPageTemplateModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a layout page template model instance should use the {@link LayoutPageTemplate} interface instead.
	 */
	public static final String TABLE_NAME = "LayoutPageTemplate";
	public static final Object[][] TABLE_COLUMNS = {
			{ "layoutPageTemplateId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "layoutPageTemplateFolderId", Types.BIGINT },
			{ "name", Types.VARCHAR }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("layoutPageTemplateId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("layoutPageTemplateFolderId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("name", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE = "create table LayoutPageTemplate (layoutPageTemplateId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,layoutPageTemplateFolderId LONG,name VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table LayoutPageTemplate";
	public static final String ORDER_BY_JPQL = " ORDER BY layoutPageTemplate.name ASC";
	public static final String ORDER_BY_SQL = " ORDER BY LayoutPageTemplate.name ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.layout.page.template.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.com.liferay.layout.page.template.model.LayoutPageTemplate"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.layout.page.template.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.com.liferay.layout.page.template.model.LayoutPageTemplate"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.layout.page.template.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.liferay.layout.page.template.model.LayoutPageTemplate"),
			true);
	public static final long GROUPID_COLUMN_BITMASK = 1L;
	public static final long LAYOUTPAGETEMPLATEFOLDERID_COLUMN_BITMASK = 2L;
	public static final long NAME_COLUMN_BITMASK = 4L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static LayoutPageTemplate toModel(LayoutPageTemplateSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		LayoutPageTemplate model = new LayoutPageTemplateImpl();

		model.setLayoutPageTemplateId(soapModel.getLayoutPageTemplateId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setLayoutPageTemplateFolderId(soapModel.getLayoutPageTemplateFolderId());
		model.setName(soapModel.getName());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<LayoutPageTemplate> toModels(
		LayoutPageTemplateSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<LayoutPageTemplate> models = new ArrayList<LayoutPageTemplate>(soapModels.length);

		for (LayoutPageTemplateSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.layout.page.template.service.util.ServiceProps.get(
				"lock.expiration.time.com.liferay.layout.page.template.model.LayoutPageTemplate"));

	public LayoutPageTemplateModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _layoutPageTemplateId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setLayoutPageTemplateId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _layoutPageTemplateId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return LayoutPageTemplate.class;
	}

	@Override
	public String getModelClassName() {
		return LayoutPageTemplate.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("layoutPageTemplateId", getLayoutPageTemplateId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("layoutPageTemplateFolderId",
			getLayoutPageTemplateFolderId());
		attributes.put("name", getName());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long layoutPageTemplateId = (Long)attributes.get("layoutPageTemplateId");

		if (layoutPageTemplateId != null) {
			setLayoutPageTemplateId(layoutPageTemplateId);
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

		Long layoutPageTemplateFolderId = (Long)attributes.get(
				"layoutPageTemplateFolderId");

		if (layoutPageTemplateFolderId != null) {
			setLayoutPageTemplateFolderId(layoutPageTemplateFolderId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}
	}

	@JSON
	@Override
	public long getLayoutPageTemplateId() {
		return _layoutPageTemplateId;
	}

	@Override
	public void setLayoutPageTemplateId(long layoutPageTemplateId) {
		_layoutPageTemplateId = layoutPageTemplateId;
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
	public long getLayoutPageTemplateFolderId() {
		return _layoutPageTemplateFolderId;
	}

	@Override
	public void setLayoutPageTemplateFolderId(long layoutPageTemplateFolderId) {
		_columnBitmask |= LAYOUTPAGETEMPLATEFOLDERID_COLUMN_BITMASK;

		if (!_setOriginalLayoutPageTemplateFolderId) {
			_setOriginalLayoutPageTemplateFolderId = true;

			_originalLayoutPageTemplateFolderId = _layoutPageTemplateFolderId;
		}

		_layoutPageTemplateFolderId = layoutPageTemplateFolderId;
	}

	public long getOriginalLayoutPageTemplateFolderId() {
		return _originalLayoutPageTemplateFolderId;
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

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			LayoutPageTemplate.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public LayoutPageTemplate toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (LayoutPageTemplate)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		LayoutPageTemplateImpl layoutPageTemplateImpl = new LayoutPageTemplateImpl();

		layoutPageTemplateImpl.setLayoutPageTemplateId(getLayoutPageTemplateId());
		layoutPageTemplateImpl.setGroupId(getGroupId());
		layoutPageTemplateImpl.setCompanyId(getCompanyId());
		layoutPageTemplateImpl.setUserId(getUserId());
		layoutPageTemplateImpl.setUserName(getUserName());
		layoutPageTemplateImpl.setCreateDate(getCreateDate());
		layoutPageTemplateImpl.setModifiedDate(getModifiedDate());
		layoutPageTemplateImpl.setLayoutPageTemplateFolderId(getLayoutPageTemplateFolderId());
		layoutPageTemplateImpl.setName(getName());

		layoutPageTemplateImpl.resetOriginalValues();

		return layoutPageTemplateImpl;
	}

	@Override
	public int compareTo(LayoutPageTemplate layoutPageTemplate) {
		int value = 0;

		value = getName().compareTo(layoutPageTemplate.getName());

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

		if (!(obj instanceof LayoutPageTemplate)) {
			return false;
		}

		LayoutPageTemplate layoutPageTemplate = (LayoutPageTemplate)obj;

		long primaryKey = layoutPageTemplate.getPrimaryKey();

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
		LayoutPageTemplateModelImpl layoutPageTemplateModelImpl = this;

		layoutPageTemplateModelImpl._originalGroupId = layoutPageTemplateModelImpl._groupId;

		layoutPageTemplateModelImpl._setOriginalGroupId = false;

		layoutPageTemplateModelImpl._setModifiedDate = false;

		layoutPageTemplateModelImpl._originalLayoutPageTemplateFolderId = layoutPageTemplateModelImpl._layoutPageTemplateFolderId;

		layoutPageTemplateModelImpl._setOriginalLayoutPageTemplateFolderId = false;

		layoutPageTemplateModelImpl._originalName = layoutPageTemplateModelImpl._name;

		layoutPageTemplateModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<LayoutPageTemplate> toCacheModel() {
		LayoutPageTemplateCacheModel layoutPageTemplateCacheModel = new LayoutPageTemplateCacheModel();

		layoutPageTemplateCacheModel.layoutPageTemplateId = getLayoutPageTemplateId();

		layoutPageTemplateCacheModel.groupId = getGroupId();

		layoutPageTemplateCacheModel.companyId = getCompanyId();

		layoutPageTemplateCacheModel.userId = getUserId();

		layoutPageTemplateCacheModel.userName = getUserName();

		String userName = layoutPageTemplateCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			layoutPageTemplateCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			layoutPageTemplateCacheModel.createDate = createDate.getTime();
		}
		else {
			layoutPageTemplateCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			layoutPageTemplateCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			layoutPageTemplateCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		layoutPageTemplateCacheModel.layoutPageTemplateFolderId = getLayoutPageTemplateFolderId();

		layoutPageTemplateCacheModel.name = getName();

		String name = layoutPageTemplateCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			layoutPageTemplateCacheModel.name = null;
		}

		return layoutPageTemplateCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{layoutPageTemplateId=");
		sb.append(getLayoutPageTemplateId());
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
		sb.append(", layoutPageTemplateFolderId=");
		sb.append(getLayoutPageTemplateFolderId());
		sb.append(", name=");
		sb.append(getName());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(31);

		sb.append("<model><model-name>");
		sb.append("com.liferay.layout.page.template.model.LayoutPageTemplate");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>layoutPageTemplateId</column-name><column-value><![CDATA[");
		sb.append(getLayoutPageTemplateId());
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
			"<column><column-name>layoutPageTemplateFolderId</column-name><column-value><![CDATA[");
		sb.append(getLayoutPageTemplateFolderId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = LayoutPageTemplate.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			LayoutPageTemplate.class
		};
	private long _layoutPageTemplateId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _layoutPageTemplateFolderId;
	private long _originalLayoutPageTemplateFolderId;
	private boolean _setOriginalLayoutPageTemplateFolderId;
	private String _name;
	private String _originalName;
	private long _columnBitmask;
	private LayoutPageTemplate _escapedModel;
}