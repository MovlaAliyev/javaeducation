/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flexpayment.directory;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mhaliyev
 */
public class Directory implements IDirectory{

    
    private String path;

    
    
    public Directory() {
    }

    public Directory(String path) {
        this.path = path;
    }
    
    
    
    @Override
    public List<File> checkDirectory() {
        
        File files = new File(getPath());
        String[] fileList = files.list();
        List<File> xmlFiles = new ArrayList<>();
        
        // if directory is empty return empty list
        if(fileList == null) return xmlFiles;
        
        for (String filename : fileList) {
            File file = new File(getPath() + filename);
            if(!file.isDirectory()) {
                if(isXML(file)) {
                    xmlFiles.add(file);
                }
            }
        }
        return xmlFiles;
    }
    
    private boolean isXML(File file){
        return file.getName().endsWith(".xml");
    }

    @Override
    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String getPath() {
        return path;
    }
    
}
