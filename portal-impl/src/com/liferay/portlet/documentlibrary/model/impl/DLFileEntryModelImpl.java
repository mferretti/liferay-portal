/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
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

package com.liferay.portlet.documentlibrary.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.model.DLFileEntryModel;
import com.liferay.portlet.documentlibrary.model.DLFileEntrySoap;
import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the DLFileEntry service. Represents a row in the &quot;DLFileEntry&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.liferay.portlet.documentlibrary.model.DLFileEntryModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link DLFileEntryImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DLFileEntryImpl
 * @see com.liferay.portlet.documentlibrary.model.DLFileEntry
 * @see com.liferay.portlet.documentlibrary.model.DLFileEntryModel
 * @generated
 */
@JSON(strict = true)
public class DLFileEntryModelImpl extends BaseModelImpl<DLFileEntry>
	implements DLFileEntryModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a document library file entry model instance should use the {@link com.liferay.portlet.documentlibrary.model.DLFileEntry} interface instead.
	 */
	public static final String TABLE_NAME = "DLFileEntry";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "fileEntryId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "versionUserId", Types.BIGINT },
			{ "versionUserName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "repositoryId", Types.BIGINT },
			{ "folderId", Types.BIGINT },
			{ "name", Types.VARCHAR },
			{ "extension", Types.VARCHAR },
			{ "mimeType", Types.VARCHAR },
			{ "title", Types.VARCHAR },
			{ "description", Types.VARCHAR },
			{ "extraSettings", Types.CLOB },
			{ "fileEntryTypeId", Types.BIGINT },
			{ "version", Types.VARCHAR },
			{ "size_", Types.BIGINT },
			{ "readCount", Types.INTEGER },
			{ "smallImageId", Types.BIGINT },
			{ "largeImageId", Types.BIGINT },
			{ "custom1ImageId", Types.BIGINT },
			{ "custom2ImageId", Types.BIGINT }
		};
	public static final String TABLE_SQL_CREATE = "create table DLFileEntry (uuid_ VARCHAR(75) null,fileEntryId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,versionUserId LONG,versionUserName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,repositoryId LONG,folderId LONG,name VARCHAR(255) null,extension VARCHAR(75) null,mimeType VARCHAR(75) null,title VARCHAR(255) null,description STRING null,extraSettings TEXT null,fileEntryTypeId LONG,version VARCHAR(75) null,size_ LONG,readCount INTEGER,smallImageId LONG,largeImageId LONG,custom1ImageId LONG,custom2ImageId LONG)";
	public static final String TABLE_SQL_DROP = "drop table DLFileEntry";
	public static final String ORDER_BY_JPQL = " ORDER BY dlFileEntry.folderId ASC, dlFileEntry.name ASC";
	public static final String ORDER_BY_SQL = " ORDER BY DLFileEntry.folderId ASC, DLFileEntry.name ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
				"value.object.entity.cache.enabled.com.liferay.portlet.documentlibrary.model.DLFileEntry"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
				"value.object.finder.cache.enabled.com.liferay.portlet.documentlibrary.model.DLFileEntry"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
				"value.object.column.bitmask.enabled.com.liferay.portlet.documentlibrary.model.DLFileEntry"),
			true);
	public static long COMPANYID_COLUMN_BITMASK = 1L;
	public static long FILEENTRYTYPEID_COLUMN_BITMASK = 2L;
	public static long FOLDERID_COLUMN_BITMASK = 4L;
	public static long GROUPID_COLUMN_BITMASK = 8L;
	public static long NAME_COLUMN_BITMASK = 16L;
	public static long TITLE_COLUMN_BITMASK = 32L;
	public static long USERID_COLUMN_BITMASK = 64L;
	public static long UUID_COLUMN_BITMASK = 128L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static DLFileEntry toModel(DLFileEntrySoap soapModel) {
		DLFileEntry model = new DLFileEntryImpl();

		model.setUuid(soapModel.getUuid());
		model.setFileEntryId(soapModel.getFileEntryId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setVersionUserId(soapModel.getVersionUserId());
		model.setVersionUserName(soapModel.getVersionUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setRepositoryId(soapModel.getRepositoryId());
		model.setFolderId(soapModel.getFolderId());
		model.setName(soapModel.getName());
		model.setExtension(soapModel.getExtension());
		model.setMimeType(soapModel.getMimeType());
		model.setTitle(soapModel.getTitle());
		model.setDescription(soapModel.getDescription());
		model.setExtraSettings(soapModel.getExtraSettings());
		model.setFileEntryTypeId(soapModel.getFileEntryTypeId());
		model.setVersion(soapModel.getVersion());
		model.setSize(soapModel.getSize());
		model.setReadCount(soapModel.getReadCount());
		model.setSmallImageId(soapModel.getSmallImageId());
		model.setLargeImageId(soapModel.getLargeImageId());
		model.setCustom1ImageId(soapModel.getCustom1ImageId());
		model.setCustom2ImageId(soapModel.getCustom2ImageId());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<DLFileEntry> toModels(DLFileEntrySoap[] soapModels) {
		List<DLFileEntry> models = new ArrayList<DLFileEntry>(soapModels.length);

		for (DLFileEntrySoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
				"lock.expiration.time.com.liferay.portlet.documentlibrary.model.DLFileEntry"));

	public DLFileEntryModelImpl() {
	}

	public long getPrimaryKey() {
		return _fileEntryId;
	}

	public void setPrimaryKey(long primaryKey) {
		setFileEntryId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_fileEntryId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public Class<?> getModelClass() {
		return DLFileEntry.class;
	}

	public String getModelClassName() {
		return DLFileEntry.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("fileEntryId", getFileEntryId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("versionUserId", getVersionUserId());
		attributes.put("versionUserName", getVersionUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("repositoryId", getRepositoryId());
		attributes.put("folderId", getFolderId());
		attributes.put("name", getName());
		attributes.put("extension", getExtension());
		attributes.put("mimeType", getMimeType());
		attributes.put("title", getTitle());
		attributes.put("description", getDescription());
		attributes.put("extraSettings", getExtraSettings());
		attributes.put("fileEntryTypeId", getFileEntryTypeId());
		attributes.put("version", getVersion());
		attributes.put("size", getSize());
		attributes.put("readCount", getReadCount());
		attributes.put("smallImageId", getSmallImageId());
		attributes.put("largeImageId", getLargeImageId());
		attributes.put("custom1ImageId", getCustom1ImageId());
		attributes.put("custom2ImageId", getCustom2ImageId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long fileEntryId = (Long)attributes.get("fileEntryId");

		if (fileEntryId != null) {
			setFileEntryId(fileEntryId);
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

		Long versionUserId = (Long)attributes.get("versionUserId");

		if (versionUserId != null) {
			setVersionUserId(versionUserId);
		}

		String versionUserName = (String)attributes.get("versionUserName");

		if (versionUserName != null) {
			setVersionUserName(versionUserName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long repositoryId = (Long)attributes.get("repositoryId");

		if (repositoryId != null) {
			setRepositoryId(repositoryId);
		}

		Long folderId = (Long)attributes.get("folderId");

		if (folderId != null) {
			setFolderId(folderId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String extension = (String)attributes.get("extension");

		if (extension != null) {
			setExtension(extension);
		}

		String mimeType = (String)attributes.get("mimeType");

		if (mimeType != null) {
			setMimeType(mimeType);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String extraSettings = (String)attributes.get("extraSettings");

		if (extraSettings != null) {
			setExtraSettings(extraSettings);
		}

		Long fileEntryTypeId = (Long)attributes.get("fileEntryTypeId");

		if (fileEntryTypeId != null) {
			setFileEntryTypeId(fileEntryTypeId);
		}

		String version = (String)attributes.get("version");

		if (version != null) {
			setVersion(version);
		}

		Long size = (Long)attributes.get("size");

		if (size != null) {
			setSize(size);
		}

		Integer readCount = (Integer)attributes.get("readCount");

		if (readCount != null) {
			setReadCount(readCount);
		}

		Long smallImageId = (Long)attributes.get("smallImageId");

		if (smallImageId != null) {
			setSmallImageId(smallImageId);
		}

		Long largeImageId = (Long)attributes.get("largeImageId");

		if (largeImageId != null) {
			setLargeImageId(largeImageId);
		}

		Long custom1ImageId = (Long)attributes.get("custom1ImageId");

		if (custom1ImageId != null) {
			setCustom1ImageId(custom1ImageId);
		}

		Long custom2ImageId = (Long)attributes.get("custom2ImageId");

		if (custom2ImageId != null) {
			setCustom2ImageId(custom2ImageId);
		}
	}

	@JSON
	public String getUuid() {
		if (_uuid == null) {
			return StringPool.BLANK;
		}
		else {
			return _uuid;
		}
	}

	public void setUuid(String uuid) {
		if (_originalUuid == null) {
			_originalUuid = _uuid;
		}

		_uuid = uuid;
	}

	public String getOriginalUuid() {
		return GetterUtil.getString(_originalUuid);
	}

	@JSON
	public long getFileEntryId() {
		return _fileEntryId;
	}

	public void setFileEntryId(long fileEntryId) {
		_fileEntryId = fileEntryId;
	}

	@JSON
	public long getGroupId() {
		return _groupId;
	}

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
	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_columnBitmask |= COMPANYID_COLUMN_BITMASK;

		if (!_setOriginalCompanyId) {
			_setOriginalCompanyId = true;

			_originalCompanyId = _companyId;
		}

		_companyId = companyId;
	}

	public long getOriginalCompanyId() {
		return _originalCompanyId;
	}

	@JSON
	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_columnBitmask |= USERID_COLUMN_BITMASK;

		if (!_setOriginalUserId) {
			_setOriginalUserId = true;

			_originalUserId = _userId;
		}

		_userId = userId;
	}

	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	public long getOriginalUserId() {
		return _originalUserId;
	}

	@JSON
	public String getUserName() {
		if (_userName == null) {
			return StringPool.BLANK;
		}
		else {
			return _userName;
		}
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	@JSON
	public long getVersionUserId() {
		return _versionUserId;
	}

	public void setVersionUserId(long versionUserId) {
		_versionUserId = versionUserId;
	}

	public String getVersionUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getVersionUserId(), "uuid",
			_versionUserUuid);
	}

	public void setVersionUserUuid(String versionUserUuid) {
		_versionUserUuid = versionUserUuid;
	}

	@JSON
	public String getVersionUserName() {
		if (_versionUserName == null) {
			return StringPool.BLANK;
		}
		else {
			return _versionUserName;
		}
	}

	public void setVersionUserName(String versionUserName) {
		_versionUserName = versionUserName;
	}

	@JSON
	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@JSON
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	@JSON
	public long getRepositoryId() {
		return _repositoryId;
	}

	public void setRepositoryId(long repositoryId) {
		_repositoryId = repositoryId;
	}

	@JSON
	public long getFolderId() {
		return _folderId;
	}

	public void setFolderId(long folderId) {
		_columnBitmask = -1L;

		if (!_setOriginalFolderId) {
			_setOriginalFolderId = true;

			_originalFolderId = _folderId;
		}

		_folderId = folderId;
	}

	public long getOriginalFolderId() {
		return _originalFolderId;
	}

	@JSON
	public String getName() {
		if (_name == null) {
			return StringPool.BLANK;
		}
		else {
			return _name;
		}
	}

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
	public String getExtension() {
		if (_extension == null) {
			return StringPool.BLANK;
		}
		else {
			return _extension;
		}
	}

	public void setExtension(String extension) {
		_extension = extension;
	}

	@JSON
	public String getMimeType() {
		if (_mimeType == null) {
			return StringPool.BLANK;
		}
		else {
			return _mimeType;
		}
	}

	public void setMimeType(String mimeType) {
		_mimeType = mimeType;
	}

	@JSON
	public String getTitle() {
		if (_title == null) {
			return StringPool.BLANK;
		}
		else {
			return _title;
		}
	}

	public void setTitle(String title) {
		_columnBitmask |= TITLE_COLUMN_BITMASK;

		if (_originalTitle == null) {
			_originalTitle = _title;
		}

		_title = title;
	}

	public String getOriginalTitle() {
		return GetterUtil.getString(_originalTitle);
	}

	@JSON
	public String getDescription() {
		if (_description == null) {
			return StringPool.BLANK;
		}
		else {
			return _description;
		}
	}

	public void setDescription(String description) {
		_description = description;
	}

	@JSON
	public String getExtraSettings() {
		if (_extraSettings == null) {
			return StringPool.BLANK;
		}
		else {
			return _extraSettings;
		}
	}

	public void setExtraSettings(String extraSettings) {
		_extraSettings = extraSettings;
	}

	@JSON
	public long getFileEntryTypeId() {
		return _fileEntryTypeId;
	}

	public void setFileEntryTypeId(long fileEntryTypeId) {
		_columnBitmask |= FILEENTRYTYPEID_COLUMN_BITMASK;

		if (!_setOriginalFileEntryTypeId) {
			_setOriginalFileEntryTypeId = true;

			_originalFileEntryTypeId = _fileEntryTypeId;
		}

		_fileEntryTypeId = fileEntryTypeId;
	}

	public long getOriginalFileEntryTypeId() {
		return _originalFileEntryTypeId;
	}

	@JSON
	public String getVersion() {
		if (_version == null) {
			return StringPool.BLANK;
		}
		else {
			return _version;
		}
	}

	public void setVersion(String version) {
		_version = version;
	}

	@JSON
	public long getSize() {
		return _size;
	}

	public void setSize(long size) {
		_size = size;
	}

	@JSON
	public int getReadCount() {
		return _readCount;
	}

	public void setReadCount(int readCount) {
		_readCount = readCount;
	}

	@JSON
	public long getSmallImageId() {
		return _smallImageId;
	}

	public void setSmallImageId(long smallImageId) {
		_smallImageId = smallImageId;
	}

	@JSON
	public long getLargeImageId() {
		return _largeImageId;
	}

	public void setLargeImageId(long largeImageId) {
		_largeImageId = largeImageId;
	}

	@JSON
	public long getCustom1ImageId() {
		return _custom1ImageId;
	}

	public void setCustom1ImageId(long custom1ImageId) {
		_custom1ImageId = custom1ImageId;
	}

	@JSON
	public long getCustom2ImageId() {
		return _custom2ImageId;
	}

	public void setCustom2ImageId(long custom2ImageId) {
		_custom2ImageId = custom2ImageId;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public DLFileEntry toEscapedModel() {
		if (_escapedModelProxy == null) {
			_escapedModelProxy = (DLFileEntry)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelProxyInterfaces,
					new AutoEscapeBeanHandler(this));
		}

		return _escapedModelProxy;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		if (_expandoBridge == null) {
			_expandoBridge = ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
					DLFileEntry.class.getName(), getPrimaryKey());
		}

		return _expandoBridge;
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		getExpandoBridge().setAttributes(serviceContext);
	}

	@Override
	public Object clone() {
		DLFileEntryImpl dlFileEntryImpl = new DLFileEntryImpl();

		dlFileEntryImpl.setUuid(getUuid());
		dlFileEntryImpl.setFileEntryId(getFileEntryId());
		dlFileEntryImpl.setGroupId(getGroupId());
		dlFileEntryImpl.setCompanyId(getCompanyId());
		dlFileEntryImpl.setUserId(getUserId());
		dlFileEntryImpl.setUserName(getUserName());
		dlFileEntryImpl.setVersionUserId(getVersionUserId());
		dlFileEntryImpl.setVersionUserName(getVersionUserName());
		dlFileEntryImpl.setCreateDate(getCreateDate());
		dlFileEntryImpl.setModifiedDate(getModifiedDate());
		dlFileEntryImpl.setRepositoryId(getRepositoryId());
		dlFileEntryImpl.setFolderId(getFolderId());
		dlFileEntryImpl.setName(getName());
		dlFileEntryImpl.setExtension(getExtension());
		dlFileEntryImpl.setMimeType(getMimeType());
		dlFileEntryImpl.setTitle(getTitle());
		dlFileEntryImpl.setDescription(getDescription());
		dlFileEntryImpl.setExtraSettings(getExtraSettings());
		dlFileEntryImpl.setFileEntryTypeId(getFileEntryTypeId());
		dlFileEntryImpl.setVersion(getVersion());
		dlFileEntryImpl.setSize(getSize());
		dlFileEntryImpl.setReadCount(getReadCount());
		dlFileEntryImpl.setSmallImageId(getSmallImageId());
		dlFileEntryImpl.setLargeImageId(getLargeImageId());
		dlFileEntryImpl.setCustom1ImageId(getCustom1ImageId());
		dlFileEntryImpl.setCustom2ImageId(getCustom2ImageId());

		dlFileEntryImpl.resetOriginalValues();

		return dlFileEntryImpl;
	}

	public int compareTo(DLFileEntry dlFileEntry) {
		int value = 0;

		if (getFolderId() < dlFileEntry.getFolderId()) {
			value = -1;
		}
		else if (getFolderId() > dlFileEntry.getFolderId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		value = getName().compareTo(dlFileEntry.getName());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		DLFileEntry dlFileEntry = null;

		try {
			dlFileEntry = (DLFileEntry)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = dlFileEntry.getPrimaryKey();

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
	public void resetOriginalValues() {
		DLFileEntryModelImpl dlFileEntryModelImpl = this;

		dlFileEntryModelImpl._originalUuid = dlFileEntryModelImpl._uuid;

		dlFileEntryModelImpl._originalGroupId = dlFileEntryModelImpl._groupId;

		dlFileEntryModelImpl._setOriginalGroupId = false;

		dlFileEntryModelImpl._originalCompanyId = dlFileEntryModelImpl._companyId;

		dlFileEntryModelImpl._setOriginalCompanyId = false;

		dlFileEntryModelImpl._originalUserId = dlFileEntryModelImpl._userId;

		dlFileEntryModelImpl._setOriginalUserId = false;

		dlFileEntryModelImpl._originalFolderId = dlFileEntryModelImpl._folderId;

		dlFileEntryModelImpl._setOriginalFolderId = false;

		dlFileEntryModelImpl._originalName = dlFileEntryModelImpl._name;

		dlFileEntryModelImpl._originalTitle = dlFileEntryModelImpl._title;

		dlFileEntryModelImpl._originalFileEntryTypeId = dlFileEntryModelImpl._fileEntryTypeId;

		dlFileEntryModelImpl._setOriginalFileEntryTypeId = false;

		dlFileEntryModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<DLFileEntry> toCacheModel() {
		DLFileEntryCacheModel dlFileEntryCacheModel = new DLFileEntryCacheModel();

		dlFileEntryCacheModel.uuid = getUuid();

		String uuid = dlFileEntryCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			dlFileEntryCacheModel.uuid = null;
		}

		dlFileEntryCacheModel.fileEntryId = getFileEntryId();

		dlFileEntryCacheModel.groupId = getGroupId();

		dlFileEntryCacheModel.companyId = getCompanyId();

		dlFileEntryCacheModel.userId = getUserId();

		dlFileEntryCacheModel.userName = getUserName();

		String userName = dlFileEntryCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			dlFileEntryCacheModel.userName = null;
		}

		dlFileEntryCacheModel.versionUserId = getVersionUserId();

		dlFileEntryCacheModel.versionUserName = getVersionUserName();

		String versionUserName = dlFileEntryCacheModel.versionUserName;

		if ((versionUserName != null) && (versionUserName.length() == 0)) {
			dlFileEntryCacheModel.versionUserName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			dlFileEntryCacheModel.createDate = createDate.getTime();
		}
		else {
			dlFileEntryCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			dlFileEntryCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			dlFileEntryCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		dlFileEntryCacheModel.repositoryId = getRepositoryId();

		dlFileEntryCacheModel.folderId = getFolderId();

		dlFileEntryCacheModel.name = getName();

		String name = dlFileEntryCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			dlFileEntryCacheModel.name = null;
		}

		dlFileEntryCacheModel.extension = getExtension();

		String extension = dlFileEntryCacheModel.extension;

		if ((extension != null) && (extension.length() == 0)) {
			dlFileEntryCacheModel.extension = null;
		}

		dlFileEntryCacheModel.mimeType = getMimeType();

		String mimeType = dlFileEntryCacheModel.mimeType;

		if ((mimeType != null) && (mimeType.length() == 0)) {
			dlFileEntryCacheModel.mimeType = null;
		}

		dlFileEntryCacheModel.title = getTitle();

		String title = dlFileEntryCacheModel.title;

		if ((title != null) && (title.length() == 0)) {
			dlFileEntryCacheModel.title = null;
		}

		dlFileEntryCacheModel.description = getDescription();

		String description = dlFileEntryCacheModel.description;

		if ((description != null) && (description.length() == 0)) {
			dlFileEntryCacheModel.description = null;
		}

		dlFileEntryCacheModel.extraSettings = getExtraSettings();

		String extraSettings = dlFileEntryCacheModel.extraSettings;

		if ((extraSettings != null) && (extraSettings.length() == 0)) {
			dlFileEntryCacheModel.extraSettings = null;
		}

		dlFileEntryCacheModel.fileEntryTypeId = getFileEntryTypeId();

		dlFileEntryCacheModel.version = getVersion();

		String version = dlFileEntryCacheModel.version;

		if ((version != null) && (version.length() == 0)) {
			dlFileEntryCacheModel.version = null;
		}

		dlFileEntryCacheModel.size = getSize();

		dlFileEntryCacheModel.readCount = getReadCount();

		dlFileEntryCacheModel.smallImageId = getSmallImageId();

		dlFileEntryCacheModel.largeImageId = getLargeImageId();

		dlFileEntryCacheModel.custom1ImageId = getCustom1ImageId();

		dlFileEntryCacheModel.custom2ImageId = getCustom2ImageId();

		return dlFileEntryCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(53);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", fileEntryId=");
		sb.append(getFileEntryId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", versionUserId=");
		sb.append(getVersionUserId());
		sb.append(", versionUserName=");
		sb.append(getVersionUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", repositoryId=");
		sb.append(getRepositoryId());
		sb.append(", folderId=");
		sb.append(getFolderId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", extension=");
		sb.append(getExtension());
		sb.append(", mimeType=");
		sb.append(getMimeType());
		sb.append(", title=");
		sb.append(getTitle());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", extraSettings=");
		sb.append(getExtraSettings());
		sb.append(", fileEntryTypeId=");
		sb.append(getFileEntryTypeId());
		sb.append(", version=");
		sb.append(getVersion());
		sb.append(", size=");
		sb.append(getSize());
		sb.append(", readCount=");
		sb.append(getReadCount());
		sb.append(", smallImageId=");
		sb.append(getSmallImageId());
		sb.append(", largeImageId=");
		sb.append(getLargeImageId());
		sb.append(", custom1ImageId=");
		sb.append(getCustom1ImageId());
		sb.append(", custom2ImageId=");
		sb.append(getCustom2ImageId());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(82);

		sb.append("<model><model-name>");
		sb.append("com.liferay.portlet.documentlibrary.model.DLFileEntry");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fileEntryId</column-name><column-value><![CDATA[");
		sb.append(getFileEntryId());
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
			"<column><column-name>versionUserId</column-name><column-value><![CDATA[");
		sb.append(getVersionUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>versionUserName</column-name><column-value><![CDATA[");
		sb.append(getVersionUserName());
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
			"<column><column-name>repositoryId</column-name><column-value><![CDATA[");
		sb.append(getRepositoryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>folderId</column-name><column-value><![CDATA[");
		sb.append(getFolderId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>extension</column-name><column-value><![CDATA[");
		sb.append(getExtension());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>mimeType</column-name><column-value><![CDATA[");
		sb.append(getMimeType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>title</column-name><column-value><![CDATA[");
		sb.append(getTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>extraSettings</column-name><column-value><![CDATA[");
		sb.append(getExtraSettings());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fileEntryTypeId</column-name><column-value><![CDATA[");
		sb.append(getFileEntryTypeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>version</column-name><column-value><![CDATA[");
		sb.append(getVersion());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>size</column-name><column-value><![CDATA[");
		sb.append(getSize());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>readCount</column-name><column-value><![CDATA[");
		sb.append(getReadCount());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>smallImageId</column-name><column-value><![CDATA[");
		sb.append(getSmallImageId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>largeImageId</column-name><column-value><![CDATA[");
		sb.append(getLargeImageId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>custom1ImageId</column-name><column-value><![CDATA[");
		sb.append(getCustom1ImageId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>custom2ImageId</column-name><column-value><![CDATA[");
		sb.append(getCustom2ImageId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = DLFileEntry.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			DLFileEntry.class
		};
	private String _uuid;
	private String _originalUuid;
	private long _fileEntryId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _userId;
	private String _userUuid;
	private long _originalUserId;
	private boolean _setOriginalUserId;
	private String _userName;
	private long _versionUserId;
	private String _versionUserUuid;
	private String _versionUserName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _repositoryId;
	private long _folderId;
	private long _originalFolderId;
	private boolean _setOriginalFolderId;
	private String _name;
	private String _originalName;
	private String _extension;
	private String _mimeType;
	private String _title;
	private String _originalTitle;
	private String _description;
	private String _extraSettings;
	private long _fileEntryTypeId;
	private long _originalFileEntryTypeId;
	private boolean _setOriginalFileEntryTypeId;
	private String _version;
	private long _size;
	private int _readCount;
	private long _smallImageId;
	private long _largeImageId;
	private long _custom1ImageId;
	private long _custom2ImageId;
	private transient ExpandoBridge _expandoBridge;
	private long _columnBitmask;
	private DLFileEntry _escapedModelProxy;
}