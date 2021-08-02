package tat.systems.pandemonium.core.util;

import net.minecraft.world.World;

public class Location {

    private World world;
    private double x, y, z;
    private double yaw, pitch;

    public Location(World world, double x, double y, double z, double yaw, double pitch) {
        this.world = world;
        this.x = x;
        this.y = y;
        this.z = z;
        this.yaw = yaw;
        this.pitch = pitch;
    }

    public Location(Location location) {
        this(location.getWorld(), location.getX(), location.getY(), location.getZ(), location.getYaw(), location.getPitch());
    }

    public Location(World world, double x, double y, double z) {
        this(world, x, y, z, 0, 0);
    }

    public void setWorld(World world) {
        this.world = world;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public void setYaw(double yaw) {
        this.yaw = yaw;
    }

    public void setPitch(double pitch) {
        this.pitch = pitch;
    }

    public void add(int x, int y, int z) {
        //Todo: create this method
    }

    public World getWorld() {
        return world;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public double getYaw() {
        return yaw;
    }

    public double getPitch() {
        return pitch;
    }
}
