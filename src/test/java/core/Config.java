package core;

public class Config {

	private static final String KEY_BROWSER = "browser";
	private static final String KEY_BASE_URL = "baseUrl";
	private static final String KEY_EXECUTION_MODE = "executionMode";
	private static final String KEY_GRID_URL = "gridUrl";
	private static final String KEY_HEADLESS_MODE = "headless";
	private static final String KEY_TIME_OUT = "timeout";

	private static final String DEFAULT_BROWSER = "chrome";
	private static final String DEFAULT_EXECUTION_MODE = "local";
	private static final String DEFAULT_GRID_URL = "http://localhost:4444/wd/hub";
	private static final boolean DEFAULT_HEADLESS = false;
	private static final int DEFAULT_TIMEOUT = 10;
	private static final String DEFAULT_BASE_URL = "https://www.alaskatrips.com";

	private Config() {

	}

	public static String getBaseUrl() {
		return System.getProperty(KEY_BASE_URL, DEFAULT_BASE_URL);
	}

	public static String getBrowser() {
		return System.getProperty(KEY_BROWSER, DEFAULT_BROWSER);
	}

	public static String getExecutionMode() {
		return System.getProperty(KEY_EXECUTION_MODE, DEFAULT_EXECUTION_MODE);
	}

	public static String getGridUrl() {
		return System.getProperty(KEY_GRID_URL, DEFAULT_GRID_URL);
	}

	public static boolean isHeadless() {
		try {
			return Boolean.parseBoolean(System.getProperty(KEY_HEADLESS_MODE, String.valueOf(DEFAULT_HEADLESS)));
		} catch (Exception e) {
			return DEFAULT_HEADLESS;
		}
	}

	public static int getTimeout() {
		try {
			return Integer.parseInt(System.getProperty(KEY_TIME_OUT, String.valueOf(DEFAULT_TIMEOUT)));
		} catch (Exception e) {
			return DEFAULT_TIMEOUT;
		}

	}

}
