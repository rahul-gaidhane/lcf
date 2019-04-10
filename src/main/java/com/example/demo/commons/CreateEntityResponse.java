package com.example.demo.commons;

import lombok.Getter;
import lombok.Setter;

/**
 * @author sushant
 * 
 *         DTO for create ItemGroup response
 */
@Getter
@Setter
public class CreateEntityResponse<ID> extends ResponseEntityBase<ID> {
    
    private static final long serialVersionUID = 1L;
    
    public CreateEntityResponse() {
        
    }
    
    public CreateEntityResponse(ID id, String message) {
        super(id, message);
    }

  
}
