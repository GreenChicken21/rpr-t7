package ba.unsa.etf.rpr.tutorijal7;

public class Grad {
    private String naziv = new String();
    private int brojStanovnika = 0;
    private double[] temperatura = new double[1000];


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
        return temperatura;
    }

    public void setTemperatura(double[] temperatura) {
        this.temperatura = temperatura;
    }
}
