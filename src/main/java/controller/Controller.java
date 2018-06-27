package controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.Scanner;

import application.*;

public class Controller implements AutoCloseable {
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("controller");

	public void close() {
		emf.close();
	}

}