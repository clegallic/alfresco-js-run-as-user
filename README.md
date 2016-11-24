alfresco-js-run-as-user
=======================

Allows to use the "AuthenticationUtil.runAs(...)" Java method in the javascript API.

The module exposes a new root object "runAsUserUtil" with a single runAs(userid, function) method.

For example, use it in a WebScript Javascript controller

	runAsUserUtil.runAs(
				"admin", 
				function(){ 
					model.companyhomeList = companyhome.children;
					model.sitesList = siteService.listSites(null, null, 0);
				}
	);

The module is also provided with a sample WebScript : http://localhost:8080/alfresco/s/runasuser/demo?id=abeecher

Manual Installation
-------------------
Use `mvn install` to create the AMP.

You can then install the AMP as you normally would using the MMT.

Alternatively, you can use the Maven plug-in to install the AMP by running `mvn alfresco:install -Dmaven.alfresco.warLocation=$TOMCAT_HOME/webapps/alfresco` if you are running your Alfresco WAR expanded, or specify the WAR if you are running unexpanded.

No further config or setup is necessary.

Compatibility
-------------
Only tested under Alfresco One 5.1 (EE).
But it should be working until Alfresco 4.2...
