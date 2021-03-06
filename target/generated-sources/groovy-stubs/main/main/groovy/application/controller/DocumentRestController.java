package main.groovy.application.controller;

import java.lang.*;
import java.io.*;
import java.net.*;
import java.util.*;
import groovy.lang.*;
import groovy.util.*;

@org.springframework.web.bind.annotation.RestController() public class DocumentRestController
  extends java.lang.Object  implements
    groovy.lang.GroovyObject {
;
public  groovy.lang.MetaClass getMetaClass() { return (groovy.lang.MetaClass)null;}
public  void setMetaClass(groovy.lang.MetaClass mc) { }
public  java.lang.Object invokeMethod(java.lang.String method, java.lang.Object arguments) { return null;}
public  java.lang.Object getProperty(java.lang.String property) { return null;}
public  void setProperty(java.lang.String property, java.lang.Object value) { }
public  main.groovy.application.dao.DocTypeRepository getDocTypeRepository() { return (main.groovy.application.dao.DocTypeRepository)null;}
public  void setDocTypeRepository(main.groovy.application.dao.DocTypeRepository value) { }
public  main.groovy.application.dao.DocSubjectRepository getDocSubjectRepository() { return (main.groovy.application.dao.DocSubjectRepository)null;}
public  void setDocSubjectRepository(main.groovy.application.dao.DocSubjectRepository value) { }
public  main.groovy.application.dao.DocSubjectTypeRepository getDocSubjectTypeRepository() { return (main.groovy.application.dao.DocSubjectTypeRepository)null;}
public  void setDocSubjectTypeRepository(main.groovy.application.dao.DocSubjectTypeRepository value) { }
@org.springframework.web.bind.annotation.RequestMapping(method=org.springframework.web.bind.annotation.RequestMethod.GET, value="/documentservice/doctype") public  org.springframework.http.ResponseEntity<java.lang.Object> getDocTypes() { return (org.springframework.http.ResponseEntity<java.lang.Object>)null;}
@org.springframework.web.bind.annotation.RequestMapping(method=org.springframework.web.bind.annotation.RequestMethod.GET, value="/documentservice/docsubject") public  org.springframework.http.ResponseEntity<java.lang.Object> getDocSubjects() { return (org.springframework.http.ResponseEntity<java.lang.Object>)null;}
@org.springframework.web.bind.annotation.RequestMapping(method=org.springframework.web.bind.annotation.RequestMethod.GET, value="/documentservice/docsubjecttype") public  org.springframework.http.ResponseEntity<java.lang.Object> getDocSubjectTypes() { return (org.springframework.http.ResponseEntity<java.lang.Object>)null;}
}
