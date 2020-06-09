package com.cumulus.shapes.impl;

import com.cumulus.shapes.api.Position;
import com.cumulus.shapes.api.Shape;

/**
 * @author <Wtoll> Will Toll on 2020-06-07
 * @project Shapes
 */
public class Shapes {

    public static Shape rectangle(float w, float d) {
        return Shape.of(
                (pos) -> pos.getY() > 0 && pos.getY() <= 1,
                Position.of(w/2, 0, d/2),
                Position.of(-w/2, 0, -d/2)
        );
    }

    public static Shape ellipse(float a, float b) {
        return Shape.of(
                (pos) -> ((pos.getX() * pos.getX())/(a * a)) + ((pos.getZ() * pos.getZ())/(b * b)) < 1 && pos.getY() > 0 && pos.getY() < 1,
                Position.of(a, 0, b),
                Position.of(-a, 0, -b)
        );
    }
    



    public static Shape ellipticalPrism(float a, float b, float height) {
        return Shape.of(
                (pos) -> ((pos.getX() * pos.getX())/(a * a)) + ((pos.getZ() * pos.getZ())/(b * b)) < 1 && pos.getY() > -height/2 && pos.getY() < height/2,
                Position.of(a, height/2, b),
                Position.of(-a, -height/2, -b)
        );
    }

    public static Shape rectanglarPrism(float width, float height, float depth) {
        return Shape.of(
                (pos) -> pos.getX() > -width/2 && pos.getX() < width/2 && pos.getY() > -height/2 && pos.getY() < height/2 && pos.getZ() > -depth/2 && pos.getZ() < depth/2,
                Position.of(width/2, height/2, depth/2),
                Position.of(-width/2, -height/2, -depth/2)
        );
    }

    public static Shape triangularPrism(float width, float height, float depth) {
        return Shape.of(
                (pos) -> pos.getX() > -width/2 && pos.getX() < width/2 && pos.getY() > -height/2 && pos.getY() < height/2 && pos.getZ() > -(depth*(1-((pos.getY()+height/2)/height)))/2 && pos.getZ() < (depth*(1-((pos.getY()+height/2)/height)))/2,
                Position.of(width/2, height/2, depth/2),
                Position.of(-width/2, -height/2, -depth/2)
        );
    }





    public static Shape rectangularPyramid(float width, float height, float depth) {
        return Shape.of(
                (pos) -> pos.getX() > -(width*(1-(pos.getY()/height)))/2 && pos.getX() < (width*(1-(pos.getY()/height)))/2 && pos.getY() > 0 && pos.getY() < height && pos.getZ() > -(depth*(1-(pos.getY()/height)))/2 && pos.getZ() < (depth*(1-(pos.getY()/height)))/2,
                Position.of(width/2, height, depth/2),
                Position.of(-width/2, 0, -depth/2)
        );
    }

    public static Shape ellipticalPyramid(float a, float b, float height) {
        return Shape.of(
                (pos) -> ((pos.getX() * pos.getX())/((a*(1-(pos.getY()/height))) * (a*(1-(pos.getY()/height))))) + ((pos.getZ() * pos.getZ())/((b*(1-(pos.getY()/height))) * (b*(1-(pos.getY()/height))))) < 1 && pos.getY() > 0 && pos.getY() < height,
                Position.of(a, height, b),
                Position.of(-a, 0, -b)
        );
    }


    public static Shape ellipsoid(float a, float b, float c) {
        return Shape.of(
                (pos) -> ((pos.getX() * pos.getX())/(a * a)) + ((pos.getZ() * pos.getZ())/(b * b)) + ((pos.getY() * pos.getY())/(c * c)) < 1,
                Position.of(a, b, c),
                Position.of(-a, -b, -c)
        );
    }

}
