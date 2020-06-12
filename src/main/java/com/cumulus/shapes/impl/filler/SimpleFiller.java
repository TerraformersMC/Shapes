package com.cumulus.shapes.impl.filler;

import com.cumulus.shapes.api.Filler;
import com.cumulus.shapes.api.Position;
import net.minecraft.block.BlockState;
import net.minecraft.world.ModifiableWorld;

/**
 * @author <Wtoll> Will Toll on 2020-06-07
 * @project Shapes
 */
public class SimpleFiller implements Filler {

    private final ModifiableWorld world;
    private final BlockState state;

    public SimpleFiller(ModifiableWorld world, BlockState state) {
        this.world = world;
        this.state = state;
    }

    public static SimpleFiller of(ModifiableWorld world, BlockState state) {
        return new SimpleFiller(world, state);
    }

    @Override
    public void accept(Position position) {
        world.setBlockState(position.toBlockPos(), this.state, 0);
    }
}
