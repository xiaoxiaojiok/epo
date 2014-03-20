package com.gzgb.epo.controller.role;

import java.beans.PropertyEditorSupport;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springside.modules.utils.Collections3;

import com.gzgb.epo.entity.Permission;
import com.gzgb.epo.service.permission.PermissionService;


@Component
public class PermissionListEditor extends PropertyEditorSupport
{
	@Autowired
	private PermissionService permissionService;
	@Override
	public String getAsText()
	{
		return Collections3.extractToString((List) getValue(), "id", ",");
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException
	{
		String[] ids = StringUtils.split(text, ",");
		List<Permission> perms = new ArrayList<Permission>();
		for (String id : ids) {
			Permission perm = (Permission) permissionService.findById(Long.parseLong(id), Permission.class);
			perms.add(perm);
		}
		setValue(perms);
	}

}
