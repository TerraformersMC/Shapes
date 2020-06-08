package com.cumulus.shapes.impl.filler;

import com.cumulus.shapes.api.Filler;
import com.cumulus.shapes.api.Position;
import net.minecraft.block.BlockState;
import net.minecraft.world.World;

/**
 * @author <Wtoll> Will Toll on 2020-06-07
 * @project Shapes
 */
public class SimpleFiller implements Filler {

    private final World world;
    private final BlockState state;

    public SimpleFiller(World world, BlockState state) {
        this.world = world;
        this.state = state;
    }

    public static SimpleFiller of(World world, BlockState state) {
        return new SimpleFiller(world, state);
    }

    @Override
    public void accept(Position position) {
        world.setBlockState(position.toBlockPos(), this.state);
    }
}
