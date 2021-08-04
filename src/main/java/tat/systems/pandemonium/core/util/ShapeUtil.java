package tat.systems.pandemonium.core.util;

import net.minecraft.util.Direction;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;

import java.util.Map;

public class ShapeUtil {

    private static void calcShapes(Direction direction, VoxelShape shape, Map<Direction, VoxelShape> SHAPES) {
        VoxelShape[] buffer = new VoxelShape[] {shape, VoxelShapes.empty()};

        int times = (direction.getHorizontalIndex() - Direction.NORTH.getHorizontalIndex() + 4) % 4;
        for(int i = 0; i < times; i++) {
            buffer[0].forEachBox((minX, minY, minZ, maxX, maxY, maxZ) -> buffer[1] = VoxelShapes.or(buffer[1],
                    VoxelShapes.create(1 - maxZ, minY, minX, 1 - minZ, maxY, maxX)));
            buffer[0] = buffer[1];
            buffer[1] = VoxelShapes.empty();
        }

        SHAPES.put(direction, buffer[0]);
    }

    public static void runCalc(VoxelShape shape, Map<Direction, VoxelShape> SHAPES) {
        for(Direction directions : Direction.values()) {
            calcShapes(directions, shape, SHAPES);
        }
    }

}
