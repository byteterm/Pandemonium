package tat.systems.pandemonium.common.event;

import net.minecraft.block.BlockState;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.EntityStruckByLightningEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import tat.systems.pandemonium.Pandemonium;
import tat.systems.pandemonium.core.util.Location;

import java.util.Objects;

@Mod.EventBusSubscriber(modid = Pandemonium.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class DemoniumCrystalChargeEvent {

    @SubscribeEvent
    public static void onChargeEvent(EntityStruckByLightningEvent event) {
        if(event.getEntity() instanceof ItemEntity) {
            ItemEntity entity = (ItemEntity) event.getEntity();
            ItemStack stack = entity.getItem();
            Location location = new Location(entity.getEntityWorld(), entity.getPosX(), entity.getPosY(), entity.getPosZ());
            ResourceLocation resourceLocation = new ResourceLocation("pandemonium", "demonium_crystal");

            if(Objects.equals(stack.getItem().getRegistryName(), resourceLocation)) {
                if(checkStructure(location)) {
                    //MinecraftForge.EVENT_BUS.post(new TestEvent());
                    /*
                    ItemEntity test = new ItemEntity(location.getWorld(), location.getX(), location.getY(), location.getZ()
                            , new ItemStack(new Item()));

                     */
                    event.setCanceled(true);
                }
            }
        }
    }

    private static boolean checkStructure(Location location) {
        World world = location.getWorld();
        BlockPos pos = new BlockPos(location.getX(), location.getY() - 1, location.getZ());
        BlockState state = world.getBlockState(pos);
        return Objects.equals(state.getBlock().getRegistryName(), new ResourceLocation("minecraft", "polished_andesite"));
    }

}
