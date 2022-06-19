package com.dreamhelium.mlmanager.config.options;

import fi.dy.masa.malilib.config.options.ConfigHotkey;

public class MlmanagerConfigHotkey extends ConfigHotkey implements IMlmanagerConfigBase {

    public MlmanagerConfigHotkey(String name,String defaultStorageString,String comment){
        super(name,defaultStorageString,comment);
    }

    public MlmanagerConfigHotkey(String name,String defaultStorageString){
        super(name,defaultStorageString,HOTKEY_PREFIX + name + ".comment");
    }

}
