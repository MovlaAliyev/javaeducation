/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flexpaymet.parse;

import com.flexpayment.parsererrorhandle.XmlErrorHandler;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/**
 *
 * @author mhaliyev
 */

public class XmlParser extends Parser{

    private Map<String, File> parsedFiles = new HashMap<>();
    
    @Override
    public void parse(List<File> xmlFiles) {
        for(File f: xmlFiles){
            parseXML(f);
        }
    }
    
    private void parseXML(File f){
        Document doc = null;
        try {
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            builderFactory.setValidating(false);
            builderFactory.setNamespaceAware(true);
            
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            builder.setErrorHandler(new XmlErrorHandler());
            
            doc = builder.parse(f);
            doc.getDocumentElement().normalize();
            
            
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            Logger.getLogger(XmlParser.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    
}
