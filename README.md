## Introduction ##
- This custom OSGi module is a POC for the scenario where a SAML users emailAddress has changed in the IdP and Liferay is not aware of the change.
- The default behaviour (assuming Liferay Stranger handling is to create unknown users) is that the system will attempt to match by emailAddress, not succeed, then attempt to create a new user but this will fail since the screenName is already in use by the existing user (with the old emailAddress).
- This module overrides the out of the box SAML DefaultUserResolver.java class. It attempts to match by screenName if a match by email address is not found. The users emailAddress should them be updated in Liferay by the out of the box code.
- The custom logic in the CustomSamlUserResolver.java class is disabled by default, there is a custom configuration setting to toggle it on or off.

## Environment ##
- The OSGi module is targeted at Liferay DXP 7.4 U92.
- It should be compiled with JDK 11 (or JDK 8).
- This customization is suitable for Liferay self hosted and Liferay PaaS. It is not suitable for Liferay SaaS as it is an OSGi extension.

## Setup ##
1. Add the module to the Liferay PaaS repository within Liferay/modules.
2. Allow the Liferay PaaS build to be generated and deploy the build to the target environment.
3. Login as an Administrator, go to Control Panel > System Settings > Security > Custom SAML User Resolver, enable 'Override Default Matching Behaviour' and Save.
4. Test the scenario of logging in as an existing user whose email address has been changed in the IdP but not in Liferay (yet).

## Notes ##
1. This is a public repository and is provided as a Proof Of Cencept (POC), as is. 
2. This customization does not handle the scenario of a users emailAddress AND screenName changing. In that scenario the default bahavious applies e.g. a new user would be created (depending on the Liferay Stranger handling setup).
3. The code assumes that the Liferay system is configured to match based on emailAddress.
4. When upgrading to a later Liferay DXP / Quarterly Release version ensure that the code is updated (if needed) to reflect any changes in DefaultUserResolver.java.
5. Source for Liferay DXP 7.4 U92 DefaultUserResolver.java is here: https://github.com/liferay/liferay-dxp/blob/7.4.13-u92/modules/dxp/apps/saml/saml-opensaml-integration/src/main/java/com/liferay/saml/opensaml/integration/internal/resolver/DefaultUserResolver.java
