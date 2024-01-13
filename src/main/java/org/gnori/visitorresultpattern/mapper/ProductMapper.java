package org.gnori.visitorresultpattern.mapper;

import org.gnori.visitorresultpattern.operation.product.result.FindProductResult;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper implements FindProductResult.Processor<ResponseEntity<?>>{

    @Override
    public ResponseEntity<?> processSuccess(FindProductResult.Success success) {
        return ResponseEntity.ok(success);
    }

    @Override
    public ResponseEntity<?> processNotFound(FindProductResult.NotFound notFound) {
        return ResponseEntity.notFound().build();
    }
}
