
package com.craft;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class App {

    public static void main(String[] args) {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("studentPU");

        EntityManager em = emf.createEntityManager();

        try {
       
            em.getTransaction().begin();

            Student student = new Student("Ruth", "Java");
            em.persist(student);

            em.getTransaction().commit();

            System.out.println("Student created: " + student);

           
            Student found = em.find(Student.class, student.getId());
            System.out.println("Student found: " + found);

            em.getTransaction().begin();

            found.setName("Ruth Dagim");
            found.setTech("Java and JPA");

            em.getTransaction().commit();

            System.out.println("Student updated: " + found);

           
            
            em.getTransaction().begin();
            em.remove(found);
            em.getTransaction().commit();
            System.out.println("Student deleted.");
            

        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();

        } finally {
            em.close();
            emf.close();
        }
    }
}
