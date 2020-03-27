package UrlBuilder;

import java.util.ArrayList;

import static UrlBuilder.Url.Scheme.*;
import static UrlBuilder.Constant.IXLIB;
import static UrlBuilder.Validator.validate;

/**
 *
 */
public class Url {
    private Scheme scheme;
    private String domain;
    private String path;
    private ArrayList<Param> params;
    private String token;
    private boolean lib;

    /**
     *
     */
    public static class Builder {
        // Default values.
        private static final String EMPTY = "";
        // Set https by default.
        private Scheme scheme = HTTPS;
        private String domain = "example.imgix.net";
        private String path = EMPTY;
        private ArrayList<Param> params = new ArrayList<>();
        private String token = EMPTY;
        private boolean lib = true;

        public Builder() {}

        /**
         *
         * @param s
         * @return
         */
        public Builder scheme(Scheme s) {
            this.scheme = s;
            return this;
        }

        /**
         *
         * @param d
         * @return
         */
        public Builder domain(String d) {
            validate(d);
            this.domain = d;
            return this;
        }

        /**
         *
         * @param l
         * @return
         */
        public Builder lib(boolean l) {
            this.lib = l;
            return this;
        }

        /**
         *
         * @param p
         * @return
         */
        public Builder path(String p) {
            this.path = p;
            return this;
        }

        /**
         *
         * @param p
         * @return
         */
        public Builder params(ArrayList<Param> p) {
            this.params = p;
            return this;
        }

        /**
         *
         * @param t
         * @return
         */
        public Builder token(String t) {
            this.token = t;
            return this;
        }

        /**
         *
         * @return
         */
        public Url build() {
            return new Url(this);
        }
    }

    /**
     *
     * @param builder
     */
    private Url(Builder builder) {
        scheme = builder.scheme;
        domain = builder.domain;
        path = builder.path;
        params = builder.params;
        token = builder.token;
        lib = builder.lib;
    }


    /**
     *
     * @return
     */
    public String getScheme() {
        return this.scheme.toString();
    }

    /**
     *
     * @return
     */
    public String getDomain() {
        return this.domain;
    }

    /**
     *
     * @return
     */
    public String getPath() {
        return this.path;
    }

    /**
     *
     * @return
     */
    public String getToken() {
        return this.token;
    }


    /**
     *
     * @return
     */
    public ArrayList<Param> getParams() {
        return this.params;
    }

    /**
     *
     * @return
     */
    public String getLib() {
        return IXLIB;
    }

    /**
     *
     * @return
     */
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

    /**
     *
     * @return
     */
    private String paramRepr() {
        String paramRepr = "[ ";
        if (this.params.isEmpty()) {
            return paramRepr + "... ]";
        }

        if (this.params.size() == 1) {
            Param p = this.params.get(0);
            return paramRepr + p.toString() + " ]";
        }

        Param first = this.params.get(0);
        Param last = this.params.get(this.params.size() - 1);
        paramRepr += first.toString() + ", ..., " + last.toString();
        return paramRepr + " ]";
    }

    /**
     *
     */
    public enum Scheme {
        HTTPS,
        HTTP,
    };
}

