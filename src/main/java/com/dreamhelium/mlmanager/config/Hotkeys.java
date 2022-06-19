package com.dreamhelium.mlmanager.config;

import com.dreamhelium.mlmanager.config.options.MlmanagerConfigHotkey;
import com.google.common.collect.ImmutableList;
import fi.dy.masa.malilib.config.options.ConfigHotkey;

import java.util.List;

public class Hotkeys {
    public static final MlmanagerConfigHotkey OPEN_GUI_SETTINGS = new MlmanagerConfigHotkey("openGuiSettings","N,C");
    public static final MlmanagerConfigHotkey SHOW_ON_CRAFT_TABLE_TOGGLE = new MlmanagerConfigHotkey("showOnCraftTableToggle","COMMA");
    public static final MlmanagerConfigHotkey OPEN_GUI_MAIN_MENU = new MlmanagerConfigHotkey("openGuiMainMenu","N");

    public static final List<ConfigHotkey> HOTKEY_LIST = ImmutableList.of(
            OPEN_GUI_SETTINGS,
            SHOW_ON_CRAFT_TABLE_TOGGLE,
            OPEN_GUI_MAIN_MENU
    );


}
