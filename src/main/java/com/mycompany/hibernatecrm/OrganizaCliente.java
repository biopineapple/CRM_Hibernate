/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hibernatecrm;

import java.util.List;
import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author Pablo Martínez y Santiago Ucero.
 */
public class OrganizaCliente {

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

    // Enseña todos los clientes actuales
    public void showAllClients(Session s) {

        List<models.Cliente> listaClientes = aux.loadAllData(models.Cliente.class, s);
        System.out.println(" " + listaClientes);
    }

    //Elimina un cliente según id.
    public void deleteClient(Session s, Transaction t, Integer id) {
        models.Cliente cliente = s.get(models.Cliente.class, id);
        Query borrarsql = s.createQuery("DELETE Cliente where id=:id_borrar");
        borrarsql.setParameter("id_borrar", id);
        if (borrarsql.executeUpdate() != 0) {
            System.out.println("¡Cliente eliminado! ¡Pam!");
        } else {
            System.out.println("No se eliminó a nadie.");
        }
        t.commit();
    }

    //Editar datos de un cliente según id.
    public void editCliente(Session s, Transaction t, Integer id) {

        models.Cliente client = s.get(models.Cliente.class, id);

        System.out.println("Cambiar nombre: ");
        String nombre = scan.nextLine();
        client.setNombre(nombre);

        System.out.println("Cambiar apellido: ");
        String apellido = scan.nextLine();
        client.setApellidos(apellido);

        System.out.println("Cambiar empresa: ");
        String empresa = scan.nextLine();
        client.setEmpresa(empresa);

        System.out.println("Cambiar teléfono: ");
        String telf = scan.nextLine();
        client.setTelefono(telf);

        System.out.println("Cambiar e-mail: ");
        String email = scan.nextLine();
        client.setEmail(email);

        s.update(client);
        t.commit();
    }

    // Crea un cliente nuevo.
    public void addCliente(Session s, Transaction t) {

        models.Cliente client = new models.Cliente();

        System.out.println("Introducir nombre: ");
        String nombre = scan.nextLine();
        client.setNombre(nombre);

        System.out.println("Introducir apellidos: ");
        String apellido = scan.nextLine();
        client.setApellidos(apellido);

        System.out.println("Introducir empresa: ");
        String empresa = scan.nextLine();
        client.setEmpresa(empresa);

        System.out.println("Introducir teléfono: ");
        String telf = scan.nextLine();
        client.setTelefono(telf);

        System.out.println("Introducir e-mail: ");
        String email = scan.nextLine();
        client.setEmail(email);

        s.save(client);
        t.commit();
    }

    /*
    public void addCliente() {
        models.Cliente client1 = new models.Cliente();
        client1.setNombre("Tito");
        client1.setApellidos("Camilo Ilo");
        client1.setEmpresa("Emprefresa");
        client1.setTelefono("123222333");
        client1.setEmail("tito@apa.com");
        //s.save(cliente1);                
        //t.commit();
    }

    public void editCliente() {

        //Editar datos de un cliente según id.
        t = s.beginTransaction();  //<--- Añadir tras cada commit y al comienzo de cada operación.
        models.Cliente client2 = s.get(Cliente.class, 1);
        System.out.println(client2.toString());
        client2.setNombre("Bambi");
        client2.setApellidos("el Ciervo");
        client2.setEmpresa("Foresta.SA");
        client2.setTelefono("188774778");
        client2.setEmail("bambino@forest.com");
        s.update(client2);
        t.commit();

    }
    
    public void deleteCliente() {
        //Borrar un cliente según su id.
        models.Cliente cliente = s.get(Cliente.class, 8);
        Integer id = cliente.getId();
        Query borrarsql = s.createQuery("DELETE Cliente where id=:id_borrar");
        borrarsql.setParameter("id_borrar", id);
        if (borrarsql.executeUpdate() != 0) {
            System.out.println("Eliminado");
        } else {
            System.out.println("No se eliminó a nadie");
        }
        t.commit();
    }
    
    public void showCliente(){
        //Muestra en consola el cliente, la oportunidad y la actividad según su id.
                
        //Muestra cliente según id.
            models.Cliente cliente1 = s.load(models.Cliente.class, 1);
            System.out.println(cliente1);
        
        //Muestra las oportunidades del cliente.
            System.out.println(cliente1.getOportunidades());
            models.Oportunidad oport1 = s.load(models.Oportunidad.class, 9);
        
        //Muestra las actividades de la oportunidad.
            System.out.println(oport1.getActividades());
            System.out.println("========================");           
    }*/
}
