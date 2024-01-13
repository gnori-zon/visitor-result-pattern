package org.gnori.visitorresultpattern.service;

import org.gnori.visitorresultpattern.common.Result;
import org.gnori.visitorresultpattern.model.Product;
import org.gnori.visitorresultpattern.operation.query.FindProductByIdQuery;
import org.gnori.visitorresultpattern.operation.failure.FindProduceFailure;

public interface ProductService {

    Result<Product, FindProduceFailure> findProductById(FindProductByIdQuery query);
}
