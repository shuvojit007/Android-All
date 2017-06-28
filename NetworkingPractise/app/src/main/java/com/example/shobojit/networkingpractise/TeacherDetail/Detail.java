package com.example.shobojit.networkingpractise.TeacherDetail;

import java.util.List;

/**
 * Created by SHOBOJIT on 1/2/2017.
 */

public class Detail {

    private List<CseBean> cse;
    private List<EceBean> ece;

    public List<CseBean> getCse() {
        return cse;
    }

    public void setCse(List<CseBean> cse) {
        this.cse = cse;
    }

    public List<EceBean> getEce() {
        return ece;
    }

    public void setEce(List<EceBean> ece) {
        this.ece = ece;
    }

    public static class CseBean {
        /**
         * name : Prof. Rishi Kesh Ghose
         * designation : Dean & Head
         * mob : 01715357237
         * image : http://siu.edu.bd/wp-content/uploads/2015/10/rishi-kesh-sir-263x229.jpg
         */

        private String name;
        private String designation;
        private String mob;
        private String image;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDesignation() {
            return designation;
        }

        public void setDesignation(String designation) {
            this.designation = designation;
        }

        public String getMob() {
            return mob;
        }

        public void setMob(String mob) {
            this.mob = mob;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }
    }

    public static class EceBean {
        /**
         * name : Prof. Rishi Kesh Ghose
         * designation : Dean
         * mob : 01715357237
         * image : http://siu.edu.bd/wp-content/uploads/2015/10/rishi-kesh-sir-263x229.jpg
         */

        private String name;
        private String designation;
        private String mob;
        private String image;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDesignation() {
            return designation;
        }

        public void setDesignation(String designation) {
            this.designation = designation;
        }

        public String getMob() {
            return mob;
        }

        public void setMob(String mob) {
            this.mob = mob;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }
    }
}
