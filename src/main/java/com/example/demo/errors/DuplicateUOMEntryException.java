package com.example.demo.errors;
public class DuplicateUOMEntryException extends BadRequestAlertException{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public DuplicateUOMEntryException() {
        super(ErrorConstants.CONSTRAINT_VIOLATION_TYPE, "Unit of Measurement already exists", "UnitOfMeasurementManagement", "unitOfMeasurementExists");
    }
}
