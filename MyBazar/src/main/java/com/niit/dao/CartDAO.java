package com.niit.dao;

import java.util.List;

import com.niit.model.CartItem;

public interface CartDAO {
	
	public boolean addToCart(CartItem CartItem);
	public boolean deleteFromCart(CartItem CartItem);
	public boolean updateCart(CartItem CartItem);
	public boolean  getCartItem(int CartItemId);
	public List<CartItem> listCartItems(String username);

}
