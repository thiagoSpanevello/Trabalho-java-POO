package com.ciscos.project.utils;

import com.ciscos.project.Character;

public class Context {
    private static Player session = null;
    
    public static Player getSession() {
        return session;
    }

    public static void setSession(Character character) {
        if(Context.session != null) return;
        Context.session = new Player(character);
    }
}

