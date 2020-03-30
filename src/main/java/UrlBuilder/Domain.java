package UrlBuilder;

import static UrlBuilder.Constant.DEFAULT_DOMAIN;

public class Domain {
    private String domain;

    public static class Builder {
        private String domain = DEFAULT_DOMAIN;
        /**
         *
         * @param d
         * @return
         */
        public Builder domain(String d) {
            this.domain = d;
            return this;
        }

        /**
         *
         * @return
         */
        public Domain build() {
            return new Domain(this);
        }
    }

    /**
     *
     * @param builder
     */
    private Domain(Builder builder) {
        domain = builder.domain;
    }

    public Domain(String d) {
        domain = d;
    }

    public String getDomain() {
        return this.domain;
    }

    public Domain validate() {
        if (!this.isValid()) {
            System.out.println("ERROR! INVALID DOMAIN");
            // TODO: determine how to error on invalid domain names,
            // the program should stop immediately.
            return this;
        }
        return this;
    }

    public boolean isValid() {
        return false;
    }
}
