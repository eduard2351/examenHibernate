package com.ejemplo.abstractas;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.ejemplo.HibernateUtil;

public abstract class ModeloAbstracto<T> {

	private Class<T> entidad;

	protected SessionFactory sf = HibernateUtil.getSessionFactory();

	public ModeloAbstracto(Class<T> entidad) {
		super();
		this.entidad = entidad;
	}

	public T obtener(Object id) {
		T resultado = null;

		Session session = null;
		Transaction tx = null;

		try {
			session = sf.openSession();
			tx = session.beginTransaction();

			resultado = (T) session.get(entidad, (Serializable) id);
			tx.commit();

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			session.close();
		}
		return resultado;
	}

	public boolean crear(T entidad) {
		boolean resultado = true;

		Session session = null;
		Transaction tx = null;

		try {
			session = sf.openSession();
			tx = session.beginTransaction();

			session.save(entidad);

			tx.commit();

		} catch (Exception e) {
			resultado = false;
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			session.close();
		}
		return resultado;
	}

	/*****************/
	public boolean actualizar(T entidad) {
		boolean resultado = true;

		Session session = null;
		Transaction tx = null;

		try {
			session = sf.openSession();
			tx = session.beginTransaction();

			session.update(entidad);

			tx.commit();

		} catch (Exception e) {
			resultado = false;
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			session.close();
		}
		return resultado;
	}

	public boolean borrar(T entidad) {
		boolean resultado = true;

		Session session = null;
		Transaction tx = null;

		try {
			session = sf.openSession();
			tx = session.beginTransaction();

			session.delete(entidad);

			tx.commit();

		} catch (Exception e) {
			resultado = false;
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			session.close();
		}
		return resultado;
	}

	/*********************/

	public List<T> obtenerTotal() {
		List<T> resultado = null;

		Session session = null;
		Transaction tx = null;

		try {
			session = sf.openSession();
			tx = session.beginTransaction();

			resultado = session.createQuery("FROM" + entidad.getName()).list();

			tx.commit();

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			session.close();
		}
		return resultado;
	}
}
