package com.limethecoder.pos.controller.validator;


import com.limethecoder.pos.model.Product;

import java.util.Collections;
import java.util.Set;

public class ProductValidator implements Validator<String> {
    private final static Set<String> AVAILABLE_PRODUCTS =
            Collections.unmodifiableSet(Product.getProductNames());

    @Override
    public boolean isValid(String product) {
        return AVAILABLE_PRODUCTS.contains(product.toUpperCase());
    }
}
