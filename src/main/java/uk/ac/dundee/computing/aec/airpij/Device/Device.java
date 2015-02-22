/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.dundee.computing.aec.airpij.Device;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

/**
 *
 * @author Administrator
 */
public class Device {
    int numberofsensors=0;
    ArrayList <Sensor> sensors = new ArrayList<Sensor>();
    UUID Devicename= UUID.randomUUID();
    Map<String,String> meta=new HashMap<String,String>();
    
  
    public Device(){
        
    }
    
    public void addSensor (Sensor ss){
        sensors.add(ss);
    }
    
    public void setDevice(UUID Devicename){
        this.Devicename=Devicename;
        
    }
    
    public void addMetaData(String name,String value){
        meta.put(name,value);
    }
    
    public UUID getDevice(){
        return Devicename;
    }
    
    public Date getInsertion_time(){
        return new Date();
    }
    
    public Sensor[] getSensors(){
        return sensors.toArray(a)
    }
    
    public Map<String,String> getMeta(){
        return( meta);
    }
}
    

