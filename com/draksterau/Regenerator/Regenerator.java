/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.draksterau.Regenerator;

/**
 *
 * @author draks
 */
import com.draksterau.Regenerator.tasks.regenTask;
import java.util.concurrent.TimeUnit;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.game.state.GameStartedServerEvent;
import org.spongepowered.api.plugin.Plugin;
import org.spongepowered.api.text.Text;
@Plugin(id = "Regenerator", name = "Regenerator", version = "1.0.0")
public class Regenerator {
    
    public static Regenerator instance;
    
    @Listener
    public void onServerStart(GameStartedServerEvent event) {
        
        
        // Hey! The server has started!
        // Try instantiating your logger in here.
        // (There's a guide for that)
        sendMessageToConsole("Plugin Started");
        Sponge.getScheduler()
                .createTaskBuilder()
                .execute(new regenTask())
                .delay(1, TimeUnit.SECONDS)
                .interval(1, TimeUnit.MINUTES)
                .async()
                .submit(this);
        instance = this;
    }
    
    public void sendMessageToConsole(String text) {
        Sponge.getServer().getConsole().sendMessage(Text.of(text));
    }
    public static Regenerator getInstance() {
        return instance;
    }
}
