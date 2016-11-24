package com.amoae.alfresco.jsrunasuser;

import org.alfresco.repo.jscript.BaseScopableProcessorExtension;
import org.alfresco.repo.security.authentication.AuthenticationUtil;
import org.alfresco.repo.security.authentication.AuthenticationUtil.RunAsWork;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Function;
import org.mozilla.javascript.Scriptable;

/**
 * Simple Javascript Extension allowing to run a part of Javascript on behalf of any user account
 * @author Charles LE GALLIC (charles@amoae.com)
 */
public class RunAsUserUtil extends BaseScopableProcessorExtension {

	public void runAs(final String userName, final Function func) {
		final Context cx = Context.getCurrentContext();
		final Scriptable scope = getScope();

		AuthenticationUtil.runAs(
				new RunAsWork<String>() {
					public String doWork() throws Exception {
						AuthenticationUtil.setRunAsUser(userName);
						AuthenticationUtil.setFullyAuthenticatedUser(userName);				
						func.call(cx, scope, scope, new Object[]{});
						return null;
					}
				}, 
				userName);
	}
}
