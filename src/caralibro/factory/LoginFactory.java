package caralibro.factory;

import caralibro.model.Application;

// Used to login your application (get a valid session). You can pass some extended permissions to the login url.
public class LoginFactory {
	
	public static String createUrlFromAuthenticationToken(Application application, String authenticationToken) {
		// This is the URL to allow the first access to your application
		return "http://www.facebook.com/login.php?api_key=" + application.getKey() + "&v=1.0" + "&auth_token=" + authenticationToken;
	}
	
	// Extended permissions like this, a comma-separated list: read_stream,publish_stream,offline_access
	public static String createUrlFromAuthenticationToken(Application application, String authenticationToken, String extendedPermissions) {
		return createUrlFromAuthenticationToken(application, authenticationToken) + "&req_perms=" + extendedPermissions + "&enable_profile_selector=1";
	}
	
	public static String createUrlForCodeGenerator(Application application) {
		return "http://www.facebook.com/code_gen.php?v=1.0&api_key=" + application.getKey();
	}
	
}
