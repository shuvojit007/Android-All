package com.example.shobojit.routinepractise;

import java.util.List;

/**
 * Created by SHOBOJIT on 1/6/2017.
 */

public class JsonFormat {


    /**
     * cse11 : {"SAT":[{"name":"HUM 105","room":"232","tname":"MH","start":"8.30","end":"9.20"},{"name":"HUM 113","room":"224","tname":"HRS","start":"9.20","end":"10.10"},{"name":"CSE 102","room":"C-Lab","tname":"AAA","start":"10.10","end":"11.50"},{"name":"CSE 105","room":"215","tname":"KLH","start":"11.50","end":"12.40"},{"name":"MTH 105","room":"226","tname":"RG","start":"12.40","end":"1.30"}],"SUN":[{"name":"HUM 105","room":"232","tname":"MH","start":"8.30","end":"9.20"},{"name":"CSE 101","room":"224","tname":"AAA","start":"9.20","end":"10.10"},{"name":"PHY 101","room":"210","tname":"SSR","start":"10.10","end":"11.00"},{"name":"CSE 106","room":"C-Lab","tname":"KLH","start":"11.50","end":"1.30"}],"MON":[{"name":"No Class","room":"No Class","tname":"No Class","start":"No Class","end":"No Class"}],"TUE":[{"name":"HUM 105","room":"232","tname":"MH","start":"8.30","end":"9.20"},{"name":"HUM 113","room":"232","tname":"HRS","start":"9.20","end":"10.10"},{"name":"CSE 101","room":"B-lab","tname":"AAA","start":"10.10","end":"11.00"},{"name":"MTH 105","room":"210","tname":"RG","start":"11.00","end":"11.50"},{"name":"CSE 105","room":"215","tname":"KLH","start":"11.50","end":"12.40"}],"WED":[{"name":"HUM 113","room":"232","tname":"HRS","start":"8.30","end":"9.20"},{"name":"CSE 101","room":"210","tname":"AAA","start":"10.10","end":"11.00"},{"name":"MTH 105","room":"210","tname":"RG","start":"11.00","end":"11.50"},{"name":"PHY 101","room":"P-Lab","tname":"SSR","start":"11.50","end":"12.40"},{"name":"CSE 105","room":"226","tname":"KLH","start":"12.40","end":"1.30"}],"THU":[{"name":"PHY 101","room":"210","tname":"SSR","start":"11.00","end":"11.50"}]}
     * cse12 : {"SAT":[{"name":"MTH 107","room":"210","tname":"HSC","start":"8.30","end":"9.20"},{"name":"MTH 107","room":"210","tname":"HSC","start":"9.20","end":"10.10"},{"name":"ECE 101","room":"B-Lab","tname":"FBM","start":"10.10","end":"11.10"},{"name":"CSE 107","room":"208","tname":"AIR","start":"11.50","end":"12.40"}],"SUN":[{"name":"HUM 103","room":"224","tname":"JD","start":"8.30","end":"9.20"}],"MON":[{"name":"PHY 103","room":"210","tname":"SSR","start":"9.20","end":"10.10"},{"name":"PHY 102","room":"P-Lab","tname":"SSR","start":"10.10","end":"11.50"},{"name":"HUM 103","room":"215","tname":"JD","start":"11.50","end":"12.40"},{"name":"ECN 101","room":"215","tname":"HRS","start":"12.40","end":"1.30"}],"TUE":[{"name":"ECE 101","room":"208","tname":"FBM","start":"8.30","end":"9.20"},{"name":"CSE 107","room":"215","tname":"AIR","start":"9.20","end":"10.10"},{"name":"CSE 108","room":"S-Lab","tname":"AIR","start":"10.10","end":"11.50"}],"WED":[{"name":"MTH 107","room":"224","tname":"HSC","start":"8.30","end":"9.20"},{"name":"ECN 101","room":"208","tname":"HRS","start":"9.20","end":"10.10"},{"name":"HUM 103","room":"224","tname":"JS","start":"10.10","end":"11.10"},{"name":"PHY 103","room":"224","tname":"SSR","start":"11.00","end":"11.50"},{"name":"CSE 103","room":"226","tname":"KLH","start":"12.40","end":"1.30"}],"THU":[{"name":"ECE 102","room":"E-Lab","tname":"FBM","start":"8.30","end":"10.10"},{"name":"PHY 103","room":"224","tname":"SSR","start":"10.10","end":"11.00"},{"name":"CSE 107","room":"226","tname":"AIR","start":"11.50","end":"12.40"}]}
     * cse21 : {"SAT":[{"name":"MTH 205","room":"210","tname":"RG","start":"10.10","end":"11.00"},{"name":"CSE 205","room":"226","tname":"RRC","start":"11.50","end":"12.40"}],"SUN":[{"name":"CSE 205","room":"226","tname":"RRC","start":"8.30","end":"9.20"},{"name":"CSE 201","room":"224","tname":"SAC","start":"10.10","end":"11.00"},{"name":"CSE 211","room":"S-Lab","tname":"GMS","start":"11.50","end":"12.40"},{"name":"ECE 201","room":"210","tname":"BH","start":"12.40","end":"1.30"}],"MON":[{"name":"CSE 201","room":"208","tname":"SAC","start":"9.20","end":"10.10"},{"name":"CSE 205","room":"S-Lab","tname":"RRC","start":"10.10","end":"11.00"},{"name":"CSE 212","room":"S-Lab","tname":"GMS","start":"2.00","end":"3.40"}],"TUE":[{"name":"CSE 211","room":"S-Lab","tname":"GMS","start":"9.20","end":"10.10"},{"name":"MTH 205","room":"226","tname":"RG","start":"10.10","end":"11.00"},{"name":"CSE 201","room":"208","tname":"SAC","start":"11.00","end":"11.50"},{"name":"ECE 201","room":"224","tname":"BH","start":"11.50","end":"12.40"},{"name":"ACN 203","room":"208","tname":"CKB","start":"12.40","end":"1.30"}],"WED":[{"name":"CSE 211","room":"215","tname":"GMS","start":"9.20","end":"10.10"},{"name":"ACN 203","room":"208","tname":"CKB","start":"10.10","end":"11.00"},{"name":"ECE 201","room":"208","tname":"BH","start":"11.00","end":"11.50"}],"THU":[{"name":"ACN 203","room":"226","tname":"CKB","start":"9.20","end":"10.10"},{"name":"MTH 205","room":"208","tname":"RG","start":"10.10","end":"11.00"},{"name":"CSE 206","room":"C-Lab","tname":"RRC","start":"11.50","end":"1.30"}]}
     * cse22 : {"SAT":[{"name":"MTH 203","room":"210","tname":"AL","start":"9.20","end":"10.10"},{"name":"MTH 203","room":"208","tname":"AL","start":"10.10","end":"11.00"},{"name":"CSE 207","room":"210","tname":"AIR","start":"11.00","end":"11.50"}],"SUN":[{"name":"CSE 207","room":"210","tname":"AIR","start":"9.20","end":"10.10"},{"name":"CSE 209","room":"208","tname":"GU","start":"11.00","end":"11.50"},{"name":"IMG 201","room":"208","tname":"SY","start":"11.50","end":"12.40"},{"name":"CSE 208","room":"S-Lab","tname":"AIR","start":"12.40","end":"2.50"}],"MON":[{"name":"MTH 203","room":"215","tname":"AL","start":"8.30","end":"9.20"},{"name":"MTH 203","room":"215","tname":"AL","start":"9.20","end":"10.10"},{"name":"CSE 207","room":"215","tname":"AIR","start":"10.10","end":"11.00"},{"name":"IMG 201","room":"210","tname":"SY","start":"11.00","end":"11.50"},{"name":"CSE 231","room":"210","tname":"RKK","start":"11.50","end":"12.40"}],"TUE":[{"name":"CSE 232","room":"E-Lab","tname":"RK","start":"8.30","end":"10.10"},{"name":"CSE 231","room":"P-Lab","tname":"RKK","start":"11.00","end":"11.50"}],"WED":[{"name":"CSE 231","room":"208","tname":"RKK","start":"8.30","end":"9.20"},{"name":"CSE 209","room":"210","tname":"GU","start":"9.20","end":"10.10"},{"name":"CSE 209","room":"210","tname":"GU","start":"10.10","end":"11.00"},{"name":"CSE 200","room":"S-Lab","tname":"GMS","start":"11.00","end":"12.40"}],"THU":[]}
     */

