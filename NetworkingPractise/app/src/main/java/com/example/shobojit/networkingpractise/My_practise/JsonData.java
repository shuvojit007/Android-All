package com.example.shobojit.networkingpractise.My_practise;

import java.util.List;

/**
 * Created by SHOBOJIT on 12/30/2016.
 */

public class JsonData {


    private List<CseBean> cse;
    private List<EseBean> ese;

    public List<CseBean> getCse() {
        return cse;
    }

    public void setCse(List<CseBean> cse) {
        this.cse = cse;
    }

    public List<EseBean> getEse() {
        return ese;
    }

    public void setEse(List<EseBean> ese) {
        this.ese = ese;
    }

    public static class CseBean {
        /**
         * name : cse-101
         */

        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static class EseBean {
        /**
         * name : ese-101
         */

        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}