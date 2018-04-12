package com.dev.gae.java.todo;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

//The creation of the EntityManagerFactory is time-consuming therefore we buffer it.
public class EMFService {
  private static final EntityManagerFactory emfInstance = Persistence.createEntityManagerFactory("transactions-optional");


  private EMFService() {
  }

  public static EntityManagerFactory get() {
    return emfInstance;
  }
} 