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

package com.liferay.layout.page.template.service.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.layout.page.template.exception.DuplicateLayoutPageTemplateException;
import com.liferay.layout.page.template.exception.LayoutPageTemplateNameException;
import com.liferay.layout.page.template.model.LayoutPageTemplate;
import com.liferay.layout.page.template.model.LayoutPageTemplateFolder;
import com.liferay.layout.page.template.service.LayoutPageTemplateFolderServiceUtil;
import com.liferay.layout.page.template.service.LayoutPageTemplateServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.rule.DeleteAfterTestRun;
import com.liferay.portal.kernel.test.rule.Sync;
import com.liferay.portal.kernel.test.util.GroupTestUtil;
import com.liferay.portal.kernel.test.util.ServiceContextTestUtil;
import com.liferay.portal.kernel.test.util.TestPropsValues;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.test.rule.PermissionCheckerTestRule;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Jürgen Kappler
 */
@RunWith(Arquillian.class)
@Sync
public class LayoutPageTemplateServiceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(),
			PermissionCheckerTestRule.INSTANCE);

	@Before
	public void setUp() throws Exception {
		_group = GroupTestUtil.addGroup();
	}

	@Test(expected = DuplicateLayoutPageTemplateException.class)
	public void testAddDuplicateLayoutPageTemplates() throws Exception {
		ServiceContext serviceContext =
			ServiceContextTestUtil.getServiceContext(
				_group.getGroupId(), TestPropsValues.getUserId());

		LayoutPageTemplateFolder layoutPageTemplateFolder =
			LayoutPageTemplateFolderServiceUtil.addLayoutPageTemplateFolder(
				_group.getGroupId(), "Page Template Folder", null,
				serviceContext);

		LayoutPageTemplateServiceUtil.addLayoutPageTemplate(
			_group.getGroupId(),
			layoutPageTemplateFolder.getLayoutPageTemplateFolderId(),
			"Page Template", null, serviceContext);

		LayoutPageTemplateServiceUtil.addLayoutPageTemplate(
			_group.getGroupId(),
			layoutPageTemplateFolder.getLayoutPageTemplateFolderId(),
			"Page Template", null, serviceContext);
	}

	@Test(expected = LayoutPageTemplateNameException.class)
	public void testAddLayoutPageEntryWithNullName() throws Exception {
		ServiceContext serviceContext =
			ServiceContextTestUtil.getServiceContext(
				_group.getGroupId(), TestPropsValues.getUserId());

		LayoutPageTemplateFolder layoutPageTemplateFolder =
			LayoutPageTemplateFolderServiceUtil.addLayoutPageTemplateFolder(
				_group.getGroupId(), "Page Template Folder", null,
				serviceContext);

		LayoutPageTemplateServiceUtil.addLayoutPageTemplate(
			_group.getGroupId(),
			layoutPageTemplateFolder.getLayoutPageTemplateFolderId(), null,
			null, serviceContext);
	}

	@Test
	public void testAddLayoutPageTemplate() throws PortalException {
		ServiceContext serviceContext =
			ServiceContextTestUtil.getServiceContext(
				_group.getGroupId(), TestPropsValues.getUserId());

		LayoutPageTemplateFolder layoutPageTemplateFolder =
			LayoutPageTemplateFolderServiceUtil.addLayoutPageTemplateFolder(
				_group.getGroupId(), "Page Template Folder", null,
				serviceContext);

		LayoutPageTemplate layoutPageTemplate =
			LayoutPageTemplateServiceUtil.addLayoutPageTemplate(
				_group.getGroupId(),
				layoutPageTemplateFolder.getLayoutPageTemplateFolderId(),
				"Page Template", null, serviceContext);

		Assert.assertEquals("Page Template", layoutPageTemplate.getName());
	}

	@Test(expected = LayoutPageTemplateNameException.class)
	public void testAddLayoutPageTemplateWithEmptyName() throws Exception {
		ServiceContext serviceContext =
			ServiceContextTestUtil.getServiceContext(
				_group.getGroupId(), TestPropsValues.getUserId());

		LayoutPageTemplateFolder layoutPageTemplateFolder =
			LayoutPageTemplateFolderServiceUtil.addLayoutPageTemplateFolder(
				_group.getGroupId(), "Page Template Folder", null,
				serviceContext);

		LayoutPageTemplateServiceUtil.addLayoutPageTemplate(
			_group.getGroupId(),
			layoutPageTemplateFolder.getLayoutPageTemplateFolderId(),
			StringPool.BLANK, null, serviceContext);
	}

	@Test
	public void testAddMultipleLayoutPageTemplates() throws PortalException {
		ServiceContext serviceContext =
			ServiceContextTestUtil.getServiceContext(
				_group.getGroupId(), TestPropsValues.getUserId());

		LayoutPageTemplateFolder layoutPageTemplateFolder =
			LayoutPageTemplateFolderServiceUtil.addLayoutPageTemplateFolder(
				_group.getGroupId(), "Page Template Folder", null,
				serviceContext);

		List<LayoutPageTemplate> originalLayoutPageTemplates =
			LayoutPageTemplateServiceUtil.fetchPageTemplates(
				layoutPageTemplateFolder.getLayoutPageTemplateFolderId());

		LayoutPageTemplateServiceUtil.addLayoutPageTemplate(
			_group.getGroupId(),
			layoutPageTemplateFolder.getLayoutPageTemplateFolderId(),
			"Page Template 1", null, serviceContext);

		LayoutPageTemplateServiceUtil.addLayoutPageTemplate(
			_group.getGroupId(),
			layoutPageTemplateFolder.getLayoutPageTemplateFolderId(),
			"Page Template 2", null, serviceContext);

		List<LayoutPageTemplate> actualLayoutPageTemplates =
			LayoutPageTemplateServiceUtil.fetchPageTemplates(
				layoutPageTemplateFolder.getLayoutPageTemplateFolderId());

		Assert.assertEquals(
			actualLayoutPageTemplates.toString(),
			originalLayoutPageTemplates.size() + 2,
			actualLayoutPageTemplates.size());
	}

	@Test
	public void testDeleteLayoutPageTemplate() throws Exception {
		ServiceContext serviceContext =
			ServiceContextTestUtil.getServiceContext(
				_group.getGroupId(), TestPropsValues.getUserId());

		LayoutPageTemplateFolder layoutPageTemplateFolder =
			LayoutPageTemplateFolderServiceUtil.addLayoutPageTemplateFolder(
				_group.getGroupId(), "Page Template Folder", null,
				serviceContext);

		LayoutPageTemplate layoutPageTemplate =
			LayoutPageTemplateServiceUtil.addLayoutPageTemplate(
				_group.getGroupId(),
				layoutPageTemplateFolder.getLayoutPageTemplateFolderId(),
				"Page Template", null, serviceContext);

		LayoutPageTemplateServiceUtil.deleteLayoutPageTemplate(
			layoutPageTemplate.getLayoutPageTemplateId());

		Assert.assertNull(
			LayoutPageTemplateServiceUtil.fetchLayoutPageTemplate(
				layoutPageTemplate.getLayoutPageTemplateId()));
	}

	@DeleteAfterTestRun
	private Group _group;

}