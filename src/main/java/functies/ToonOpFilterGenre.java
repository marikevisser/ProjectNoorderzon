package functies;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.Scanner;

import entities.Artiest;

public class ToonOpFilterGenre implements AutoCloseable {
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("controller");

	public void close() {
		emf.close();
	}

	private Scanner reader;

	public Artiest showOpGenreFilter() {
		EntityManager em = emf.createEntityManager();
		try {
			TypedQuery<Artiest> q = em.createQuery(
					"SELECT g FROM entities.Artiest g WHERE g.naam = :genre", Artiest.class);
			q.setParameter("genre", "");
			for (Artiest g : q.getResultList()) {
				return g.getNaam(); 
			}
		} finally {
			em.close();
		}
	}
}