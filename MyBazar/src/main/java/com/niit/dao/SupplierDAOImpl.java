package com.niit.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.niit.model.Supplier;

@Repository("supplierDAO")
@Service

public class SupplierDAOImpl implements SupplierDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public SupplierDAOImpl(SessionFactory sf) {
		super();
		this.sessionFactory = sf;
	}

	public boolean addSupplier(Supplier supplier) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		try {
			session.saveOrUpdate(supplier);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			session.getTransaction().commit();
			session.close();
		}

	}

	/*
	 * Updating details
	 */
	public boolean updateSupplier(Supplier supplier) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		try {
			sessionFactory.getCurrentSession().update(supplier);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			session.getTransaction().commit();
			session.close();
		}

	}

	public boolean deleteSupplier(Supplier id) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Supplier supplier1 = (Supplier) sessionFactory.getCurrentSession().load(Supplier.class, id);
		try {
			if (null != supplier1) {
				session.delete(supplier1);
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			session.getTransaction().commit();
			session.close();
		}

	}

	// Getting single supplier details by id
	public Supplier getSupplier(int sid) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Supplier supplier = (Supplier) session.get(Supplier.class, sid);
		session.getTransaction().commit();
		session.close();
		return supplier;
	}

	@SuppressWarnings({ "unchecked" })
	public List<Supplier> listSupplier() {
		List<Supplier> suppList = new ArrayList<Supplier>();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("FROM Supplier");
		suppList = query.list();
		session.getTransaction().commit();
		session.close();
		return suppList;

	}



}