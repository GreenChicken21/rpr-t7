package ba.unsa.etf.rpr.tutorijal7;

import org.w3c.dom.Element;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.beans.XMLEncoder;
import java.io.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Tutorijal {
    // metoda napravljena takva da radi sa bilo kojom .txt datotekom
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
            // izdvajanje linije datoteke i slitanje
            String linija = ulaz.nextLine();
            // ako se slucajno nalazi prazan red u datoteci ili makar jedan znak u redu preskace
            if(linija.length() <= 1)continue;
            String []parts = linija.split(",");
            gradovi.add(new Grad());
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
    public static UN ucitajXml(String fileName, ArrayList<Grad> gradovi){

        UN un = new UN();

        Document xmldoc = null;
        try {
            DocumentBuilder docReader = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            xmldoc = docReader.parse(new File("drzave.xml"));
        }
        catch (Exception e) {
            System.out.println("drzave.xml nije validan XML dokument");
            return null;
        }
        ArrayList<Drzava> drzave = new ArrayList<>();

        NodeList drzaveXml = xmldoc.getElementsByTagName("drzava");

        for(int i = 0; i < drzaveXml.getLength(); i++) {
            Node drzavaNode = drzaveXml.item(i);

            if(drzavaNode instanceof Element) {
                Element drzavaEl = (Element)drzavaNode;

                int stanovnika = Integer.parseInt(drzavaEl.getAttribute("stanovnika"));
                String naziv = drzavaEl.getElementsByTagName("naziv").item(0).getTextContent();

                Element gGradXml = (Element)drzavaEl.getElementsByTagName("glavnigrad").item(0);
                int gStanovnika = Integer.parseInt(gGradXml.getAttribute("stanovnika"));
                String nazivGrada = gGradXml.getTextContent().trim();

                Element povrsinaXml = (Element)drzavaEl.getElementsByTagName("povrsina").item(0);
                String jedinica = povrsinaXml.getAttribute("jedinica");
                double povrsina = Double.parseDouble(drzavaEl.getElementsByTagName("povrsina").item(0).getTextContent());

                Grad glavniGrad = new Grad(nazivGrada, gStanovnika, null);
                drzave.add(new Drzava(naziv, stanovnika, povrsina, jedinica, glavniGrad));
            }
        }

        un.setListaDrzava(drzave);
        return un;

    }


    public static void zapisiXml(UN un) {
        try {
            XMLEncoder e = new XMLEncoder(new BufferedOutputStream(new FileOutputStream("un.xml")));
            e.writeObject(un);
            e.close();
        } catch(Exception e) {
            System.out.println("Greška: " + e);
        }
    }
    public static void main(String[] args) {
        ArrayList<Grad> gradovi = new ArrayList<>(ucitajGradove("mjerenja.txt"));
        for (Grad grad:gradovi)
            System.out.println(grad);
        UN un = ucitajXml("drzave.xml", gradovi);

        zapisiXml(un);
    }
}
