/**
 * 
 */
package com.example.demo.commons;

import lombok.Getter;
import lombok.Setter;

/**
 * @author sushant
 *
 *         Response class for updating ItemGroup.
 */
@Getter
@Setter
public class UpdateEntityResponse<ID> extends ResponseEntityBase<ID> {

    private static final long serialVersionUID = 1L;
    
    public UpdateEntityResponse() {
        
    }
    
    public UpdateEntityResponse(ID id, String message) {
        super(id, message);
    }

}
