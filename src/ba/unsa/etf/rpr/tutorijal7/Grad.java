package ba.unsa.etf.rpr.tutorijal7;

import java.util.Arrays;

public class Grad {
    private String naziv = "";
    private int brojStanovnika = 0;
    private double[] temperatura = new double[1000];

    public Grad(){}
    public Grad(String naziv, int brojStanovnika, double [] temperatura){
        setNaziv(naziv);
        setBrojStanovnika(brojStanovnika);
        setTemperatura(temperatura);
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getBrojStanovnika() {
        return brojStanovnika;
    }

    public void setBrojStanovnika(int brojStanovnika) {
        this.brojStanovnika = brojStanovnika;
    }

    public double[] getTemperatura() {
        return Arrays.copyOf(temperatura,temperatura.length);
    }


    public void setTemperatura(double[] temperatura) {
        this.temperatura = temperatura;
    }


    @Override
    public String toString(){
        String s = getNaziv();
        s+=",";
        for(int i=0; i<temperatura.length;i++){
            s+=temperatura[i];
            if(i!=temperatura.length-1) s+=",";
        }
        return s;
    }

}
