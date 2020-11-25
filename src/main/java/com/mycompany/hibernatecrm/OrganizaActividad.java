/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hibernatecrm;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author Pablo Martínez y Santiago Ucero.
 */
public class OrganizaActividad {

    Auxiliar aux = new Auxiliar();
    Scanner scan = new Scanner(System.in);

    // Transaction t y Session s y sus setters puestos aquí por comodidad de uso.
    private Transaction t = null;
    private Session s;

    public void setTransaction(Transaction t) {
        this.t = t;
    }

    public void setSession(Session s) {
        this.s = s;
    }

    // Enseña todos las actividades actuales.
    public void showAllActividades(Session s) {

        List<models.Actividad> listaActividades = aux.loadAllData(models.Actividad.class, s);
        System.out.println(" " + listaActividades);
    }

    //Elimina una actividad según id.
    public void deleteActividad(Session s, Transaction t, Integer id) {
        models.Actividad activ = s.get(models.Actividad.class, id);
        Query borrarsql = s.createQuery("DELETE Actividad where id=:id_borrar");
        borrarsql.setParameter("id_borrar", id);
        if (borrarsql.executeUpdate() != 0) {
            System.out.println("¡Actividad eliminada! ¡Bum!");
        } else {
            System.out.println("No se eliminó nada.");
        }
        t.commit();
    }

    //Editar datos de una actividad según id.
    public void editActividad(Session s, Transaction t, Integer id) throws ParseException {

        models.Actividad activ = s.get(models.Actividad.class, id);

        System.out.println("¿A qué oportunidad va asociada esta actividad? (Escriba la id de la oportunidad)");
        Integer id_oportunidad = scan.nextInt();
        models.Oportunidad oport = s.get(models.Oportunidad.class, id_oportunidad);
        activ.setOportunidad(oport);

        System.out.println("Cambiar tipo: ");
        scan.nextLine();
        String tipo = scan.nextLine();
        activ.setTipo(tipo);

        System.out.println("Cambiar descripción: ");
        String descripcion = scan.nextLine();
        activ.setDescripcion(descripcion);

        System.out.println("Introduzca la fecha (yyyy-mm-dd)");
        scan.nextLine();
        String str1 = scan.nextLine();
        SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-mm-dd");
        Date fecha = formatter1.parse(str1);
        activ.setFecha(fecha);

        s.update(activ);
        t.commit();
    }

    // Crea una actividad nueva.
    public void addActividad(Session s, Transaction t) throws ParseException {

        models.Actividad activ = new models.Actividad();

        System.out.println("¿A qué oportunidad va asociada esta actividad? (Escriba la id de la oportunidad)");
        Integer id_oportunidad = scan.nextInt();
        models.Oportunidad oport = s.get(models.Oportunidad.class, id_oportunidad);
        activ.setOportunidad(oport);

        System.out.println("Introducir tipo: ");
        scan.nextLine();
        String tipo = scan.nextLine();
        activ.setTipo(tipo);

        System.out.println("Introducir descripción: ");
        String descripcion = scan.nextLine();
        activ.setDescripcion(descripcion);

        System.out.println("Introduzca la fecha (yyyy-mm-dd)");
        scan.nextLine();
        String str1 = scan.nextLine();
        SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-mm-dd");
        Date fecha = formatter1.parse(str1);
        activ.setFecha(fecha);

        s.save(activ);
        t.commit();

    }

}