    private Cse11Bean cse11;
    private Cse12Bean cse12;
    private Cse21Bean cse21;
    private Cse22Bean cse22;

    public Cse11Bean getCse11() {
        return cse11;
    }

    public void setCse11(Cse11Bean cse11) {
        this.cse11 = cse11;
    }

    public Cse12Bean getCse12() {
        return cse12;
    }

    public void setCse12(Cse12Bean cse12) {
        this.cse12 = cse12;
    }

    public Cse21Bean getCse21() {
        return cse21;
    }

    public void setCse21(Cse21Bean cse21) {
        this.cse21 = cse21;
    }

    public Cse22Bean getCse22() {
        return cse22;
    }

    public void setCse22(Cse22Bean cse22) {
        this.cse22 = cse22;
    }

    public static class Cse11Bean {
        private List<SATBean> SAT;
        private List<SUNBean> SUN;
        private List<MONBean> MON;
        private List<TUEBean> TUE;
        private List<WEDBean> WED;
        private List<THUBean> THU;

        public List<SATBean> getSAT() {
            return SAT;
        }

        public void setSAT(List<SATBean> SAT) {
            this.SAT = SAT;
        }

        public List<SUNBean> getSUN() {
            return SUN;
        }

        public void setSUN(List<SUNBean> SUN) {
            this.SUN = SUN;
        }

