package org.mossmc.mosscg.MossFrpForgeSuport;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import org.apache.logging.log4j.Logger;

@Mod(
        modid = "mossfrpforgesupport",
        name = "MossFrp Forge Support",
        version = "1.0"
)
public class MossFrpForgeSupport {

    public static Logger logger;
    public static EntityPlayer player;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        System.out.println("Loaded MossFrp forge support mod!");
    }

    @EventHandler
    public void onServerStarting(FMLServerStartingEvent event) {
        event.registerServerCommand(new MossFrpForgeCommand());
    }

    @SuppressWarnings("unused")
    public static void forgeExit() {
        FMLCommonHandler.instance().exitJava(0,false);
    }

    @SuppressWarnings("unused")
    public static void sendPlayer(String info) {
        if (player != null) {
            try {
                String finalInfo = info.replaceAll("\r\n","\n");
                player.sendMessage(new TextComponentString(finalInfo));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
