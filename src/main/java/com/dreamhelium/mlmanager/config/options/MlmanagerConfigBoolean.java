package com.dreamhelium.mlmanager.config.options;

import fi.dy.masa.malilib.config.options.ConfigBoolean;

public class MlmanagerConfigBoolean extends ConfigBoolean implements IMlmanagerConfigBase {

    public MlmanagerConfigBoolean(String name, Boolean defaultValue, String comment){
        super(name, defaultValue, comment);
    }

    public MlmanagerConfigBoolean(String name, Boolean defaultValue){
        super(name, defaultValue,CONFIG_PREFIX + name + ".comment");
    }

    public MlmanagerConfigBoolean(String name){
        super(name, false,CONFIG_PREFIX + name + ".comment");
    }
}
