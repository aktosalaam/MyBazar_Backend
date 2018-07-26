package com.niit.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.dao.CategoryDAOImpl;
import com.niit.model.Category;
import com.niit.model.Product;



@Configuration

@EnableTransactionManagement
public class DBConfig 
{

	@Bean
	public DataSource getH2DataSource()
	{
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/S190035");
		dataSource.setUsername("sa");
		dataSource.setPassword("");
		
		System.out.println("Data Source Object Created");
		
		return dataSource;
	}
	
	@Bean(name="sessionFactory")
	public SessionFactory getSessionFactory()
	{
		Properties properties=new Properties();
		properties.put("hibernate.hbm2ddl.auto","create");
		properties.put("hibernate.show_sql","true");
		properties.put("hibernate.dialect","org.hibernate.dialect.H2Dialect");
		
		LocalSessionFactoryBuilder Builder=new LocalSessionFactoryBuilder(getH2DataSource());
		Builder.addProperties(properties);
		
		Builder.addAnnotatedClass(Category.class);
		Builder.addAnnotatedClass(Product.class);
		
		SessionFactory sessionFactory=Builder.buildSessionFactory();
		
		System.out.println("SessionFactory Object Created");
		
		return Builder.buildSessionFactory();
	}
	@Autowired
	@Bean(name = "supplierDaoImpl")
	public SupplierDAOImpl getSuppData(SessionFactory sf) {
		return new SupplierDAOImpl();
	}

	@Autowired
	@Bean(name = "categoryDaoImpl")
	public CategoryDAOImpl getCategoryData(SessionFactory sf) {
		return new CategoryDAOImpl();
	}
	
	@Bean
	public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sessionFactory)
	{
		System.out.println("Hibernate Transaction Object Created");
		return new HibernateTransactionManager(sessionFactory);
	}
	
}