        public List<MONBean> getMON() {
            return MON;
        }

        public void setMON(List<MONBean> MON) {
            this.MON = MON;
        }

        public List<TUEBean> getTUE() {
            return TUE;
        }

        public void setTUE(List<TUEBean> TUE) {
            this.TUE = TUE;
        }

        public List<WEDBean> getWED() {
            return WED;
        }

        public void setWED(List<WEDBean> WED) {
            this.WED = WED;
        }

        public List<THUBean> getTHU() {
            return THU;
        }

        public void setTHU(List<THUBean> THU) {
            this.THU = THU;
        }

        public static class SATBean {
            /**
             * name : HUM 105
             * room : 232
             * tname : MH
             * start : 8.30
             * end : 9.20
             */

            private String name;
            private String room;
            private String tname;
            private String start;
            private String end;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getRoom() {
                return room;
            }

            public void setRoom(String room) {
                this.room = room;
            }

            public String getTname() {
                return tname;
            }

            public void setTname(String tname) {
                this.tname = tname;
            }

            public String getStart() {
                return start;
            }

            public void setStart(String start) {
                this.start = start;
            }

            public String getEnd() {
                return end;
            }

            public void setEnd(String end) {
                this.end = end;
            }
        }

        public static class SUNBean {
            /**
             * name : HUM 105
             * room : 232
             * tname : MH
             * start : 8.30
             * end : 9.20
             */

            private String name;
            private String room;
            private String tname;
            private String start;
            private String end;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getRoom() {
                return room;
            }

            public void setRoom(String room) {
                this.room = room;
            }

            public String getTname() {
                return tname;
            }

            public void setTname(String tname) {
                this.tname = tname;
            }

            public String getStart() {
                return start;
            }

            public void setStart(String start) {
                this.start = start;
            }

            public String getEnd() {
                return end;
            }

            public void setEnd(String end) {
                this.end = end;
            }
        }

        public static class MONBean {
            /**
             * name : No Class
             * room : No Class
             * tname : No Class
             * start : No Class
             * end : No Class
             */

            private String name;
            private String room;
            private String tname;
            private String start;
            private String end;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getRoom() {
                return room;
            }

            public void setRoom(String room) {
                this.room = room;
            }

            public String getTname() {
                return tname;
            }

            public void setTname(String tname) {
                this.tname = tname;
            }

            public String getStart() {
                return start;
            }

            public void setStart(String start) {
                this.start = start;
            }

            public String getEnd() {
                return end;
            }

            public void setEnd(String end) {
                this.end = end;
            }
        }

        public static class TUEBean {
            /**
             * name : HUM 105
             * room : 232
             * tname : MH
             * start : 8.30
             * end : 9.20
             */

            private String name;
            private String room;
            private String tname;
            private String start;
            private String end;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getRoom() {
                return room;
            }

