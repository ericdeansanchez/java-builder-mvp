/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package UrlBuilder;

import static UrlBuilder.Constant.*;
import static UrlBuilder.Library.*;
import static UrlBuilder.Url.*;

import org.junit.Test;

import java.util.ArrayList;

import static UrlBuilder.Url.Scheme.HTTPS;
import static org.junit.Assert.*;

public class LibraryTest {

  @Test
  public void testLibrary() {
    assert (Library.isTrue());
  }

  /* ****** Integration Tests ****** */
  @Test
  public void testBasicUrl() {
    // Construct the query parameters.
    ArrayList<Param> queryParams = new ArrayList<>();
    queryParams.add(new Param("w", 320));
    queryParams.add(new Param("h", 640));
    queryParams.add(new Param("fit", "crop"));

    // Build and configure the `Url`.
    Url u =
        new Url.Builder()
            .scheme(HTTPS)
            .domain("example.imgix.net")
            .path("/images/file.png")
            .params(queryParams)
            .token("secret")
            .build();

    // TODO: remove, this is for debug purposes.
    System.out.println(u.repr());

    assertEquals(HTTPS.toString(), u.getScheme());
    assertEquals("example.imgix.net", u.getDomain());
    assertEquals("/images/file.png", u.getPath());
    assertEquals(IXLIB, u.getLib());
  }

  /* ****** Unit Tests ****** */
  @Test
  public void testHttpsByDefault() {
    // Test scheme is https by default.
    Url u = new Url.Builder().build();
    assertEquals(HTTPS.toString(), u.getScheme());
  }

  @Test
  public void testEmptyDefaultParams() {
    // Test default parameters have been initialized
    // to an empty parameter list.
    Url u = new Url.Builder().build();
    assertTrue(u.getParams().isEmpty());
  }

  @Test
  public void testDomainInitialization() {
    // Test default domain has been initialized and is
    // _the_ `DEFAULT_DOMAIN`.
    Domain d = new Domain.Builder().build();
    assertEquals(DEFAULT_DOMAIN, d.getDomain());
  }

  @Test
  public void testBuilderConstructedDomain() {
    // Test `Domain` is constructed with custom domain when the
    // supplied domain-string is passed to the builder.
    Domain d = new Domain.Builder().domain("example.imgix.net").build();
    assertEquals(EXAMPLE_DOMAIN, d.getDomain());
  }

  @Test
  public void testDefaultConstructedDomain() {
    // Test `Domain` is constructed with custom domain when
    // the domain-string is passed to the constructor.
    Domain d = new Domain(EXAMPLE_DOMAIN);
    System.out.println(d.getDomain());
    assertEquals(EXAMPLE_DOMAIN, d.getDomain());
  }

  @Test
  public void testDefaultDomainIsValid() {
    // Test `Domain` constructed with the default domain represents
    // a valid domain name.
    Domain d = new Domain(DEFAULT_DOMAIN);
    assert(d.isValid());
  }

  @Test
  public void testDefaultDomainChainsWhenIsValid() {
    // Test `Domain` constructed with valid domain-strings properly
    // "chains."
    Domain d = new Domain(DEFAULT_DOMAIN).validate();
    assertEquals(DEFAULT_DOMAIN, d.getDomain());
    assert(d.isValid());
  }
}
