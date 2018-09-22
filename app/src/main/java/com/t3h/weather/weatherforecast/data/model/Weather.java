package com.t3h.weather.weatherforecast.data.model;

public class Weather {
    private String nhietDo;
    private String icon;
    private String diaDiem;
    private String tocDoGio;
    private String doAm;
    private int may;
    private long giobinhMinh;
    private long gioHoangHon;

    public Weather() {

    }

    public Weather(String nhietDo, String icon, String diaDiem, String tocDoGio, String doAm, int may, long giobinhMinh, long gioHoangHon) {
        this.nhietDo = nhietDo;
        this.icon = icon;
        this.diaDiem = diaDiem;
        this.tocDoGio = tocDoGio;
        this.doAm = doAm;
        this.may = may;
        this.giobinhMinh = giobinhMinh;
        this.gioHoangHon = gioHoangHon;
    }

    public String getNhietDo() {
        return nhietDo;
    }

    public void setNhietDo(String nhietDo) {
        this.nhietDo = nhietDo;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getDiaDiem() {
        return diaDiem;
    }

    public void setDiaDiem(String diaDiem) {
        this.diaDiem = diaDiem;
    }

    public String getTocDoGio() {
        return tocDoGio;
    }

    public void setTocDoGio(String tocDoGio) {
        this.tocDoGio = tocDoGio;
    }

    public String getDoAm() {
        return doAm;
    }

    public void setDoAm(String doAm) {
        this.doAm = doAm;
    }

    public int getMay() {
        return may;
    }

    public long getGiobinhMinh() {
        return giobinhMinh;
    }

    public long getGioHoangHon() {
        return gioHoangHon;
    }
}
