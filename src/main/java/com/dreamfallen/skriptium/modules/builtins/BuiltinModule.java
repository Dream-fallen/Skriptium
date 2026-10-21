package com.dreamfallen.skriptium.modules.builtins;

import com.dreamfallen.skriptium.modules.Module;

public class BuiltinModule implements Module {

    private final String name;

    public BuiltinModule(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
