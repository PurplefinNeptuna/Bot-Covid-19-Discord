package com.cacadosman.infocovid19.command;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public interface HelpCommand {
    void execute(MessageReceivedEvent event);
}
