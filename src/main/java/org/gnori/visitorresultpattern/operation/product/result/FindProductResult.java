package org.gnori.visitorresultpattern.operation.product.result;

import lombok.Value;
import org.gnori.visitorresultpattern.model.Product;

public interface FindProductResult {

    <T> T process(Processor<T> processor);

    static FindProductResult success(Product product) {
        return Success.of(product);
    }

    static FindProductResult notFound() {
        return NotFound.INSTANCE;
    }

    @Value(staticConstructor = "of")
    record Success(Product product) implements FindProductResult {

        @Override
        public <T> T process(Processor<T> processor) {
            return processor.processSuccess(this);
        }
    }

    enum NotFound implements FindProductResult {
        INSTANCE;

        @Override
        public <T> T process(Processor<T> processor) {
            return processor.processNotFound(this);
        }
    }

    interface Processor<T> {
        T processSuccess(Success success);
        T processNotFound(NotFound notFound);
    }
}