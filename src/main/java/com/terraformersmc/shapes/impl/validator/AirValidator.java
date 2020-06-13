package com.terraformersmc.shapes.impl.validator;

import com.terraformersmc.shapes.api.validator.AllMeetValidator;
import com.terraformersmc.shapes.api.Position;
import net.minecraft.world.World;

/**
 * @author <Wtoll> Will Toll on 2020-06-07
 * @project Shapes
 */
public class AirValidator extends AllMeetValidator {

    private final World world;

    public AirValidator(World world) {
        this.world = world;
    }

    public static AirValidator of(World world) {
        return new AirValidator(world);
    }

    @Override
    public boolean test(Position position) {
        return world.isAir(position.toBlockPos());
    }
}
