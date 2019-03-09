//package com.smart.resource;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.annotation.Resource;

import org.springframework.core.io.*;

public class FileSourceExample{
    public static void main(String[] args){
        try{

            String filePath="./files/t01.md";

            
            //使用系统文件路径方式加载文件
            PathResource res1=new PathResource(filePath);

            //使用类路径方式加载文件
            ClassPathResource res2=new ClassPathResource("files/t01.md");

            //使用WriteableResource接口写资源文件
            OutputStream stream1=res1.getOutputStream();
            stream1.write("world".getBytes());
            stream1.close();

            //使用Resource接口读资源文件
            InputStream ins1=res1.getInputStream();
            InputStream ins2=res2.getInputStream();


            ByteArrayOutputStream baos=new ByteArrayOutputStream();
            int i;
            while((i=ins2.read())!=-1){
                baos.write(i);
            }
            System.out.println(baos.toString());
            System.out.println("res1: "+res1.getFilename());
            System.out.println("res2: "+res2.getFilename());

        }catch(IOException e){
            e.printStackTrace();
        }
    }
}