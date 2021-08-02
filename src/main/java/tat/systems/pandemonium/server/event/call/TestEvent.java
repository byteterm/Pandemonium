package tat.systems.pandemonium.server.event.call;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.eventbus.api.Event;

public class TestEvent extends Event {

    private final PlayerEntity player;

    public TestEvent(PlayerEntity player) {
        this.player = player;
    }

    public PlayerEntity getPlayer() {
        return player;
    }
}
