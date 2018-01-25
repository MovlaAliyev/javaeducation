package com.flexpayment.fileopertaions;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mhaliyev
 */

public abstract class IFOperations {
    
    // abstract method for moving file
    public abstract void move(Map<String, File> files);
    
    // move file to success folder
    protected void moveToSuccess(File f){
        Path from = Paths.get("");
        Path to   = Paths.get("");
        try {
            Files.move(from, to, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ex) {
            Logger.getLogger(IFOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // move file to error folder
    protected void moveToError(File f){
        Path from = Paths.get("");
        Path to   = Paths.get("");
        try {
            Files.move(from, to, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ex) {
            Logger.getLogger(IFOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
