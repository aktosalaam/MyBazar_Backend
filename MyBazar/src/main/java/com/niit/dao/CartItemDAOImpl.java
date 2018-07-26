package com.niit.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.model.CartItem;

@Repository("CartDAO")
@Transactional
public class CartItemDAOImpl {
	
	@Autowired
	SessionFactory sessionFactory; 
	
	
	
	
	 
	public boolean addToCart(CartItem CartItem)
	{
		try
		{
			sessionFactory.getCurrentSession().save(CartItem);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
		
		public boolean deleteFromCart(CartItem cartItem) {
			try
			{
				sessionFactory.getCurrentSession().delete(cartItem);
				return true;
			}
			catch(Exception e)
			{
				return false;
			}
		}
			
			public boolean updateCart(CartItem cartItem) 
			{
				try
				{
					sessionFactory.getCurrentSession().update(cartItem);
					return true;
				}
				catch(Exception e)
				{
					return false;
				} 
			}

				public CartItem getCartItem(int cartItemId) 
				{
					Session session=sessionFactory.openSession();
					CartItem cartItem=(CartItem)session.get(CartItem.class,cartItemId);
					return cartItem;
				}	
				
				@SuppressWarnings("unchecked")
				public List<CartItem> listCartItems(String username) 
				{
					Session session=sessionFactory.openSession();
					List<CartItem> listCartItems=(List<CartItem>)session.createQuery("from CartItem where username=:username and status='NP'").setParameter("username", username).list();
					return listCartItems;
				}
	}


