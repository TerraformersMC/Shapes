package com.terraformersmc.shapes.api.validator;

import com.terraformersmc.shapes.api.Shape;

/**
 * @author <Wtoll> Will Toll on 2020-06-07
 * @project Shapes
 */
public interface Validator {
    boolean validate(Shape shape);
}
