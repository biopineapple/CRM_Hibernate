/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hibernatecrm;

import java.util.Date;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author Pablo Martínez y Santiago Ucero.
 */
public class OrganizaOportunidad {

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

    // Enseña todos las oportunidades actuales.
    public void showAllOportunidades(Session s) {

        List<models.Oportunidad> listaOportunidades = aux.loadAllData(models.Oportunidad.class, s);
        System.out.println(" " + listaOportunidades);
    }

    //Elimina una oportunidad según id.
    public void deleteOportunidad(Session s, Transaction t, Integer id) {
        models.Oportunidad oport = s.get(models.Oportunidad.class, id);
        Query borrarsql = s.createQuery("DELETE Oportunidad where id=:id_borrar");
        borrarsql.setParameter("id_borrar", id);
        if (borrarsql.executeUpdate() != 0) {
            System.out.println("¡Oportunidad eliminada! ¡Bum!");
        } else {
            System.out.println("No se eliminó nada.");
        }
        t.commit();
    }

    //Editar datos de una oportunidad según id.
    public void editOportunidad(Session s, Transaction t, Integer id) throws ParseException {

        models.Oportunidad oport = s.get(models.Oportunidad.class, id);

        System.out.println("¿A qué cliente va asociada esta oportunidad? (Escriba la id del cliente)");
        Integer id_cliente = scan.nextInt();
        models.Cliente client = s.get(models.Cliente.class, id_cliente);
        oport.setCliente(client); 
        
        System.out.println("Cambiar descripcion: ");
        scan.nextLine();
        String descripcion = scan.nextLine();
        oport.setDescripcion(descripcion);

        System.out.println("Cambiar valor: ");
        BigDecimal valor = scan.nextBigDecimal();
        oport.setValor(valor);

        System.out.println("Introduzca la fecha (yyyy-mm-dd)");
        scan.nextLine();
        String str1 = scan.nextLine();
        SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-mm-dd");
        Date fecha = formatter1.parse(str1);
        oport.setFecha(fecha);

        System.out.println("Cambiar nivel: ");
        String nivel = scan.nextLine();
        oport.setNivel(nivel);

        System.out.println("Cambiar estado: ");
        String estado = scan.nextLine();
        oport.setEstado(estado);

        s.update(oport);
        t.commit();
    }

    // Crea una oportunidad nueva.
    public void addOportunidad(Session s, Transaction t) throws ParseException {

        models.Oportunidad oport = new models.Oportunidad();

        System.out.println("¿A qué cliente va asociada esta oportunidad? (Escriba la id del cliente)");
        Integer id_cliente = scan.nextInt();
        models.Cliente client = s.get(models.Cliente.class, id_cliente);
        oport.setCliente(client);        
        
        System.out.println("Introducir descripcion: ");
        scan.nextLine();
        String descripcion = scan.nextLine();
        oport.setDescripcion(descripcion);

        System.out.println("Introducir valor: ");
        BigDecimal valor = scan.nextBigDecimal();
        oport.setValor(valor);

        System.out.println("Introduzca la fecha (yyyy-mm-dd)");
        scan.nextLine();
        String str1 = scan.nextLine();
        SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-mm-dd");
        Date fecha = formatter1.parse(str1);
        oport.setFecha(fecha);

        System.out.println("Introducir nivel: ");
        String nivel = scan.nextLine();
        oport.setNivel(nivel);

        System.out.println("Introducir estado: ");
        String estado = scan.nextLine();
        oport.setEstado(estado);

        s.save(oport);
        t.commit();
    }

    /*
    //Retroceder/avanzar EstadoOportunidad cambia el estado de flujo en -1 o +1 respectivamente
    public String retrocederEstadoOportunidad(String estado) {

        switch (estado.toLowerCase()) {
            case "perdido":
                System.out.println("¡Ya está perdido!");
                break;
            case "nuevo":
                estado = "Perdido";
                break;
            case "cualificado":
                estado = "Nuevo";
                break;
            case "propuesta":
                estado = "Cualificado";
                break;
            case "negociación":
                estado = "Propuesta";
                break;
            case "ganado":
                estado = "Negociación";
                break;
            default:
                break;
        }
        return estado;
    }

    public String avanzarEstadoOportunidad(String estado) {

        switch (estado.toLowerCase()) {
            case "perdido":
                estado = "Nuevo";
                break;
            case "nuevo":
                estado = "Cualificado";
                break;
            case "cualificado":
                estado = "Propuesta";
                break;
            case "propuesta":
                estado = "Negociación";
                break;
            case "negociación":
                estado = "Ganado";
                break;
            case "ganado":
                System.out.println("¡Ya está ganado!");
                break;
            default:
                break;
        }
        return estado;
    }*/

}
