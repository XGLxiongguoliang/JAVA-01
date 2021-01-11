package jikeshijian.jvm;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 *
 * @description 自定义一个 Classloader，加载一个 Hello.xlass 文件，执行 hello 方法，此文件内
 * 容是一个 Hello.class 文件所有字节（x=255-x）处理后的文件。文件群里提供
 * @auther Mr.Xiong
 * @create 2021-01-09 14:52
 */
public class HelloClassLoder extends ClassLoader {

    private static final String fileUrl = "C:\\software\\project\\learn-java\\learn-base\\src\\jikeshijian\\jvm";
    private static final String className = "Hello";
    private static final String methodName = "hello";
    private static final String suffix = "Hello.xlass";

    public static void main(String[] args) {
        try {
            Class<?> clazz = new HelloClassLoder().findClass(className);
            Method method = clazz.getDeclaredMethod(methodName);
            method.invoke(clazz.newInstance());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected Class<?> findClass(String name) {
        //获取文件字节数组
        byte[] bytes = fileToByteArray();
        //解密数组
        byte[] decodeBytes = decode(bytes);

        return defineClass(name, decodeBytes, 0, bytes.length);
    }

    //读取文件,返回字节数组
    private byte[] fileToByteArray(){
        byte[] bytes = null;
        InputStream is;
        try {
            is = new FileInputStream(fileUrl + File.separator + suffix);
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024 * 4];
            int n;
            while ((n = is.read(buffer)) != -1) {
                out.write(buffer, 0, n);
            }
            bytes = out.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return bytes;
    }

    private byte[] decode(byte[] bytes) {
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) (255 - bytes[i]);
        }
        return bytes;
    }
}
