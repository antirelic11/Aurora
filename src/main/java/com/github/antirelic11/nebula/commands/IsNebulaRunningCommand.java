package com.github.antirelic11.nebula.commands;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;
import org.apache.logging.log4j.LogManager;

public class IsNebulaRunningCommand extends CommandBase {
    @Override
    public String getCommandName() {
        return "isnebularunning";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "";
    }

    @Override
    public boolean canCommandSenderUseCommand(ICommandSender sender) {
        return true;
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) throws CommandException {
        LogManager.getLogger("IsNebulaRunningCommand").info("Self Explanatory.");
        sender.addChatMessage(new ChatComponentText("§aYes, obviously."));

    }
}