            public void setRoom(String room) {
                this.room = room;
            }

            public String getTname() {
                return tname;
            }

            public void setTname(String tname) {
                this.tname = tname;
            }

            public String getStart() {
                return start;
            }

            public void setStart(String start) {
                this.start = start;
            }

            public String getEnd() {
                return end;
            }

            public void setEnd(String end) {
                this.end = end;
            }
        }

        public static class WEDBean {
            /**
             * name : HUM 113
             * room : 232
             * tname : HRS
             * start : 8.30
             * end : 9.20
             */

            private String name;
            private String room;
            private String tname;
            private String start;
            private String end;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getRoom() {
                return room;
            }

            public void setRoom(String room) {
                this.room = room;
            }

            public String getTname() {
                return tname;
            }

            public void setTname(String tname) {
                this.tname = tname;
            }

            public String getStart() {
                return start;
            }

            public void setStart(String start) {
                this.start = start;
            }

            public String getEnd() {
                return end;
            }

            public void setEnd(String end) {
                this.end = end;
            }
        }

        public static class THUBean {
            /**
             * name : PHY 101
             * room : 210
             * tname : SSR
             * start : 11.00
             * end : 11.50
             */

            private String name;
            private String room;
            private String tname;
            private String start;
            private String end;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getRoom() {
                return room;
            }

            public void setRoom(String room) {
                this.room = room;
            }

            public String getTname() {
                return tname;
            }

            public void setTname(String tname) {
                this.tname = tname;
            }

            public String getStart() {
                return start;
            }

            public void setStart(String start) {
                this.start = start;
            }

            public String getEnd() {
                return end;
            }

            public void setEnd(String end) {
                this.end = end;
            }
        }
    }

    public static class Cse12Bean {
        private List<SATBeanX> SAT;
        private List<SUNBeanX> SUN;
        private List<MONBeanX> MON;
        private List<TUEBeanX> TUE;
        private List<WEDBeanX> WED;
        private List<THUBeanX> THU;

        public List<SATBeanX> getSAT() {
            return SAT;
        }

        public void setSAT(List<SATBeanX> SAT) {
            this.SAT = SAT;
        }

        public List<SUNBeanX> getSUN() {
            return SUN;
        }

        public void setSUN(List<SUNBeanX> SUN) {
            this.SUN = SUN;
        }

        public List<MONBeanX> getMON() {
            return MON;
        }

        public void setMON(List<MONBeanX> MON) {
            this.MON = MON;
        }

        public List<TUEBeanX> getTUE() {
            return TUE;
        }

        public void setTUE(List<TUEBeanX> TUE) {
            this.TUE = TUE;
        }

        public List<WEDBeanX> getWED() {
            return WED;
        }

        public void setWED(List<WEDBeanX> WED) {
            this.WED = WED;
        }

        public List<THUBeanX> getTHU() {
            return THU;
        }

        public void setTHU(List<THUBeanX> THU) {
            this.THU = THU;
        }

        public static class SATBeanX {
            /**
             * name : MTH 107
             * room : 210
             * tname : HSC
             * start : 8.30
             * end : 9.20
             */

            private String name;
            private String room;
            private String tname;
            private String start;
            private String end;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getRoom() {
                return room;
            }

            public void setRoom(String room) {
                this.room = room;
            }

            public String getTname() {
                return tname;
            }

            public void setTname(String tname) {
                this.tname = tname;
            }

            public String getStart() {
                return start;
            }

            public void setStart(String start) {
                this.start = start;
            }

            public String getEnd() {
                return end;
            }

            public void setEnd(String end) {
                this.end = end;
            }
        }

        public static class SUNBeanX {
            /**
             * name : HUM 103
             * room : 224
             * tname : JD
             * start : 8.30
             * end : 9.20
             */

            private String name;
            private String room;
            private String tname;
            private String start;
            private String end;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getRoom() {
                return room;
            }

            public void setRoom(String room) {
                this.room = room;
            }

            public String getTname() {
                return tname;
            }

            public void setTname(String tname) {
                this.tname = tname;
            }

            public String getStart() {
                return start;
            }

            public void setStart(String start) {
                this.start = start;
            }

