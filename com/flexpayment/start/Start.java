package com.flexpayment.start;

import com.flexpayment.directory.Directory;
import com.flexpaymet.parse.Parser;
import com.flexpaymet.parse.XmlParser;
import java.io.File;
import java.util.List;

/**
 *
 * @author mhaliyev
 */

public class Start implements Runnable{

    private Directory d;

    public Start(String path) {
        d = new Directory(path);
    }
    
    @Override
    public void run() {
        System.out.println("here");
        List<File> xmlList = null;
        Parser xmlParser = new XmlParser();
        while(true){
            xmlList = d.checkDirectory();
            if(!xmlList.isEmpty()) {
                xmlParser.parse(xmlList);
            }
            else System.out.println("Not exist");
        }
    }
    
    
}
