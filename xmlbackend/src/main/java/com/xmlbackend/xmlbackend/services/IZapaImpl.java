package com.xmlbackend.xmlbackend.services;

import com.xmlbackend.xmlbackend.models.Zapa;
import com.xmlbackend.xmlbackend.models.ZapasArray;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class IZapaImpl implements IZapa {
    String XmlFileName="zapa.xml";
    @Override
    public ZapasArray getAll() throws JAXBException {

        JAXBContext context= JAXBContext.newInstance(ZapasArray.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();

       ZapasArray zapas = (ZapasArray) unmarshaller.unmarshal(new File(XmlFileName));

        return zapas;
    }

    @Override
    public Zapa addOne(Zapa zapa) throws JAXBException {
        JAXBContext context= JAXBContext.newInstance(ZapasArray.class);
        Marshaller marshaller = context.createMarshaller();
       Unmarshaller unmarshaller = context.createUnmarshaller();
        ZapasArray zapas = (ZapasArray) unmarshaller.unmarshal(new File(XmlFileName));

           if(!(zapas.getLenght()>1)){
               zapa.setId(1);
            }else{
               zapas.sort();	
                zapa.setId((zapas.getZapa(((zapas.getLenght())-1)).id)+1);
            }
            zapas.addZapa(zapa);
            marshaller.marshal(zapas,new File(this.XmlFileName));
            return  zapa;
    }

    @Override
    public int update(Zapa newZapa, int id) throws JAXBException {
        JAXBContext context= JAXBContext.newInstance(ZapasArray.class);
        Marshaller marshaller = context.createMarshaller();
        Unmarshaller unmarshaller = context.createUnmarshaller();
        ZapasArray zapas = (ZapasArray) unmarshaller.unmarshal(new File(XmlFileName));
        zapas.updateZapa(newZapa, id);
        marshaller.marshal(zapas,new File(this.XmlFileName));
        return 1;
    }

    @Override
    public int delete(int id) throws JAXBException {
        JAXBContext context= JAXBContext.newInstance(ZapasArray.class);
        Marshaller marshaller = context.createMarshaller();
        Unmarshaller unmarshaller = context.createUnmarshaller();
        ZapasArray zapas = (ZapasArray) unmarshaller.unmarshal(new File(XmlFileName));
        if(!(zapas.getLenght()>0)){
            return 0;
        }
       else{
            zapas.deleteZapaById(id);
            marshaller.marshal(zapas, new File(XmlFileName));
            return 1;
        }
    }
}
