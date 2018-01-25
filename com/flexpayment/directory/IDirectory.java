/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flexpayment.directory;

import java.io.File;
import java.util.List;

/**
 *
 * @author mhaliyev
 */
public interface IDirectory {
    // check directory for xml files
    public List<File> checkDirectory();
    
    // setter and getter for director path
    public void setPath(String path);
    public String getPath();
}
