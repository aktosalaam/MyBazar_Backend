package com.niit.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.SupplierDAO;
import com.niit.model.Supplier;

public class SupplierDAOTestCase {

	private static AnnotationConfigApplicationContext context;
	private static SupplierDAO supplierDao;
	private SupplierDAOTestCase supplier;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com");
		context.refresh();
		supplierDao = (SupplierDAO) context.getBean("supplierDAO");
	}
//
	//@Ignore
	@Test
	public void testAddSupplier() {
		Supplier supplier = new Supplier();
		supplier.getSupplierId();
		supplier.setSupplierName("Akash");
		assertEquals("Successfully added a supplier details into the table", true, supplierDao.addSupplier(supplier));
	}
/*
	@Test
	public void testGetSupplier() {
		Supplier supplier = new Supplier();
		supplier = supplierDao.getSupplier(1);
		assertEquals("Successfully fetched a supplier details from the table", "xyz", supplier.getSupplierName());
	}

	
	@Test
	public void testUpdateSupplier() {
		Supplier supplier = new Supplier();
		supplier = supplierDao.getSupplier(1);
		supplier.setSupplierName("xyz");
		assertEquals("Successfully updated a supplier details from the table", true,
				supplierDao.updateSupplier(supplier));
	}

	@Test
	public void testDeleteSupplier() {
		Supplier supplier = new Supplier();
		supplier = supplierDao.getSupplier(1);
		assertEquals("Successfully deleted supplier details from the table", true,
				supplierDao.deleteSupplier(supplier));
	}

	@Test
	public void testGetAllSupplier() {
		Supplier supplier = new Supplier();
		supplier = supplierDao.getSupplier(1);
		
		assertEquals("Successfully fetched all supplier details from the table", 3, supplierDao.getSupplier(supplier.getSupplierId()));
	}*/
}
