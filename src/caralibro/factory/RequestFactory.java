package caralibro.factory;

import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import caralibro.model.Application;
import caralibro.model.Session;

public class RequestFactory {
	
	public static Map<String,String> create(Application application, String method) {
		Map<String,String> params = new HashMap<String,String>();
		params.put("v", "1.0");
		params.put("format", "json");
		params.put("api_key", application.getKey());
		params.put("call_id", String.valueOf(System.currentTimeMillis())); // An auto-generated call id
		params.put("method", method);
		return params;
	}
	
	public static Map<String,String> create(Application application, Session session, String method) {
		Map<String,String> params = create(application, method);
		params.put("session_key", session.getKey());
		return params;
	}
	
	public static void sign(Map<String,String> params, Application application) {
		params.put("sig", generateSignature(application.getSecret(),params));
	}

	public static void sign(Map<String,String> params, Application application, Session session) {
		String signature;
		if (application.isDesktop() != null && application.isDesktop()) {
			// Desktop Applications are signed with the session secret!
			params.put("ss", "true");
			signature = generateSignature(session.getSecret(), params);	
		} else {
			signature = generateSignature(application.getSecret(), params); 
		}
		params.put("sig", signature);
	}
	
	private static String generateSignature(String applicationSecret, Map<String,String> parameters) {
		ArrayList<String >parameterNames = new ArrayList<String>(parameters.keySet());
		Collections.sort(parameterNames);
		String requestString = "";
		for (String parameterName : parameterNames) {
			requestString = requestString + parameterName + "=" + parameters.get(parameterName);
		}
		requestString = requestString + applicationSecret;
		return generateMd5(requestString);
	}
	
	private static String generateMd5(String str) {
		StringBuilder ans = new StringBuilder();
		try {
			MessageDigest messageDigest = MessageDigest.getInstance("MD5");
			for (byte b : messageDigest.digest(str.getBytes("UTF-8"))) {
				ans.append(Integer.toHexString((b & 0xf0) >>> 4));
				ans.append(Integer.toHexString(b & 0x0f));
		    }
		} catch (Exception e) {
			// Exception when there's no MD5 implementation!
			System.err.println("No MD5 algorithm on the default packages.");
			e.printStackTrace();
		}
		return ans.toString();
	}
	
}
