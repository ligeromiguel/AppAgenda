/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appagenda;

import entidades.Provincia;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Miguel
 */
public class AppAgenda {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        
        //Conecta con la base de datos
        Map<String, String> emfProperties = new HashMap<>();
        emfProperties.put("javax.persistence.jdbc.schema-generation.database.action", "create");
        emfProperties.put("javax.persistence.jdbc.url","jdbc:derby:BDAgenda;create=true");
        
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("AppAgendaPU");
        EntityManager em=emf.createEntityManager();

        /*Provincia provinciaSevilla = new Provincia();
        provinciaSevilla.setNombre("SEVILLA");
        //Transacción
        em.persist(provinciaSevilla);*/
        
        //Inicio de la Transacción
        em.getTransaction().begin();

        //Confirmar Transacción
        em.getTransaction().commit();
        
        //CancelarTransacciones [getTransaction().rollback();]
        
        //Cerrar conexión
        em.close();
        emf.close();
        try{
            DriverManager.getConnection("jdbc:derby:BDAgenda;shutdown=true");
        }catch (SQLException ex){
         }
    }
    
}