            public String getEnd() {
                return end;
            }

            public void setEnd(String end) {
                this.end = end;
            }
        }

        public static class MONBeanX {
            /**
             * name : PHY 103
             * room : 210
             * tname : SSR
             * start : 9.20
             * end : 10.10
             */

            private String name;
            private String room;
            private String tname;
            private String start;
            private String end;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getRoom() {
                return room;
            }

            public void setRoom(String room) {
                this.room = room;
            }

            public String getTname() {
                return tname;
            }

            public void setTname(String tname) {
                this.tname = tname;
            }

            public String getStart() {
                return start;
            }

            public void setStart(String start) {
                this.start = start;
            }

            public String getEnd() {
                return end;
            }

            public void setEnd(String end) {
                this.end = end;
            }
        }

        public static class TUEBeanX {
            /**
             * name : ECE 101
             * room : 208
             * tname : FBM
             * start : 8.30
             * end : 9.20
             */

            private String name;
            private String room;
            private String tname;
            private String start;
            private String end;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getRoom() {
                return room;
            }

            public void setRoom(String room) {
                this.room = room;
            }

            public String getTname() {
                return tname;
            }

            public void setTname(String tname) {
                this.tname = tname;
            }

            public String getStart() {
                return start;
            }

            public void setStart(String start) {
                this.start = start;
            }

            public String getEnd() {
                return end;
            }

            public void setEnd(String end) {
                this.end = end;
            }
        }

        public static class WEDBeanX {
            /**
             * name : MTH 107
             * room : 224
             * tname : HSC
             * start : 8.30
             * end : 9.20
             */

            private String name;
            private String room;
            private String tname;
            private String start;
            private String end;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getRoom() {
                return room;
            }

            public void setRoom(String room) {
                this.room = room;
            }

            public String getTname() {
                return tname;
            }

            public void setTname(String tname) {
                this.tname = tname;
            }

            public String getStart() {
                return start;
            }

            public void setStart(String start) {
                this.start = start;
            }

            public String getEnd() {
                return end;
            }

            public void setEnd(String end) {
                this.end = end;
            }
        }

        public static class THUBeanX {
            /**
             * name : ECE 102
             * room : E-Lab
             * tname : FBM
             * start : 8.30
             * end : 10.10
             */

            private String name;
            private String room;
            private String tname;
            private String start;
            private String end;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getRoom() {
                return room;
            }

            public void setRoom(String room) {
                this.room = room;
            }

            public String getTname() {
                return tname;
            }

            public void setTname(String tname) {
                this.tname = tname;
            }

            public String getStart() {
                return start;
            }

            public void setStart(String start) {
                this.start = start;
            }

            public String getEnd() {
                return end;
            }

            public void setEnd(String end) {
                this.end = end;
            }
        }
    }

    public static class Cse21Bean {
        private List<SATBeanXX> SAT;
        private List<SUNBeanXX> SUN;
        private List<MONBeanXX> MON;
        private List<TUEBeanXX> TUE;
        private List<WEDBeanXX> WED;
        private List<THUBeanXX> THU;

        public List<SATBeanXX> getSAT() {
            return SAT;
        }

        public void setSAT(List<SATBeanXX> SAT) {
            this.SAT = SAT;
        }

        public List<SUNBeanXX> getSUN() {
            return SUN;
        }

        public void setSUN(List<SUNBeanXX> SUN) {
            this.SUN = SUN;
        }

        public List<MONBeanXX> getMON() {
            return MON;
        }

        public void setMON(List<MONBeanXX> MON) {
            this.MON = MON;
        }

        public List<TUEBeanXX> getTUE() {
            return TUE;
        }

        public void setTUE(List<TUEBeanXX> TUE) {
            this.TUE = TUE;
        }

        public List<WEDBeanXX> getWED() {
            return WED;
        }

        public void setWED(List<WEDBeanXX> WED) {
            this.WED = WED;
        }

        public List<THUBeanXX> getTHU() {
            return THU;
        }

        public void setTHU(List<THUBeanXX> THU) {
            this.THU = THU;
        }

        public static class SATBeanXX {
            /**
             * name : MTH 205
             * room : 210
             * tname : RG
             * start : 10.10
             * end : 11.00
             */

