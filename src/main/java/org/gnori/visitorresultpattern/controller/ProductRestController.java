package org.gnori.visitorresultpattern.controller;

import lombok.RequiredArgsConstructor;
import org.gnori.visitorresultpattern.operation.product.query.FindProductByIdQuery;
import org.gnori.visitorresultpattern.operation.product.result.FindProductResult;
import org.gnori.visitorresultpattern.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("/product")
@RequiredArgsConstructor
public class ProductRestController {

    private final ProductService productService;
    private final FindProductResult.Processor<ResponseEntity<?>> productMapper;

    @GetMapping("/{id: \\d+}")
    public ResponseEntity<?> findById(
            @PathVariable(name = "id") Long productId
    ) {

        return productService.findProductById(new FindProductByIdQuery(productId))
                .process(productMapper);
    }
}
