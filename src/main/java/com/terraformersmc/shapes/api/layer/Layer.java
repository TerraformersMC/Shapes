package com.cumulus.shapes.api.layer;

import com.cumulus.shapes.api.Position;
import com.cumulus.shapes.api.Shape;

import java.util.function.Predicate;

/**
 * @author <Wtoll> Will Toll on 2020-06-07
 * @project Shapes
 */
public interface Layer {
    Position modifyMax(Shape shape);

    Position modifyMin(Shape shape);

    Predicate<Position> modifyEquation(Shape shape);
}
