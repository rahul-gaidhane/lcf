package com.example.demo.errors;
public class ItemGroupNameAlreadyUsedException extends BadRequestAlertException {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public ItemGroupNameAlreadyUsedException() {
        super(ErrorConstants.CONSTRAINT_VIOLATION_TYPE, "ItemGroup Name is already in use!", "itemGroup", "nameexist");
    }
}
