package com.xmlbackend.xmlbackend.services;

import com.xmlbackend.xmlbackend.models.Zapa;
import com.xmlbackend.xmlbackend.models.ZapasArray;

import javax.xml.bind.JAXBException;


import java.util.List;


public interface IZapa {
    ZapasArray getAll() throws JAXBException;
    Zapa addOne(Zapa zapa) throws JAXBException;
    int update(Zapa zapa, int id) throws JAXBException;
    int delete(int id) throws JAXBException;
}
