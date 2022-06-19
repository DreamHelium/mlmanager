package com.dreamhelium.mlmanager;

import com.dreamhelium.mlmanager.config.Configs;
import com.dreamhelium.mlmanager.event.InputHandler;
import com.dreamhelium.mlmanager.event.KeyCallbacks;
import fi.dy.masa.malilib.config.ConfigManager;
import fi.dy.masa.malilib.event.InputEventHandler;
import fi.dy.masa.malilib.interfaces.IInitializationHandler;
import net.minecraft.client.MinecraftClient;

public class InitHandler implements IInitializationHandler {
    @Override
    public void registerModHandlers() {

        ConfigManager.getInstance().registerConfigHandler(Reference.MOD_ID,new Configs());


        InputEventHandler.getKeybindManager().registerKeybindProvider(InputHandler.getInstance());
        InputEventHandler.getInputManager().registerKeyboardInputHandler(InputHandler.getInstance());
        InputEventHandler.getInputManager().registerMouseInputHandler(InputHandler.getInstance());

        KeyCallbacks.init(MinecraftClient.getInstance());
    }
}
