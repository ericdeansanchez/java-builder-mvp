package com.company;

import java.util.Map;
import com.company.Url.*;
import com.company.Param;

import java.util.ArrayList;

/** */
public class Main {
  public static void main(String[] args) {

    Map<String, String> env = System.getenv();
    for (String envName : env.keySet()) {
      System.out.format("%s=%s%n", envName, env.get(envName));
    }

    Param w = new Param("w", 320);
    Param h = new Param("h", 640);
    ArrayList<Param> queryParams = new ArrayList<>();
    queryParams.add(w);
    queryParams.add(h);

    Url url =
        new Url.Builder()
            .domain("example.imgix.com")
            .scheme(Scheme.HTTPS)
            .path("/images/file.png")
            .params(queryParams)
            .token("secret")
            .lib(true)
            .build();

    System.out.println(url.repr());
  }
}
