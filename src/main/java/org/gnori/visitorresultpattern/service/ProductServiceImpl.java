package org.gnori.visitorresultpattern.service;

import org.gnori.visitorresultpattern.common.Result;
import org.gnori.visitorresultpattern.model.Product;
import org.gnori.visitorresultpattern.operation.query.FindProductByIdQuery;
import org.gnori.visitorresultpattern.operation.failure.FindProduceFailure;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.function.Function;

@Service
public class ProductServiceImpl implements ProductService {

    private final Function<Long, Optional<Product>> findProductByIdMock = createFindProductByIdMock();

    @Override
    public Result<Product, FindProduceFailure> findProductById(FindProductByIdQuery query) {

        return findProductByIdMock.apply(query.id())
                .map(Result::<Product, FindProduceFailure>success)
                .orElse(Result.failure(FindProduceFailure.NOT_FOUND));
    }

    private Function<Long, Optional<Product>> createFindProductByIdMock() {
        return id -> Optional.of(new Product(id, "mock-name"));
    }
}