            private String name;
            private String room;
            private String tname;
            private String start;
            private String end;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getRoom() {
                return room;
            }

            public void setRoom(String room) {
                this.room = room;
            }

            public String getTname() {
                return tname;
            }

            public void setTname(String tname) {
                this.tname = tname;
            }

            public String getStart() {
                return start;
            }

            public void setStart(String start) {
                this.start = start;
            }

            public String getEnd() {
                return end;
            }

            public void setEnd(String end) {
                this.end = end;
            }
        }

        public static class SUNBeanXX {
            /**
             * name : CSE 205
             * room : 226
             * tname : RRC
             * start : 8.30
             * end : 9.20
             */

            private String name;
            private String room;
            private String tname;
            private String start;
            private String end;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getRoom() {
                return room;
            }

            public void setRoom(String room) {
                this.room = room;
            }

            public String getTname() {
                return tname;
            }

            public void setTname(String tname) {
                this.tname = tname;
            }

            public String getStart() {
                return start;
            }

            public void setStart(String start) {
                this.start = start;
            }

            public String getEnd() {
                return end;
            }

            public void setEnd(String end) {
                this.end = end;
            }
        }

        public static class MONBeanXX {
            /**
             * name : CSE 201
             * room : 208
             * tname : SAC
             * start : 9.20
             * end : 10.10
             */

            private String name;
            private String room;
            private String tname;
            private String start;
            private String end;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getRoom() {
                return room;
            }

            public void setRoom(String room) {
                this.room = room;
            }

            public String getTname() {
                return tname;
            }

            public void setTname(String tname) {
                this.tname = tname;
            }

            public String getStart() {
                return start;
            }

            public void setStart(String start) {
                this.start = start;
            }

            public String getEnd() {
                return end;
            }

            public void setEnd(String end) {
                this.end = end;
            }
        }

        public static class TUEBeanXX {
            /**
             * name : CSE 211
             * room : S-Lab
             * tname : GMS
             * start : 9.20
             * end : 10.10
             */

            private String name;
            private String room;
            private String tname;
            private String start;
            private String end;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getRoom() {
                return room;
            }

            public void setRoom(String room) {
                this.room = room;
            }

            public String getTname() {
                return tname;
            }

            public void setTname(String tname) {
                this.tname = tname;
            }

            public String getStart() {
                return start;
            }

            public void setStart(String start) {
                this.start = start;
            }

            public String getEnd() {
                return end;
            }

            public void setEnd(String end) {
                this.end = end;
            }
        }

        public static class WEDBeanXX {
            /**
             * name : CSE 211
             * room : 215
             * tname : GMS
             * start : 9.20
             * end : 10.10
             */

            private String name;
            private String room;
            private String tname;
            private String start;
            private String end;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getRoom() {
                return room;
            }

            public void setRoom(String room) {
                this.room = room;
            }

            public String getTname() {
                return tname;
            }

            public void setTname(String tname) {
                this.tname = tname;
            }

            public String getStart() {
                return start;
            }

            public void setStart(String start) {
                this.start = start;
            }

            public String getEnd() {
                return end;
            }

            public void setEnd(String end) {
                this.end = end;
            }
        }

        public static class THUBeanXX {
            /**
             * name : ACN 203
             * room : 226
             * tname : CKB
             * start : 9.20
             * end : 10.10
             */

            private String name;
            private String room;
            private String tname;
            private String start;
            private String end;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getRoom() {
                return room;
            }

            public void setRoom(String room) {
                this.room = room;
            }

            public String getTname() {
                return tname;
            }

            public void setTname(String tname) {
                this.tname = tname;
            }

            public String getStart() {
                return start;
            }

            public void setStart(String start) {
                this.start = start;
            }

            public String getEnd() {
                return end;
            }

            public void setEnd(String end) {
                this.end = end;
            }
        }
    }

    public static class Cse22Bean {
        private List<SATBeanXXX> SAT;
        private List<SUNBeanXXX> SUN;
        private List<MONBeanXXX> MON;
        private List<TUEBeanXXX> TUE;
        private List<WEDBeanXXX> WED;
        private List<?> THU;

        public List<SATBeanXXX> getSAT() {
            return SAT;
        }

