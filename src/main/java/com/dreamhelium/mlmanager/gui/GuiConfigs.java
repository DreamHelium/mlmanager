package com.dreamhelium.mlmanager.gui;

import com.dreamhelium.mlmanager.Reference;
import com.dreamhelium.mlmanager.config.Configs;
import com.dreamhelium.mlmanager.config.Hotkeys;
import fi.dy.masa.malilib.MaLiLibConfigGui;
import fi.dy.masa.malilib.config.IConfigBase;
import fi.dy.masa.malilib.config.options.ConfigBoolean;
import fi.dy.masa.malilib.gui.GuiBase;
import fi.dy.masa.malilib.gui.GuiConfigsBase;
import fi.dy.masa.malilib.gui.button.ButtonBase;
import fi.dy.masa.malilib.gui.button.ButtonGeneric;
import fi.dy.masa.malilib.gui.button.IButtonActionListener;
import fi.dy.masa.malilib.util.StringUtils;

import java.util.Collections;
import java.util.List;

public class GuiConfigs extends GuiConfigsBase {

    public static ConfigGuiTab getConfigGuiTab() {
        return configGuiTab;
    }

    public static void setConfigGuiTab(ConfigGuiTab tab) {
        GuiConfigs.configGuiTab = tab;
    }

    private static ConfigGuiTab configGuiTab = ConfigGuiTab.GENERIC;

    public GuiConfigs(){
        super(10,50, Reference.MOD_ID,null,"mlmanager.gui.title.configs");
    }

    public List<ConfigOptionWrapper> getConfigs(){
        List<? extends IConfigBase> configs;
        ConfigGuiTab tab = getConfigGuiTab();
        if(tab == ConfigGuiTab.GENERIC) {
            configs = Configs.Generic.OPTIONS;
        }
        else if (tab == ConfigGuiTab.HOTKEYS) {
            configs = Hotkeys.HOTKEY_LIST;
        }
        else return Collections.emptyList();
        return  ConfigOptionWrapper.createFor(configs);
    }

    @Override
    public void initGui(){
        super.initGui();
        this.clearOptions();

        int x = 10;
        int y = 26;
        x += this.createButton(x,y,-1,ConfigGuiTab.GENERIC);
        x += this.createButton(x,y,-1,ConfigGuiTab.HOTKEYS);
    }

    private int createButton(int x, int y ,int width,ConfigGuiTab tab){
        ButtonGeneric button = new ButtonGeneric(x,y,width,20,tab.getDisplayName());
        button.setEnabled(getConfigGuiTab() != tab);
        this.addButton(button,new ButtonListener(tab,this));

        return button.getWidth() + 2;
    }


    public enum ConfigGuiTab{

        GENERIC ("mlmanager.gui.button.config_gui.generic"),
        HOTKEYS ("mlmanager.gui.button.config_gui.hotkeys");

        private final String translationKey;

        private ConfigGuiTab(String translationKey) {
            this.translationKey = translationKey;
        }

        public String getDisplayName(){
            return StringUtils.translate(this.translationKey);
            //return this.translationKey;
        }
    }

    private static class ButtonListener implements IButtonActionListener{
        private final GuiConfigs parent;

        private final  ConfigGuiTab tab;

        public ButtonListener(ConfigGuiTab tab,GuiConfigs parent)
        {
            this.tab = tab;
            this.parent = parent;
        }

        @Override
        public void actionPerformedWithButton(ButtonBase button, int mouseButton) {
            setConfigGuiTab(this.tab);
            this.parent.reCreateListWidget();
            this.parent.getListWidget().resetScrollbarPosition();
            this.parent.initGui();
        }
    }
}
