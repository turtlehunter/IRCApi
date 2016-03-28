package me.urielsalis.IRCApi;


import me.urielsalis.IRCApi.events.*;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * me.urielsalis.IRCApi - uriel IRCApi 26/3/2016
 */
public class EventManager {
    public static HashMap<Method, EventHandler> listeners = new HashMap<>();
    public static HashMap<Method, Command> commands = new HashMap<>();
    public static String commandPrefix = "/";

    public static void addClass(Class clazz) {
        Set<Field> set = new HashSet<>();
        Class<?> c = clazz;
        while (c != null) {
            for (Method method : c.getDeclaredMethods()) {
                if (method.isAnnotationPresent(EventHandler.class)) {
                    listeners.put(method, method.getAnnotation(EventHandler.class));
                } else if(method.isAnnotationPresent(Command.class)) {
                    commands.put(method, method.getAnnotation(Command.class));
                }
            }
            c = c.getSuperclass();
        }
    }

    public static void raise(Event event) {
        for(Map.Entry<Method, EventHandler> entry: listeners.entrySet()) {
            if(entry.getValue().value().contains(event.getName())) {
                try {
                    entry.getKey().invoke(entry.getKey().getDeclaringClass().newInstance(), event);
                } catch (IllegalAccessException | InvocationTargetException | InstantiationException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void onMessage(OnPrivmsg event) {
        if(event.msg.startsWith(commandPrefix)) {
            String[] args = event.msg.split(" ");
            String[] pars;
            if(args.length > 1) {
                pars = Arrays.copyOfRange(args, 1, args.length);
            } else {
                pars = new String[]{};
            }
            for(Map.Entry<Method, Command> entry: commands.entrySet()) {
                if(entry.getValue().value().toLowerCase().equals(args[0].substring(1))) {
                    try {
                        entry.getKey().invoke(entry.getKey().getDeclaringClass().newInstance(), event, pars);
                    } catch (IllegalAccessException | InvocationTargetException | InstantiationException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void onMessage(OnNotice event) {
        if(event.msg.startsWith(commandPrefix)) {
            String[] args = event.msg.split(" ");
            String[] pars;
            if(args.length > 1) {
                pars = Arrays.copyOfRange(args, 1, args.length);
            } else {
                pars = new String[]{};
            }
            for(Map.Entry<Method, Command> entry: commands.entrySet()) {
                if(entry.getValue().value().contains(args[0].substring(1))) {
                    try {
                        entry.getKey().invoke(entry.getKey().getDeclaringClass().newInstance(), event, pars);
                    } catch (IllegalAccessException | InvocationTargetException | InstantiationException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
