package com.mygroup.myclassloader;

import org.apache.commons.io.monitor.FileAlterationMonitor;
import org.apache.commons.io.monitor.FileAlterationObserver;

import java.io.File;

public class Application {

    public static String rootPath;

    public  static void run(Class<?> clazz) throws Exception{

//        String rootPath = MyClassLoader.class.getResource("/").getPath().replaceAll("%20"," ");
        String rootPath = MyClassLoader.class.getResource("").getPath().replaceAll("%20"," ");
        rootPath = new File(rootPath).getPath();
        Application.rootPath = rootPath;
        MyClassLoader myClassLoader = new MyClassLoader(rootPath,rootPath);
        //用我们自己的类加载器加载程序入口
        start0(myClassLoader);
    }


    public static void start0(MyClassLoader classLoader) throws Exception {
        Class<?> aClass = classLoader.loadClass("com.mygroup.myclassloader.Application");
        aClass.getMethod("start").invoke(aClass.newInstance());
    }


    //新的classload
    public static void start(){
            System.out.println("启动我们的应用程序");
            new Test().test();
    }



}
