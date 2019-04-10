package com.example.demo.commons;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseEntityBase<ID> implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private ID id;
    
    private String message;
}
