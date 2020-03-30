package UrlBuilder;

/**
 * There _has_ to be a better way to do this. This works.
 * This prevents cyclic imports. Why would configuring
 * a "release-level" version number and using that (e.g.
 * `System.getEnv("VERSION")`...).
 */
public class Constant {
    public static final String VERSION = "v0.1.0";
    public static final String LIBRARY = "java";
    public static final String IXLIB = LIBRARY + "-" + VERSION;

    public static final String DEFAULT_DOMAIN = "default.imgix.net";
    public static final String EXAMPLE_DOMAIN = "example.imgix.net";
}
