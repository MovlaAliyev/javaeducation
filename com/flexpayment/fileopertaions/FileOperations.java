package com.flexpayment.fileopertaions;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


/**
 * @author mhaliyev
 * FileOperations class is responsible for move file, checking moved file, and delete file from old directory
 */

public class FileOperations extends IFOperations {

    private List<File> checkedErrorFiles;
    private List<File> checkedSuccessFiles;

    
    // default constructor
    public FileOperations() {
        
    }

    /**
     * decide to move file to success or error folder
     * if key is KEYS.ERROR move to error
     * if key is KEYS.SUCCESS move to success
     * 
     * @param files xml files list in map format
     */
    @Override
    public void move(Map<String, File> files) {
        Iterator iter = files.entrySet().iterator();
        while(iter.hasNext()){
            Map.Entry<String, File> mape = (Map.Entry<String, File>)iter.next();
            
            if(mape.getKey().equals("SUCCESS")){
                moveToSuccess(mape.getValue());
            }else if(mape.getKey().equals("ERROR")){
                moveToError(mape.getValue());
            } 
            
            iter.remove();
        }
        
    }


    
   

}
