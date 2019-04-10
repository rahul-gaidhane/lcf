package com.example.demo.errors;

public class AttributeNameAlreadyExistsException extends BadRequestAlertException {


    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public AttributeNameAlreadyExistsException() {
        super(ErrorConstants.CONSTRAINT_VIOLATION_TYPE, "Attribute having name already exists", "Attribute", "attributeexists");
    }

}
