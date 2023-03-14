package com.sjgl;

/**
 * {@code Version} contains version information of {@code SJGL} library.
 * @author yiwuen
 *
 */
public final class Version {
	
	private static final String current = "1.0.0";
	
	public static final String[] versions = {current};
	
	private Version() {
	}
	
	/**
	 * Returns the current version of {@code SJGL}.
	 * @return String version
	 */
	public final static String getVersion() {
		return current;
	}
	
	/**
	 * Returns an array of previous and current versions of {@code SJGL}.
	 * @return String[] versions
	 */
	public final static String[] getVersions() {
		return versions;
	}
	
}
