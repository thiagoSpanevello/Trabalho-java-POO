package com.ciscos.project.utils;

import com.ciscos.project.Character;
import com.ciscos.project.frames.CharCreation;
import com.ciscos.project.frames.Creditos;
import com.ciscos.project.frames.Principal;

public class Context {
    private static Character session = null;
    private static Principal window = null;
    private static Creditos credits = null;
    private static CharCreation creation = null;
    
    private static boolean hasEverShopped = false;
    
    public static void setMainWindow(Principal window) {
        if(Context.window != null) return;
        Context.window = window;
    }
    
    public static Principal getMainWindow() {
        return window;
    }
    
    public static Character getSession() {
        return session;
    }

    public static void setSession(Character character) {
        if(Context.session != null) return;
        Context.session = character;
    }

    public static Creditos getCredits() {
        return credits;
    }

    public static void setCredits(Creditos credits) {
        Context.credits = credits;
    }

    public static CharCreation getCreation() {
        return creation;
    }

    public static void setCreation(CharCreation creation) {
        Context.creation = creation;
    }

    public static boolean hasEverShopped() {
        return hasEverShopped;
    }

    public static void setHasEverShopped(boolean hasEverShopped) {
        Context.hasEverShopped = hasEverShopped;
    }
    
    
}

