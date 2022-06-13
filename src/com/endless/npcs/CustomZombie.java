package com.endless.npcs;

import java.lang.reflect.Field;
import java.util.List;

import org.bukkit.craftbukkit.v1_8_R3.CraftWorld;

import net.minecraft.server.v1_8_R3.EntityZombie;
import net.minecraft.server.v1_8_R3.PathfinderGoalFloat;
import net.minecraft.server.v1_8_R3.PathfinderGoalSelector;

public class CustomZombie extends EntityZombie
{
    @SuppressWarnings("rawtypes")
	public CustomZombie(String name, org.bukkit.World world) //You can also directly use the nms world class but this is easier if you are spawning this entity.
    {
        super(((CraftWorld)world).getHandle());
        
        List goalB = (List)getPrivateField("b", PathfinderGoalSelector.class, goalSelector); goalB.clear();
        List goalC = (List)getPrivateField("c", PathfinderGoalSelector.class, goalSelector); goalC.clear();
        List targetB = (List)getPrivateField("b", PathfinderGoalSelector.class, targetSelector); targetB.clear();
        List targetC = (List)getPrivateField("c", PathfinderGoalSelector.class, targetSelector); targetC.clear();
        this.goalSelector.a(0, new PathfinderGoalFloat(this));
        
        this.setCustomName("");
        this.setCustomNameVisible(false);
    }
    
    public static Object getPrivateField(String fieldName, Class clazz, Object object)
    {
        Field field;
        Object o = null;

        try
        {
            field = clazz.getDeclaredField(fieldName);

            field.setAccessible(true);

            o = field.get(object);
        }
        catch(NoSuchFieldException e)
        {
            e.printStackTrace();
        }
        catch(IllegalAccessException e)
        {
            e.printStackTrace();
        }

        return o;
    }
    
    @Override
    public void g(double d0, double d1, double d2) {
    	
    }
    @Override
    public void m() {

    }
    
}