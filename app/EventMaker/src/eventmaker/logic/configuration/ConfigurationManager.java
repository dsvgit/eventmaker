/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventmaker.logic.configuration;

import eventmaker.core.utils.FileUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.json.simple.parser.JSONParser;



/**
 *
 * @author dsvma_000
 */
public class ConfigurationManager {
    private SystemConfiguration config;
    
    public SystemConfiguration get() {
        if (config == null) {
            Path dir = Paths.get("src/config");
            if (Files.notExists(dir)) dir.toFile().mkdir();
            Path configFile = Paths.get(dir+"/config.json");
            if (Files.exists(configFile)) {
                try {
                    String json = FileUtils.readFile(configFile.toString(), StandardCharsets.UTF_8);

                    JSONParser parser = new JSONParser();

                    try {
                        Object obj = parser.parse(json);
                        JSONObject jsonObj = (JSONObject) obj;
                        config = new SystemConfiguration(
                                jsonObj.get("name").toString(),
                                jsonObj.get("dbUrl").toString(),
                                jsonObj.get("dbName").toString()
                        );
                    } catch (ParseException e) {

                    }
                } catch (IOException e){

                }
            } else {
                config = new SystemConfiguration("eventmaker", "", "");
                
                JSONObject obj = new JSONObject();
                
                obj.put("name", config.getName());
                obj.put("dbUrl", config.getDbUrl());
                obj.put("dbName", config.getDbName());
                
                try {
                    PrintWriter writer = new PrintWriter(configFile.toString(), "UTF-8");
                    try {
                        obj.writeJSONString(writer);
                    } catch (IOException e){

                    }
                    writer.close();
                } catch (FileNotFoundException | UnsupportedEncodingException e){

                }
            }
        }
        return config;   
    }
}
