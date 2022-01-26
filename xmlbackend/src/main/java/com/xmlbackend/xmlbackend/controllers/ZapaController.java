package com.xmlbackend.xmlbackend.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.xmlbackend.xmlbackend.models.Zapa;
import com.xmlbackend.xmlbackend.models.ZapasArray;
import com.xmlbackend.xmlbackend.services.IZapaImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.xml.bind.JAXBException;

@CrossOrigin(origins = "http://localhost:4200")
@RestController

public class ZapaController {
   @Autowired
   IZapaImpl iZapaService;

   @GetMapping("/")
   ZapasArray getAll() throws JAXBException {
       return iZapaService.getAll();
   }


    @PostMapping(value = "/", consumes = "application/json")
    @ResponseBody
    Zapa add(@RequestBody String zapa) {
        System.out.println(zapa);
        ObjectMapper om = new ObjectMapper();


        try {
           Zapa createdZapa = om.readValue(zapa, Zapa.class);
            iZapaService.addOne(createdZapa);
            return createdZapa;
        } catch (JsonMappingException e) {

            e.printStackTrace();
            return null;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        } catch (JAXBException e) {	
            e.printStackTrace();
            return null;
        }

    }

    @PutMapping(value = "/{id}", consumes = "application/json")
    @ResponseBody
    int update(@RequestBody String stringZapa, @PathVariable int id) {
        ObjectMapper om = new ObjectMapper();
        Zapa newZapa=new Zapa();
        try {
            newZapa = om.readValue(stringZapa, Zapa.class);
            return iZapaService.update(newZapa, id);
        } catch (JsonMappingException e) {

            e.printStackTrace();
        } catch (JsonProcessingException | JAXBException e) {

            e.printStackTrace();
        }
        return 0;
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    Integer delete(@PathVariable("id") int id) throws JAXBException {
        return iZapaService.delete(id);
    }

}
