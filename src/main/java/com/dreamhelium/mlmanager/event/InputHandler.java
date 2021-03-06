package com.dreamhelium.mlmanager.event;

import com.dreamhelium.mlmanager.Reference;
import com.dreamhelium.mlmanager.config.Hotkeys;
import fi.dy.masa.malilib.hotkeys.*;

public class InputHandler implements IKeybindProvider, IKeyboardInputHandler, IMouseInputHandler {

    private static final InputHandler INSTANCE = new InputHandler();

    private InputHandler(){}

    public static InputHandler getInstance(){return INSTANCE;}

    @Override
    public void addKeysToMap(IKeybindManager manager) {
        for(IHotkey hotkey : Hotkeys.HOTKEY_LIST)
        {
            manager.addKeybindToMap(hotkey.getKeybind());
        }
    }

    @Override
    public void addHotkeys(IKeybindManager manager) {
        manager.addHotkeysForCategory(Reference.MOD_NAME,"mlmanager.hotkeys.category.generic_hotkeys",Hotkeys.HOTKEY_LIST);
    }


}
