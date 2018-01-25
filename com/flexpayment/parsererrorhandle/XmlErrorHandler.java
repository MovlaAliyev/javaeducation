/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flexpayment.parsererrorhandle;

import java.io.File;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

/**
 *
 * @author mhaliyev
 */
public class XmlErrorHandler implements ErrorHandler{

    private File file;

    public XmlErrorHandler() {
    }
    
    
    public XmlErrorHandler(File file) {
        this.file = file;
    }

    
    @Override
    public void warning(SAXParseException exception) throws SAXException {
    }

    @Override
    public void error(SAXParseException exception) throws SAXException {
    }

    @Override
    public void fatalError(SAXParseException exception) throws SAXException {
    }
    
    public File getFile(){
        return file;
    }
    
}
