package com.demo.project62.proxy.other;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

interface Command {
    public void runCommand(String cmd);
}

public class Main {

    public static void main(String[] args) {
        Command cmd = (Command) CommandProxy.newInstance(new CommandImpl());
        cmd.runCommand("ls");
        cmd.runCommand("rm");
    }

}

class CommandImpl implements Command {

    @Override
    public void runCommand(String cmd) {
        System.out.println("Running : " + cmd);
    }
}

class CommandProxy implements InvocationHandler {
    private Object obj;

    private CommandProxy(Object obj) {
        this.obj = obj;
    }

    public static Object newInstance(Object obj) {
        return java.lang.reflect.Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(),
                new CommandProxy(obj));
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result;
        try {
            if (args[0].equals("rm")) {
                throw new IllegalAccessException("rm command not allowed");
            } else {
                result = method.invoke(obj, args);
            }
            return result;
        } catch (InvocationTargetException ex) {
            throw ex.getTargetException();
        } catch (Exception ex) {
            throw new RuntimeException("invocation exception " + ex.getMessage());
        }
    }

}
