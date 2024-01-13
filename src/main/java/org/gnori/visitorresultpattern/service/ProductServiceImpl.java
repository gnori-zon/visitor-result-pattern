package org.gnori.visitorresultpattern.service;

import org.gnori.visitorresultpattern.model.Product;
import org.gnori.visitorresultpattern.operation.product.query.FindProductByIdQuery;
import org.gnori.visitorresultpattern.operation.product.result.FindProductResult;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.function.Function;

@Service
public class ProductServiceImpl implements ProductService {

    private final Function<Long, Optional<Product>> findProductByIdMock = createFindProductByIdMock();

    @Override
    public FindProductResult findProductById(FindProductByIdQuery query) {

        return findProductByIdMock.apply(query.id())
                .<FindProductResult>map(FindProductResult.Success::of)
                .orElse(FindProductResult.NotFound.INSTANCE);
    }

    private Function<Long, Optional<Product>> createFindProductByIdMock() {
        return id -> Optional.of(new Product(id, "mock-name"));
    }
}
