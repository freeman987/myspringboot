package com.mygroup.myclassloader;

import org.apache.commons.io.monitor.FileAlterationMonitor;
import org.apache.commons.io.monitor.FileAlterationObserver;
import org.springframework.boot.autoconfigure.web.ServerProperties;

import java.io.File;

public class Application1 {

    public static String rootPath;

    public  static void run(Class<?> clazz) throws Exception{

//      String rootPath = MyClassLoader.class.getResource("/").getPath().replaceAll("%20"," ");
        String rootPath = MyClassLoader.class.getResource("").getPath().replaceAll("%20"," ");
        rootPath = new File(rootPath).getPath();
        Application1.rootPath = rootPath;
        MyClassLoader myClassLoader = new MyClassLoader(rootPath,rootPath);

        startFileListener(rootPath);

        //用我们自己的类加载器加载程序入口
        start0(myClassLoader);
    }


    public static void start0(MyClassLoader classLoader) throws Exception {
        Class<?> aClass = classLoader.loadClass("com.mygroup.myclassloader.Application1");
        aClass.getMethod("start").invoke(aClass.newInstance());
    }


    //新的classload
    public static void start(){
//        while(true){
            System.out.println("启动我们的应用程序");
        //ServerProperties.Tomcat tomcat =new ServerProperties.Tomcat();
            new Test().test();
//        }
    }

    public static void stop0(){
        System.out.println("程序退出");
        //告诉jvm需要gc了。
        System.gc();
        //告诉jvm可以清除对象引用。
        System.runFinalization();
    }

    public static void startFileListener(String rootPath) throws Exception {
        FileAlterationObserver fileAlterationObserver =
                new FileAlterationObserver(rootPath);
        fileAlterationObserver.addListener(new FileListener());

        FileAlterationMonitor fileAlterationMonitor=
                new FileAlterationMonitor(500);

        fileAlterationMonitor.addObserver(fileAlterationObserver);
        fileAlterationMonitor.start();
    }


}
