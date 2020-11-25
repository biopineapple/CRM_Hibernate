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

import java.util.Date;
import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

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

            OrganizaCliente organizaCliente = new OrganizaCliente();
            OrganizaOportunidad organizaOportunidad = new OrganizaOportunidad();
            OrganizaActividad organizaActividad = new OrganizaActividad();
            
            Scanner sc = new Scanner(System.in);
            boolean salir = false;

            try {
                t = s.beginTransaction();
                
                
                
                while (salir != true) {
                    System.out.println("¡Bienvenido/a al sistema de CRM con Hibernate!");
                    System.out.println("==============================================");
                    System.out.println("¿Qué quieres hacer?"
                            + "\n 1. Crear cliente/oportunidad/actividad."
                            + "\n 2. Borrar cliente/oportunidad/actividad."
                            + "\n 3. Editar cliente/oportunidad/actividad."
                            + "\n 4. Listar cliente/oportunidades/actividades."
                            + "\n 5. Salir.");
                    int primeraRespuesta = sc.nextInt();
                    switch (primeraRespuesta){
                        //Aquí se hará toda la movida de crear cosos.
                        case 1:
                            System.out.println("¿Qué vas a crear?");
                            System.out.println("\n 1. Crear cliente."
                                    + "\n 2. Crear oportunidad."
                                    + "\n 3. Crear actividad."
                                    + "\n 4. Salir.");
                            int crearRespuesta = sc.nextInt();
                            switch (crearRespuesta){                                
                                case 1:
                                    System.out.println("¡Vas a crear un cliente!");
                                    //Ahora pregunta por cada dato del cliente.
                                    organizaCliente.addCliente(s, t);
                                    //Una vez introducidos los datos, el cliente se añadirá a la tabla de cliente.
                                    System.out.println("¡Cliente creado! ¡Yuju!");
                                    break;
                                    
                                case 2:
                                    System.out.println("¡Vas a crear una oportunidad!");
                                    //Ahora pregunta por cada dato de la oportunidad.                                    
                                    organizaOportunidad.addOportunidad(s, t);
                                    //Una vez introducidos los datos, la oportunidad se añadirá a la tabla de oportunidad.
                                    System.out.println("¡Oportunidad creada! ¡Yuju!");
                                    break;
                                    
                                case 3:
                                    System.out.println("¡Vas a crear una actividad!");
                                    //Ahora pregunta por cada dato de la actividad.
                                    organizaActividad.addActividad(s, t);
                                    //Una vez introducidos los datos, la actividad se añadirá a la tabla de actividad.
                                    System.out.println("¡Actividad creada! ¡Yuju!");
                                    break;   
                                    
                                case 4:
                                    System.out.println("¡Operación cancelada!");
                                    salir = true;
                                    break;
                                    
                                default:
                                    System.out.println("Esa opción no está disponible.");
                                    break;   
                            }
                            break;
                            
                        //Aquí se hará toda la movida de borrar cosos.    
                        case 2:            
                            System.out.println("¿Qué vas a borrar?");
                            System.out.println("\n 1. Borrar cliente."
                                    + "\n 2. Borrar oportunidad."
                                    + "\n 3. Borrar actividad."
                                    + "\n 4. Salir.");
                            int borrarRespuesta = sc.nextInt();
                            switch (borrarRespuesta) {
                                case 1:
                                    System.out.println("¡Vas a borrar un cliente!");
                                    //Ahora muestra la lista de clientes.
                                    organizaCliente.showAllClients(s);
                                    //Entonces, selecciona un cliente por su id.
                                    System.out.println("Selecciona la id del cliente que quieres borrar:");
                                    //El cliente se borra de la tabla.
                                    int id = sc.nextInt();
                                    organizaCliente.deleteClient(s, t, id);
                                    break;

                                case 2:
                                    System.out.println("¡Vas a borrar una oportunidad!");
                                    //Ahora muestra la lista de oportunidades.
                                    organizaOportunidad.showAllOportunidades(s);
                                    //Entonces, selecciona una oportunidad por su id.
                                    System.out.println("Selecciona la id de la oportunidad que quieres borrar:");
                                    //La oportunidad se borra de la tabla.
                                    int idOport = sc.nextInt();
                                    organizaOportunidad.deleteOportunidad(s, t, idOport);
                                    break;

                                case 3:
                                    System.out.println("¡Vas a borrar una actividad!");
                                    //Ahora muestra la lista de actividades.
                                    organizaActividad.showAllActividades(s);
                                    //Entonces, selecciona una actividad por su id.
                                    System.out.println("Selecciona la id de la actividad que quieres borrar:");
                                    //La actividad se borra de la tabla.
                                    int idActiv = sc.nextInt();
                                    organizaActividad.deleteActividad(s, t, idActiv);
                                    System.out.println("¡Actividad eliminada! ¡Oof!");
                                    break;

                                case 4:
                                    System.out.println("¡Operación cancelada!");
                                    salir = true;
                                    break;

                                default:
                                    System.out.println("Esa opción no está disponible.");
                                    break;
                            }
                            break;
                            
                        //Aquí se hará toda la movida de editar cosos.    
                        case 3:            
                            System.out.println("¿Qué vas a editar?");
                            System.out.println("\n 1. Editar cliente."
                                    + "\n 2. Editar oportunidad."
                                    + "\n 3. Editar actividad."
                                    + "\n 4. Salir.");
                            int editarRespuesta = sc.nextInt();
                            switch (editarRespuesta) {
                                case 1:
                                    System.out.println("¡Vas a editar un cliente!");
                                    System.out.println("Elige la id del cliente que quieres editar.");
                                    organizaCliente.showAllClients(s);
                                    int id = sc.nextInt();
                                    models.Cliente client = s.get(models.Cliente.class, id);
                                    System.out.println("¿Qué quieres editar?");
                                    System.out.println("\n 1. Editar nombre."
                                            + "\n 2. Editar apellidos."
                                            + "\n 3. Editar empresa."
                                            + "\n 4. Editar telefono."
                                            + "\n 5. Editar email."
                                            + "\n 6. Editar todo."
                                            + "\n 7. Salir.");
                                    //Ahora tiene la opción de elegir los cosos del cliente.
                                    int editarCliente = sc.nextInt();                                    
                                    switch (editarCliente){
                                        case 1:
                                            //Edita el nombre.
                                            System.out.println("Cambiar nombre: ");
                                            sc.nextLine();
                                            String nombre = sc.nextLine();
                                            client.setNombre(nombre);
                                            s.update(client);
                                            t.commit();
                                            t = s.beginTransaction();
                                            System.out.println("¡Nombre editado!");
                                            break;
                                        case 2:
                                            //Edita los apellidos.
                                            System.out.println("Cambiar apellidos: ");
                                            sc.nextLine();
                                            String apellidos = sc.nextLine();
                                            client.setApellidos(apellidos); 
                                            s.update(client);
                                            t.commit();
                                            t = s.beginTransaction();
                                            System.out.println("¡Apellidos editados!");
                                            break;
                                        case 3:
                                            //Edita la empresa.
                                            System.out.println("Cambiar empresa: ");
                                            sc.nextLine();
                                            String empresa = sc.nextLine();
                                            client.setEmpresa(empresa);
                                            s.update(client);
                                            t.commit();
                                            t = s.beginTransaction();
                                            System.out.println("¡Empresa editada!");
                                            break;
                                        case 4:
                                            //Edita el telefono.
                                            System.out.println("Cambiar teléfono: ");
                                            sc.nextLine();
                                            String telefono = sc.nextLine();
                                            client.setTelefono(telefono);
                                            s.update(client);
                                            t.commit();
                                            t = s.beginTransaction();
                                            System.out.println("¡Telefono editado!");
                                            break;
                                        case 5:
                                            //Edita el email.
                                            System.out.println("Cambiar e-mail: ");
                                            sc.nextLine();
                                            String email = sc.nextLine();
                                            client.setEmail(email);
                                            s.update(client);
                                            t.commit();
                                            t = s.beginTransaction();                                            
                                            System.out.println("¡Email editado!");
                                            break;
                                        case 6:
                                            //Edita todo el cliente.
                                            System.out.println("Introduce la id del cliente a editar.");                                            
                                            organizaCliente.editCliente(s, t, id);
                                            System.out.println("¡Cliente editado!");
                                            break;
                                        case 7:
                                            System.out.println("¡Operación cancelada!");
                                            salir = true;
                                            break;
                                        default:
                                            System.out.println("Esa opción no está disponible.");
                                            break;
                                    }
                                    
                                    //Los datos del cliente se han editado.
                                    System.out.println("¡Edición exitosa! ¡Fium!");
                                    break;

                                case 2:
                                    System.out.println("¡Vas a editar una oportunidad!");
                                    System.out.println("Elige la id de la oportunidad que quieres editar.");
                                    //Ahora muestra la lista de oportunidades.
                                    organizaOportunidad.showAllOportunidades(s);
                                    int idOport = sc.nextInt();
                                    models.Oportunidad oport = s.get(models.Oportunidad.class, idOport);
                                    System.out.println("¿Qué quieres editar?");
                                    System.out.println("\n 1. Editar id de cliente."
                                            + "\n 2. Editar descripción."
                                            + "\n 3. Editar valor."
                                            + "\n 4. Editar fecha."
                                            + "\n 5. Editar nivel."
                                            + "\n 6. Editar estado."
                                            + "\n 7. Editar todo."
                                            + "\n 8. Salir.");
                                    //Ahora tiene la opción de elegir los cosos de la oportunidad.
                                    int editarOportunidad = sc.nextInt();
                                    switch (editarOportunidad){
                                        case 1:
                                            //Edita la id del cliente.
                                            System.out.println("Cambiar el cliente mediante su id: ");
                                            sc.nextLine();
                                            Integer id_cliente = sc.nextInt();
                                            models.Cliente cliente = s.get(models.Cliente.class, id_cliente);
                                            oport.setCliente(cliente);
                                            
                                            break;
                                        case 2:
                                            //Edita la descripción.
                                            System.out.println("Cambiar descripcion: ");
                                            sc.nextLine();
                                            String descripcion = sc.nextLine();
                                            oport.setDescripcion(descripcion);
                                            s.update(descripcion);
                                            t.commit();
                                            t = s.beginTransaction();
                                            System.out.println("¡Descripción editada!");
                                            break;
                                        case 3:
                                            //Edita el valor.
                                            System.out.println("Introducir valor: ");
                                            sc.nextLine();
                                            BigDecimal valor = sc.nextBigDecimal();
                                            oport.setValor(valor);
                                            t.commit();
                                            t = s.beginTransaction();
                                            System.out.println("¡Valor editado!");
                                            break;
                                        case 4:
                                            //Edita la fecha.
                                            System.out.println("Introduzca la fecha (yyyy-mm-dd)");
                                            sc.nextLine();
                                            String str1 = sc.nextLine();
                                            SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-mm-dd");
                                            Date fecha = formatter1.parse(str1);
                                            oport.setFecha(fecha);
                                            t.commit();
                                            t = s.beginTransaction();
                                            System.out.println("¡Fecha editada!");
                                            break;
                                        case 5:
                                            //Edita el nivel.
                                            System.out.println("Introducir nivel: ");
                                            sc.nextLine();
                                            String nivel = sc.nextLine();
                                            oport.setNivel(nivel);
                                            t.commit();
                                            t = s.beginTransaction();
                                            System.out.println("¡Nivel editado!");
                                            break;
                                        case 6:
                                            //Edita el estado.
                                            System.out.println("Introducir estado: ");
                                            sc.nextLine();
                                            String estado = sc.nextLine();
                                            oport.setEstado(estado);
                                            t.commit();
                                            t = s.beginTransaction();
                                            System.out.println("¡Estado editado!");
                                            break;
                                        case 7:
                                            //Edita toda la oportunidad.
                                            System.out.println("Introduce la id de la oportunidad a editar.");                                            
                                            organizaOportunidad.editOportunidad(s, t, idOport);
                                            System.out.println("¡Oportunidad editada!");
                                            break;
                                        case 8:
                                            System.out.println("¡Operación cancelada!");
                                            salir = true;
                                            break;
                                            
                                        default:
                                            System.out.println("Esa opción no está disponible.");
                                            break;
                                    }
                                    
                                    //Los datos de la oportunidad se han editado.
                                    System.out.println("¡Edición exitosa! ¡Wow!");
                                    break;

                                case 3:
                                    System.out.println("¡Vas a editar una actividad!");
                                    System.out.println("Elige la id de la actividad que quieres editar.");
                                    //Ahora muestra la lista de actividades.
                                    organizaActividad.showAllActividades(s);
                                    int idActiv = sc.nextInt();
                                    models.Actividad activ = s.get(models.Actividad.class, idActiv);
                                    System.out.println("¿Qué quieres editar?");
                                    System.out.println("\n 1. Editar id de la oportunidad."
                                            + "\n 2. Editar tipo."
                                            + "\n 3. Editar descripción."
                                            + "\n 4. Editar fecha."
                                            + "\n 5. Editar todo."
                                            + "\n 6. Salir.");
                                    //Ahora tiene la opción de elegir los cosos de la actividad.
                                    int editarActividad = sc.nextInt();
                                    switch (editarActividad){
                                        case 1:
                                            //Edita el id de la oportunidad.
                                            System.out.println("¡Id de la oportunidad editada!");
                                            sc.nextLine();
                                            Integer id_oportunidad = sc.nextInt();
                                            models.Oportunidad oportu = s.get(models.Oportunidad.class, id_oportunidad);
                                            activ.setOportunidad(oportu);
                                            break;
                                        case 2:
                                            //Edita el tipo.
                                            System.out.println("Cambiar tipo: ");
                                            sc.nextLine();
                                            String tipo = sc.nextLine();
                                            activ.setTipo(tipo);
                                            t.commit();
                                            t = s.beginTransaction();
                                            System.out.println("¡Tipo editado!");
                                            break;    
                                        case 3:
                                            //Edita la descripción.
                                            System.out.println("Cambiar descripción: ");
                                            sc.nextLine();
                                            String descripcion = sc.nextLine();
                                            activ.setDescripcion(descripcion);
                                            t.commit();
                                            t = s.beginTransaction();
                                            System.out.println("¡Descripción editada!");
                                            break;
                                        case 4:
                                            //Edita la fecha.
                                            System.out.println("Introduzca la fecha (yyyy-mm-dd)");
                                            sc.nextLine();
                                            String str1 = sc.nextLine();
                                            SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-mm-dd");
                                            Date fecha = formatter1.parse(str1);
                                            activ.setFecha(fecha);
                                            t.commit();
                                            t = s.beginTransaction();
                                            System.out.println("¡Fecha editada!");
                                            break;
                                        case 5:
                                            //Edita toda la actividad.
                                            System.out.println("Introduce la id de la actividad a editar.");                                            
                                            organizaActividad.editActividad(s, t, idActiv);
                                            System.out.println("¡actividad editada!");
                                            break;
                                        case 6:
                                            System.out.println("¡Operación cancelada!");
                                            salir = true;
                                            break;
                                            
                                        default:
                                            System.out.println("Esa opción no está disponible.");
                                            break;
                                    }
                                    
                                    //Los datos de la actividad se han editado.
                                    System.out.println("¡Edición exitosa! ¡Crash!");
                                    break;
                                case 4:
                                    System.out.println("¡Operación cancelada!");
                                    salir = true;
                                    break;
                                default:
                                    System.out.println("Esa opción no está disponible.");
                                    salir = true;
                                    break;  
                            }
                            break;
                            
                        case 4:
                            System.out.println("¿Qué vas a listar?");
                            System.out.println("\n 1. Listar los clientes."
                                    + "\n 2. Listar las oportunidades."
                                    + "\n 3. Listar los actividades."
                                    + "\n 4. Listar todo."
                                    + "\n 5. Salir.");
                            int listarRespuesta = sc.nextInt();
                            switch (listarRespuesta) {
                                case 1:
                                    System.out.println("¡Vas a listar todos los clientes!");
                                    organizaCliente.showAllClients(s);
                                    break;
                                case 2:
                                    System.out.println("¡Vas a listar todas las oportunidades!");
                                    //Ahora muestra la lista de oportunidades.
                                    organizaOportunidad.showAllOportunidades(s);
                                    break;
                                case 3:
                                    System.out.println("¡Vas a listar todas las actividades!");
                                    //Ahora muestra la lista de actividades.
                                    organizaActividad.showAllActividades(s);
                                    break;
                                case 4:
                                    System.out.println("¡Vas a listar todo!");
                                    //Ahora muestra la lista de todo.
                                    System.out.println("Lista de clientes:");
                                    organizaCliente.showAllClients(s);
                                    System.out.println("\n");
                                    System.out.println("Lista de oportunidades:");
                                    organizaOportunidad.showAllOportunidades(s);
                                    System.out.println("\n");
                                    System.out.println("Lista de actividades:");
                                    organizaActividad.showAllActividades(s);
                                    break;                                    
                                case 5:
                                    System.out.println("¡Operación cancelada!");
                                    salir = true;
                                    break;
                                default:
                                    System.out.println("Esa opción no está disponible.");
                                    salir = true;
                                    break; 
                            }
                            break;
                        case 5: 
                            System.out.println("¡Hasta la próxima!");
                            salir = true;
                            break;                    
                    }
                }
                
                
                
                
                
                
                
                /*Muestra en consola el cliente, la oportunidad y la actividad según su id.
                //Muestra cliente según id.
                models.Cliente cliente1 = s.load(models.Cliente.class, 1);
                System.out.println(cliente1);
                //Muestra las oportunidades del cliente.
                System.out.println(cliente1.getOportunidades());
                models.Oportunidad oport1 = s.load(models.Oportunidad.class, 9);
                //Muestra las actividades de la oportunidad.
                System.out.println(oport1.getActividades());
                System.out.println("========================");

                //Borra cliente según id.
                models.Cliente client3 = s.get(Cliente.class, 8);
                Integer id = client3.getId();
                Query borrarsql = s.createQuery("DELETE Cliente where id=:id_borrar");
                borrarsql.setParameter("id_borrar", id);
                if (borrarsql.executeUpdate() != 0) {
                    System.out.println("Eliminado");
                } else {
                    System.out.println("No se eliminó a nadie");
                }
                t.commit();
                

                //String fecha = "02/12/2022";
                //SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");                
                //Date date = sdf.parse(str);
                //Date fecha = Date.valueOf(LocalDate.MAX);
                Date date = new Date();
                BigDecimal value = new BigDecimal(33.000);
                Cliente cliente2 = (Cliente) s.get(Cliente.class, 2);
                models.Oportunidad oport2 = new models.Oportunidad(cliente2, "Sofritos", value, date, "NUEVO", "OTORGADO");
                s.save(oport2);
                t.commit();*/

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
