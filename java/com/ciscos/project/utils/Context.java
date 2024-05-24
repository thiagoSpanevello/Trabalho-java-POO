package com.ciscos.project.utils;

import com.ciscos.project.Character;
import com.ciscos.project.frames.Principal;

public class Context {
    private static Player session = null;
    private static Principal window = null;
    
    public static void setMainWindow(Principal window) {
        if(Context.window != null) return;
        Context.window = window;
    }
    
    public static Principal getMainWindow() {
        return window;
    }
    
    public static Player getSession() {
        return session;
    }

    public static void setSession(Character character) {
        if(Context.session != null) return;
        Context.session = new Player(character);
    }
}

