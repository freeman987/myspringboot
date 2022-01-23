package com.mygroup.myclassloader;

import org.apache.commons.io.monitor.FileAlterationListener;
import org.apache.commons.io.monitor.FileAlterationListenerAdaptor;

import java.io.File;

public class FileListener extends FileAlterationListenerAdaptor {
    @Override
    public void onFileChange(File file) {
        if(file.getName().indexOf(".class")!=-1){

            try{
                MyClassLoader myClassLoader =
                    new MyClassLoader(Application1.rootPath,Application1.rootPath);
                Application1.stop0();//先stop再start，模拟重启
                Application1.start0(myClassLoader);
            }catch (Exception e){

            }


        }
    }
}
