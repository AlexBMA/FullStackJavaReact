package io.stivaplina.pptool.services;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MapValidationErrorService {

    public ResponseEntity<?> mapValidationService(BindingResult result) {
        if(result.hasErrors()){
            List<FieldError> fieldErrors = result.getFieldErrors();
            Map<String,String> errorMap = new HashMap<>();
            fieldErrors
                    .forEach(item->errorMap.put(item.getField(),item.getDefaultMessage()));

            return new ResponseEntity<>(errorMap, HttpStatus.BAD_REQUEST);
        }
        return null;
    }
}
