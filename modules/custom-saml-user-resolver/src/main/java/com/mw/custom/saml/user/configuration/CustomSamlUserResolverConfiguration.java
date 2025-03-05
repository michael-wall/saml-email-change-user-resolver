package com.mw.custom.saml.user.configuration;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

import aQute.bnd.annotation.metatype.Meta;
import aQute.bnd.annotation.metatype.Meta.Type;

@ExtendedObjectClassDefinition(category = "custom-saml-user-resolver", scope = ExtendedObjectClassDefinition.Scope.SYSTEM)
@Meta.OCD(id = CustomSamlUserResolverConfiguration.PID, localization = "content/Language", name = "configuration.customSamlUserResolver.name", description="configuration.customSamlUserResolver.desc")
public interface CustomSamlUserResolverConfiguration {
	public static final String PID = "com.mw.custom.saml.user.configuration.CustomSamlUserResolverConfiguration";

	@Meta.AD(deflt = "false", required = false, type = Type.Boolean, name = "field.overrideDefaultMatchingBehaviour.name", description = "field.overrideDefaultMatchingBehaviour.desc")
	public boolean overrideDefaultMatchingBehaviour();
}