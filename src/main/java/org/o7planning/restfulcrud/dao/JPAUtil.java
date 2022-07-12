package org.o7planning.restfulcrud.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	private static final String PERSISTENCE_UNIT_NAME = "RESTfulCRUDJpa";
	private static EntityManagerFactory factory;

	public JPAUtil() {
	}

	public static EntityManagerFactory getEntityManagerFactory() {
		if (factory == null) {
			factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		}

		return factory;
	}

	public static void shutdown() {
		if (factory != null) {
			factory.close();
		}

	}
}
