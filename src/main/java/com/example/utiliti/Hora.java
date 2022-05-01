package com.example.utiliti;

import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Slf4j
public class Hora {

//    public void horaDeHoy(){
//        SimpleDateFormat simpleDateFormat= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Date date = new Date();
//        simpleDateFormat.format(date);
//        System.out.println("HORA ES: "+date);
//    }

    public void horaDeHoyJava8(){
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        System.out.println("HORA ES: "+dateTime.format(formatter));
    }

    public static void main(String[] args){
        log.info("Starting {}.{} method", "main", "horaDeHoy");
        Hora hora = new Hora();
        hora.horaDeHoyJava8();
    }
}