        public void setSAT(List<SATBeanXXX> SAT) {
            this.SAT = SAT;
        }

        public List<SUNBeanXXX> getSUN() {
            return SUN;
        }

        public void setSUN(List<SUNBeanXXX> SUN) {
            this.SUN = SUN;
        }

        public List<MONBeanXXX> getMON() {
            return MON;
        }

        public void setMON(List<MONBeanXXX> MON) {
            this.MON = MON;
        }

        public List<TUEBeanXXX> getTUE() {
            return TUE;
        }

        public void setTUE(List<TUEBeanXXX> TUE) {
            this.TUE = TUE;
        }

        public List<WEDBeanXXX> getWED() {
            return WED;
        }

        public void setWED(List<WEDBeanXXX> WED) {
            this.WED = WED;
        }

        public List<?> getTHU() {
            return THU;
        }

        public void setTHU(List<?> THU) {
            this.THU = THU;
        }

        public static class SATBeanXXX {
            /**
             * name : MTH 203
             * room : 210
             * tname : AL
             * start : 9.20
             * end : 10.10
             */

            private String name;
            private String room;
            private String tname;
            private String start;
            private String end;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getRoom() {
                return room;
            }

            public void setRoom(String room) {
                this.room = room;
            }

            public String getTname() {
                return tname;
            }

            public void setTname(String tname) {
                this.tname = tname;
            }

            public String getStart() {
                return start;
            }

            public void setStart(String start) {
                this.start = start;
            }

            public String getEnd() {
                return end;
            }

            public void setEnd(String end) {
                this.end = end;
            }
        }

        public static class SUNBeanXXX {
            /**
             * name : CSE 207
             * room : 210
             * tname : AIR
             * start : 9.20
             * end : 10.10
             */

            private String name;
            private String room;
            private String tname;
            private String start;
            private String end;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getRoom() {
                return room;
            }

            public void setRoom(String room) {
                this.room = room;
            }

            public String getTname() {
                return tname;
            }

            public void setTname(String tname) {
                this.tname = tname;
            }

            public String getStart() {
                return start;
            }

            public void setStart(String start) {
                this.start = start;
            }

            public String getEnd() {
                return end;
            }

            public void setEnd(String end) {
                this.end = end;
            }
        }

        public static class MONBeanXXX {
            /**
             * name : MTH 203
             * room : 215
             * tname : AL
             * start : 8.30
             * end : 9.20
             */

            private String name;
            private String room;
            private String tname;
            private String start;
            private String end;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getRoom() {
                return room;
            }

            public void setRoom(String room) {
                this.room = room;
            }

            public String getTname() {
                return tname;
            }

            public void setTname(String tname) {
                this.tname = tname;
            }

            public String getStart() {
                return start;
            }

            public void setStart(String start) {
                this.start = start;
            }

            public String getEnd() {
                return end;
            }

            public void setEnd(String end) {
                this.end = end;
            }
        }

        public static class TUEBeanXXX {
            /**
             * name : CSE 232
             * room : E-Lab
             * tname : RK
             * start : 8.30
             * end : 10.10
             */

            private String name;
            private String room;
            private String tname;
            private String start;
            private String end;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getRoom() {
                return room;
            }

            public void setRoom(String room) {
                this.room = room;
            }

            public String getTname() {
                return tname;
            }

            public void setTname(String tname) {
                this.tname = tname;
            }

            public String getStart() {
                return start;
            }

            public void setStart(String start) {
                this.start = start;
            }

            public String getEnd() {
                return end;
            }

            public void setEnd(String end) {
                this.end = end;
            }
        }

        public static class WEDBeanXXX {
            /**
             * name : CSE 231
             * room : 208
             * tname : RKK
             * start : 8.30
             * end : 9.20
             */

            private String name;
            private String room;
            private String tname;
            private String start;
            private String end;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getRoom() {
                return room;
            }

            public void setRoom(String room) {
                this.room = room;
            }

            public String getTname() {
                return tname;
            }

            public void setTname(String tname) {
                this.tname = tname;
            }

            public String getStart() {
                return start;
            }

            public void setStart(String start) {
                this.start = start;
            }

            public String getEnd() {
                return end;
            }

            public void setEnd(String end) {
                this.end = end;
            }
        }
    }
}
