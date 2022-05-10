package org.mossmc.mosscg.MossFrpForgeSuport;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;

import java.lang.reflect.Method;

@SuppressWarnings("NullableProblems")
public class MossFrpForgeCommand extends CommandBase {
    @Override
    public String getName() {
        return "mossfrp";
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return "/mossfrp - MossFrp main command.";
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        try {
            Class<?> commandClass = Class.forName("org.mossmc.mosscg.MossFrp.Command.CommandForge");
            Method method = commandClass.getDeclaredMethod("commandForge", boolean.class, String[].class);
            method.invoke(commandClass.newInstance(),false,args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
