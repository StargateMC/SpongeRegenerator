/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.draksterau.Regenerator.tasks;

import com.draksterau.Regenerator.Regenerator;
import java.util.Optional;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.plugin.PluginContainer;
import org.spongepowered.api.world.Chunk;
import org.spongepowered.api.world.World;
import org.spongepowered.api.world.storage.ChunkDataStream;
import org.spongepowered.api.world.storage.WorldStorage;

/**
 *
 * @author draks
 */
public class regenTask implements Runnable {
    
    static Regenerator plugin = Regenerator.getInstance();

    @Override
    public void run() {
        for (World w : Sponge.getGame().getServer().getWorlds()) {
            WorldStorage ws = w.getWorldStorage();
            ChunkDataStream cds = ws.getGeneratedChunks();
            while (cds.hasNext()) {
                DataContainer data = cds.next();
                Chunk chunk = (Chunk) data;
                if (chunk != null) plugin.sendMessageToConsole("Found chunk: " + chunk.toString());
            }
        }
    }
    
}