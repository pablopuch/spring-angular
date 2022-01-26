package com.xmlbackend.xmlbackend.models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ZapasArray {
    List<Zapa> zapas = new ArrayList<>();

    public ZapasArray() {
    }

    public List<Zapa> getZapas() {
        return zapas;
    }

    public void setZapas(List<Zapa> zapas) {
        this.zapas = zapas;
    }

    public void addZapa(Zapa zapa) {
        this.zapas.add(zapa);
    }
    public int getLenght() {
        return this.zapas.size();
    }
    public Zapa getZapaById(int id){
        int expectedZapaIndex = 0;
        for(Zapa zapa : zapas){
            if (zapa.getId()==id) {
                expectedZapaIndex=zapas.indexOf(zapa);
            }
        }
        if(expectedZapaIndex!=0){
            return zapas.get(expectedZapaIndex);
        }else{
            return null;
        }

}
    public int deleteZapaById(int id){
        int expectedZapaIndex = 0;
        for(Zapa zapa : zapas){
            if (zapa.getId()==id) {
                expectedZapaIndex=zapas.indexOf(zapa);
            }
        }
        if(expectedZapaIndex!=0){
            zapas.remove(expectedZapaIndex);
            return 1;
        }else{
            return 0;
        }
    }
    public int updateZapa(Zapa zapa, int id){
        Zapa oldZapa = this.getZapaById(id);
        this.deleteZapaById(id);
        this.zapas.add(zapa);
        return 1;
    }

    public void sort() {
        Collections.sort(zapas, new Sortbyroll());
    }


    public Zapa getZapa(int i) {
        return zapas.get(i);
    }
    public void unshift() {
        zapas.remove(0);
    }
}
class Sortbyroll implements Comparator<Zapa>
{
    // Used for sorting in ascending order of
    // roll number
    public int compare(Zapa a, Zapa b)
    {
        return a.id - b.id;
    }
}
