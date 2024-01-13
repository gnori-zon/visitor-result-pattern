package org.gnori.visitorresultpattern.mapper;

import org.gnori.visitorresultpattern.common.Result;
import org.gnori.visitorresultpattern.model.Product;
import org.gnori.visitorresultpattern.operation.failure.FindProduceFailure;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class FindProductResultFolder implements Result.Folder<ResponseEntity<?>, Product, FindProduceFailure> {

    @Override
    public ResponseEntity<?> foldSuccess(Result.Success<Product, FindProduceFailure> success) {
        return ResponseEntity.ok(success);
    }

    @Override
    public ResponseEntity<?> foldFailure(Result.Failure<Product, FindProduceFailure> failure) {

        return switch (failure.value()) {
            case NOT_FOUND -> ResponseEntity.notFound().build();
        };
    }
}
