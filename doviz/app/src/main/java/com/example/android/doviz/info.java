package com.example.android.doviz;

public class info {


    /**
     * success : true
     * timestamp : 1526506027
     * base : EUR
     * date : 2018-05-16
     * rates : {"USD":1.181475,"TRY":5.213381,"GBP":0.874504}
     */

    private boolean success;
    private int timestamp;
    private String base;
    private String date;
    private RatesBean rates;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public RatesBean getRates() {
        return rates;
    }

    public void setRates(RatesBean rates) {
        this.rates = rates;
    }

    public static class RatesBean {
        /**
         * USD : 1.181475
         * TRY : 5.213381
         * GBP : 0.874504
         */

        private double USD;
        private double TRY;
        private double GBP;

        public double getUSD() {
            return USD;
        }

        public void setUSD(double USD) {
            this.USD = USD;
        }

        public double getTRY() {
            return TRY;
        }

        public void setTRY(double TRY) {
            this.TRY = TRY;
        }

        public double getGBP() {
            return GBP;
        }

        public void setGBP(double GBP) {
            this.GBP = GBP;
        }
    }
}
