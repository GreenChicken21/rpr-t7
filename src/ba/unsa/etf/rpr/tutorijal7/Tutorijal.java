package ba.unsa.etf.rpr.tutorijal7;

import org.w3c.dom.Element;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Tutorijal {
   /* // izdvaja naziv grada
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
    }*/


    public static ArrayList<Grad> ucitajGradove(String fileName){

        Scanner ulaz = null;
        try{
            ulaz = new Scanner(new FileReader(fileName));
        } catch (FileNotFoundException e) {
            System.out.println("Datoteka ulaz.txt ne postoji ili se ne može otvoriti");
            return null;
        }

        ArrayList<Grad> gradovi = new ArrayList<>();
        while(ulaz.hasNextLine()){
            // alociranje novog grada
            gradovi.add(new Grad());
            // izdvajanje linije datoteke i slitanje
            String linija = ulaz.nextLine();
            String []parts = linija.split(",");
            // postavljanje naziva
            gradovi.get(gradovi.size()-1).setNaziv(parts[0]);
            // izdvajanje temperatura i postavljanje u grad
            double niz[] = new double[parts.length-1];
            for(int i = 1; i < parts.length && i < 1000; i++)
                niz[i-1] = Double.parseDouble(parts[i]);
            gradovi.get(gradovi.size()-1).setTemperatura(niz);
        }
        return gradovi;
    }

    public static UN ucitajXml(String fileName){

        UN un = new UN();

        Document xmldoc = null;
        try {
            DocumentBuilder docReader
                    = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            xmldoc = docReader.parse(new File("drzave.xml"));
        }
        catch (Exception e) {
            System.out.println("drzave.xml nije validan XML dokument");
            return null;
        }

        Element korijen = xmldoc.getDocumentElement();
        

        return un;
    }

    public static void main(String[] args) {
        ArrayList<Grad> gradovi = new ArrayList<>(ucitajGradove("mjerenja.txt"));
        System.out.println(gradovi.get(0));
        System.out.println(gradovi.get(1));
    }
}
