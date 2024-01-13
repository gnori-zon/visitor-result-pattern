package org.gnori.visitorresultpattern.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.gnori.visitorresultpattern.common.Result;
import org.gnori.visitorresultpattern.model.Product;
import org.gnori.visitorresultpattern.operation.query.FindProductByIdQuery;
import org.gnori.visitorresultpattern.operation.failure.FindProduceFailure;
import org.gnori.visitorresultpattern.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController("/product")
@RequiredArgsConstructor
public class ProductRestController {

    private final ProductService productService;
    private final Result.Folder<ResponseEntity<?>, Product, FindProduceFailure> findProductResultFolder;

    @GetMapping("/{id: \\d+}")
    public ResponseEntity<?> findById(
            @PathVariable(name = "id") Long productId
    ) {

        return productService.findProductById(new FindProductByIdQuery(productId))
                .doIfSuccess(product -> log.info("success find product by id: {}", product.id()))
                .doIfFailure(failure -> log.info("failure find product by id: {}", failure.name()))
                .fold(findProductResultFolder);
    }
}
