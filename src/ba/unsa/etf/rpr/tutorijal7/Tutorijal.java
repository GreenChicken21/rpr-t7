package ba.unsa.etf.rpr.tutorijal7;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Tutorijal {
    // izdvaja naziv grada
    public static String izdvojiString(String s){
        String pov = "";
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == ',')return pov;
            pov += s.charAt(i);
        }
        return pov;
    }
    // izdvaja temperature u niz
    private static ArrayList<Integer> izdvojiNiz(String linija) {
        ArrayList<Integer> pov = new ArrayList<>();
        Scanner brojevi = new Scanner(linija);
        while(brojevi.hasNext()){
            pov.add(brojevi.nextInt());
        }
        return pov;
    }


    public static ArrayList<Grad> dodajGradove(){

        Scanner ulaz = null;
        try{
            ulaz = new Scanner(new FileReader("mjerenja.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("Datoteka ulaz.txt ne postoji ili se ne može otvoriti");
            return null;
        }


        ArrayList<Grad> gradovi = new ArrayList<>();
        int brojac = 0;
        while(ulaz.hasNextLine()){

            gradovi.add(new Grad());
            String linija = ulaz.nextLine();

            gradovi.get(brojac).setNaziv(izdvojiString(linija));

            ArrayList<Integer> temp = izdvojiNiz(linija);
            for(int i=0; i<temp.size();i++)
                gradovi.get(brojac).setTemperatura(temp.get(i));

            brojac++;
        }
        return gradovi;
    }



    public static void main(String[] args) {
        ArrayList<Grad> gradovi = new ArrayList<>(dodajGradove());
        System.out.println(gradovi.get(0).getNaziv());
    }
}
