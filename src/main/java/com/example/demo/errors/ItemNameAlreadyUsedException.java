package com.example.demo.errors;
public class ItemNameAlreadyUsedException extends BadRequestAlertException {
    private static final long serialVersionUID = 1L;
    
    public ItemNameAlreadyUsedException() {
        super(ErrorConstants.CONSTRAINT_VIOLATION_TYPE, "Item Name is already in use!", "item", "NameExist");
    }
}
