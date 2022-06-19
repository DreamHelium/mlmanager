package com.dreamhelium.mlmanager.config.options;

import com.dreamhelium.mlmanager.MaterialListManager;
import fi.dy.masa.malilib.config.ConfigType;
import fi.dy.masa.malilib.config.IConfigBase;
import fi.dy.masa.malilib.config.options.ConfigHotkey;
import fi.dy.masa.malilib.util.StringUtils;

public interface IMlmanagerConfigBase extends IConfigBase {

    final String CONFIG_PREFIX = "mlmanager.config.";
    final String HOTKEY_PREFIX = "mlmanager.hotkey.";

    @Override
    default String getConfigGuiDisplayName() {
        if(this.getType() == ConfigType.HOTKEY) {;
            return StringUtils.translate(HOTKEY_PREFIX + this.getName());
        }
        else {
            MaterialListManager.LOGGER.info("config test!");
            return StringUtils.translate(CONFIG_PREFIX + this.getName());
        }

    }
}
