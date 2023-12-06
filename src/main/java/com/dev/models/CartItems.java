package com.dev.models;

public class CartItems {
    private long cartId;
    private long itemId;
    private long quantity;

    public CartItems() {
        this.cartId=getCartId();
        this.itemId=getItemId();
    }

    public CartItems(long cartId, long itemId, long quantity) {
        this.cartId = cartId;
        this.itemId = itemId;
        this.quantity = quantity;
    }

    public long getCartId() {
        return cartId;
    }

    public void setCartId(long cartId) {
        this.cartId = cartId;
    }

    public long getItemId() {
        return itemId;
    }
    
    public void setItemId(long itemId) {
        this.itemId = itemId;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }
}
