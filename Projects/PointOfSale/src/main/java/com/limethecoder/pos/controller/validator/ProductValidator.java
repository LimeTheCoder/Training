package com.limethecoder.pos.controller.validator;


import com.limethecoder.pos.model.Product;

import java.util.Collections;
import java.util.Set;

public class ProductValidator implements Validator<String> {
    private Set<String> availableProducts =
            Collections.unmodifiableSet(Product.getProductNames());

    @Override
    public boolean isValid(String product) {
        return availableProducts.contains(product.toUpperCase());
    }
}
