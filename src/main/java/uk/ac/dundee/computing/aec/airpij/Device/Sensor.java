/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.dundee.computing.aec.airpij.Device;

import java.util.Random;

/**
 *
 * @author Administrator
 */
public class Sensor {

    int type = 0;


    String name;
float fValue;
int iValue;
        String sValue;
    int sValueType;
    public Sensor() {
        //See http://www.tutorialspoint.com/java/util/random_nextboolean.htm

        
    }

    
    public void setName(String Name){
        this.name=Name;
    }
    public int getType() {
        return type;
    }
     

    
    public Object getValue() {
        switch (type) {
            case 1:
               
                return fValue;

            case 2:
              
                return iValue;
            case 3:
                
                return sValue;
            default:
                break;
        }
        return null;
    }
    
    public void setValue(Object Value){
        Class cl = Value.getClass();
         String className = cl.getName();
         if (className.compareTo("Float")==0){
             Float f= (Float)Value;
             fValue=f.floatValue();
         }
         if (className.compareTo("Integer")==0){
             Integer i= (Integer)Value;
             iValue=i.intValue();
         }
         if (className.compareTo("String")==0){
             sValue=(String)Value;
         }
    }
    
    public String getName(){
        return name;
    }

}
