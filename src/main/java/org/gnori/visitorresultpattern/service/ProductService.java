package org.gnori.visitorresultpattern.service;

import org.gnori.visitorresultpattern.operation.product.query.FindProductByIdQuery;
import org.gnori.visitorresultpattern.operation.product.result.FindProductResult;

public interface ProductService {

    FindProductResult findProductById(FindProductByIdQuery query);
}
