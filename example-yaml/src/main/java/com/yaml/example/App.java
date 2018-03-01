package com.yaml.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.yaml.beans.Aws;

public class App 
{
    public static void main( String[] args )
    {
    	 if(args.length == 0){
    		 throw new RuntimeException("Need yml file");
    	 }
    	 
    	
         try {
             
        	 ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        	 Aws aws = mapper.readValue(new File(args[0]), Aws.class);
             System.out.println(ReflectionToStringBuilder.toString(aws,ToStringStyle.MULTI_LINE_STYLE));
             
             aws.getPhases()
                 .entrySet()
                 .stream()
                 .map(e -> e.getValue())
                 .map(c -> c.getCommands())
                 .forEach(s -> Arrays.stream(s)
                		             .forEach(App::execute));
            /* 
             */
             
             
             
         } catch (Exception e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
         }
    }
    
    private static void execute(String command){
    	Process p;
		try {
			p = Runtime.getRuntime().exec("cmd /c" +command );
			  new Thread(new Runnable() {
		            public void run() {
		             BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
		             String line = null; 

		             try {
		                while ((line = input.readLine()) != null)
		                    System.out.println(line);
		             } catch (IOException e) {
		                    e.printStackTrace();
		                    System.out.println(e.getMessage());
		             }
		            }
		        }).start();
			  p.waitFor();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			 System.out.println(e1.getMessage());
		}

      
       
    }
}
