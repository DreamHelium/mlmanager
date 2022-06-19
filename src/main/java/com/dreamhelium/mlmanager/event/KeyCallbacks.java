package com.dreamhelium.mlmanager.event;

import com.dreamhelium.mlmanager.config.Configs;
import com.dreamhelium.mlmanager.config.Hotkeys;
import com.dreamhelium.mlmanager.gui.GuiConfigs;
import com.dreamhelium.mlmanager.gui.GuiMainMenu;
import fi.dy.masa.malilib.config.options.ConfigString;
import fi.dy.masa.malilib.gui.GuiBase;
import fi.dy.masa.malilib.hotkeys.IHotkeyCallback;
import fi.dy.masa.malilib.hotkeys.IKeybind;
import fi.dy.masa.malilib.hotkeys.KeyAction;
import fi.dy.masa.malilib.hotkeys.KeyCallbackToggleBooleanConfigWithMessage;
import fi.dy.masa.malilib.interfaces.IValueChangeCallback;
import net.minecraft.client.MinecraftClient;

public class KeyCallbacks {
    public static void init(MinecraftClient mc){
        IHotkeyCallback callbackHotkeys = new KeyCallbackHotkeys(mc);
        IHotkeyCallback callbackMessage = new KeyCallbackToggleMessage(mc);
        ValueChangeCallback valueChangeCallback = new ValueChangeCallback();

        Hotkeys.OPEN_GUI_SETTINGS.getKeybind().setCallback(callbackHotkeys);
        Hotkeys.OPEN_GUI_MAIN_MENU.getKeybind().setCallback(callbackHotkeys);
        Hotkeys.SHOW_ON_CRAFT_TABLE_TOGGLE.getKeybind().setCallback(new KeyCallbackToggleBooleanConfigWithMessage(Configs.Generic.ENABLE_SHOWING_ON_CRAFT_TABLE));
    }


    private static class ValueChangeCallback implements IValueChangeCallback<ConfigString>{
        @Override
        public void onValueChanged(ConfigString config) {

        }
    }
    private static class KeyCallbackHotkeys implements IHotkeyCallback{

        private final MinecraftClient mc;

        public KeyCallbackHotkeys(MinecraftClient mc){
            this.mc = mc;
        }
        @Override
        public boolean onKeyAction(KeyAction action, IKeybind key) {
            if(key == Hotkeys.OPEN_GUI_SETTINGS.getKeybind()) {
                GuiBase.openGui(new GuiConfigs());
                return true;
            }
            else if (key == Hotkeys.OPEN_GUI_MAIN_MENU.getKeybind()){
                GuiBase.openGui(new GuiMainMenu());
                return true;
            }
            return false;
        }
    }

    private static class KeyCallbackToggleMessage implements IHotkeyCallback {
        private final MinecraftClient mc;

        public KeyCallbackToggleMessage(MinecraftClient mc) {
            this.mc =mc;
        }

        @Override
        public boolean onKeyAction(KeyAction action, IKeybind key) {
            return false;
        }
    }
}
