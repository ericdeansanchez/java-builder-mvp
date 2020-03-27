package com.company;

import com.company.Param;
import java.util.ArrayList;

public class Url {
    private Scheme scheme = Scheme.HTTPS;
    private String domain;
    private String path;
    private ArrayList<Param> params;
    private String token;
    private boolean lib;

    public static class Builder {
        private Scheme scheme;
        private String domain;
        private String path;
        private ArrayList<Param> params;
        private String token;
        private boolean lib;

        public Builder() {}

        public Builder scheme(Scheme s) {
            this.scheme = s; return this;
        }

        public Builder domain(String d) {
            this.domain = d;
            return this;
        }

        public Builder lib(boolean l) {
            this.lib = l;
            return this;
        }

        public Builder path(String p) {
            this.path = p;
            return this;
        }

        public Builder params(ArrayList<Param> p) {
            this.params = p;
            return this;
        }

        public Builder token(String t) {
            this.token = t;
            return this;
        }

        public Url build() {
            return new Url(this);
        }
    }

    private Url(Builder builder) {
        scheme = builder.scheme;
        domain = builder.domain;
        path = builder.path;
        params = builder.params;
        token = builder.token;
        lib = builder.lib;
    }


    public String repr() {
        String scheme = this.scheme.toString();
        String domain = this.domain;
        String path = this.path;
        String params = this.paramRepr();
        String token = this.token;
        String lib = this.lib ? "TEST" : "TEST";
        return  "" +
                "scheme: " + scheme + "\n" +
                "domain: " + domain + "\n" +
                "path:   " + path + "\n" +
                "params: " + params + "\n" +
                "token:  " + token + "\n" +
                "lib:    " + lib + "\n";
    }

    private String paramRepr() {
        String paramRepr = "[ ";
        if (this.params.isEmpty()) {
            return paramRepr + " ]";
        }

        if (this.params.size() == 1) {
            Param p = this.params.get(0);
            return paramRepr + p.toString() + " ]";
        }

        Param first = this.params.get(0);
        Param last = this.params.get(this.params.size() - 1);
        paramRepr += first.toString() + ", " + last.toString();
        return paramRepr + " ]";
    }

    public enum Scheme {
        HTTPS,
        HTTP,
    };
}