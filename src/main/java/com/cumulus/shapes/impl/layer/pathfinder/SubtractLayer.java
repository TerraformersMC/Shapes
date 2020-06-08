package com.cumulus.shapes.impl.layer.pathfinder;

import com.cumulus.shapes.api.Position;
import com.cumulus.shapes.api.Shape;
import com.cumulus.shapes.api.layer.PathfinderLayer;

import java.util.function.Predicate;

/**
 * @author <Wtoll> Will Toll on 2020-06-07
 * @project Shapes
 */
public class SubtractLayer extends PathfinderLayer {

    private final Shape shape;

    public SubtractLayer(Shape shape) {
        this.shape = shape;
    }

    @Override
    public Position modifyMax(Shape shape) {
        return shape.max();
    }

    @Override
    public Position modifyMin(Shape shape) {
        return shape.min();
    }

    @Override
    public Predicate<Position> modifyEquation(Shape shape) {
        return (pos) -> shape.equation().test(pos) && !this.shape.equation().test(pos);
    }
}
