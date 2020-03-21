package com.cacadosman.infocovid19.command.impl;

import com.cacadosman.infocovid19.command.*;
import com.cacadosman.infocovid19.helper.MessageHelper;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageReceiverCommandImpl implements MessageReceiverCommand {

    @Autowired
    InfoCommand infoCommand;
    @Autowired
    SubscribeCommand subscribeCommand;
    @Autowired
    UnsubscribeCommand unsubscribeCommand;
    @Autowired
    HelpCommand helpCommand;

    @Override
    public void execute(MessageReceivedEvent event) {
        String message = event.getMessage().getContentRaw();
        if (MessageHelper.isCommand(message)) {
            String command = MessageHelper.getParam(message, 1);
            passCommand(command, event);
        }
    }

    private void passCommand(String command, MessageReceivedEvent event) {
        switch (command) {
            case "info":
                infoCommand.execute(event);
                break;
            case "subscribe":
                subscribeCommand.execute(event);
                break;
            case "unsubscribe":
                unsubscribeCommand.execute(event);
                break;
            default:
                helpCommand.execute(event);
        }
    }
}
