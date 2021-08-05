package tat.systems.pandemonium.common.event;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import tat.systems.pandemonium.Pandemonium;
import tat.systems.pandemonium.common.event.call.TestEvent;

@Mod.EventBusSubscriber(modid = Pandemonium.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class AEvent {

    @SubscribeEvent
    public static void onTest(TestEvent event) {
        System.out.println("Gut Man!");
    }
}
