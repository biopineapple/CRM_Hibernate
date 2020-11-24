/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hibernatecrm;

/**
 *
 * @author AlumnoManana20-21
 */
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
//import java.sql.Date;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import models.Cliente;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Pablo Martínez y Santiago Ucero.
 */
public class HibernateCRM {

    private static SessionFactory sessionFactory;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //org.apache.log4j.BasicConfigurator.configure();

        sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

        try ( Session s = sessionFactory.openSession()) {
            Transaction t = null;

            try {
                t = s.beginTransaction();

                models.Cliente cliente1 = s.load(models.Cliente.class, 1);
                System.out.println(cliente1);
                System.out.println(cliente1.getOportunidades());

                //SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                //String fecha = "02/12/2022";
                //Date fecha = Date.valueOf(LocalDate.MAX);
                Date date = new Date();
                BigDecimal value = new BigDecimal(33.000);
                Cliente cliente2 = (Cliente) s.get(Cliente.class, 2);
                models.Oportunidad oport2 = new models.Oportunidad(cliente2, "Sofritos", value, date, "NUEVO", "OTORGADO");
                s.save(oport2);
                t.commit();

                
                /*
                //Editar empresa de un cliente según id.
                //t = s.beginTransaction();  <--- Añadir tras cada commit y al comienzo de cada operación.
                models.Cliente client2 = s.get(Cliente.class, 1);
                System.out.println(client2.toString());
                client2.setEmpresa("Kame House");
                s.update(client2);
                t.commit();
                
                
                //Borrar un cliente.
                //t = s.beginTransaction();
                models.Cliente client3 = s.get(Cliente.class, 6);
                Integer id = client3.getId();
                Query borrarsql = s.createQuery("DELETE Cliente where id=:id_borrar");
                borrarsql.setParameter("id_borrar", id);
                if(borrarsql.executeUpdate() != 0){
                    System.out.println("Eliminado");
                }else{
                    System.out.println("No se eliminó a nadie");
                }
                t.commit();
                
                
                /*
                Set<models.Oportunidad> oportuni = cliente1.getOportunidades();
                System.out.println(cliente1);
                Iterator<models.Oportunidad> iter = oportuni.iterator();
                while(iter.hasNext()){
                    //System.out.println(iter.next().toString());
                }*/
                //t.isActive(); <--- Comprueba si la transacción está abierta (true/false).t = s.beginTransaction();
            } catch (Exception e) {
                e.printStackTrace(System.err);
                if (t != null) {
                    t.rollback();
                }
            }
        }
    }

}
