/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.csc325_library;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
/**
 *
 * @author shameedjob
 */
public class GoogleBooksController extends HttpController{
    private String sendSearch(GBSearchObject searchObject)
    {
        String query = createSearchParameters(searchObject.data);
        try
        {
           var result = getHTML("https://www.googleapis.com/books/v1/volumes"+query); 
           return result;
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return null;
    }
    
    public APISearchResult search(GBSearchObject searchObject)
    {
        var results = sendSearch(searchObject);
        if(results != null)
        {
            try {
                StringReader sr = new StringReader(results);
                GsonBuilder builder = new GsonBuilder();
                Gson gson = builder.create();
                APISearchResult result = gson.fromJson(sr, APISearchResult.class);
                return result;
            
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
        
        return null;
    }
    
    public static String createSearchParameters(GBSearchParameter[] params)
    {
        String results = "";
        for(int i = 0; i < params.length; i++)
        {
            var gbs = params[i];
            results += gbs.toString();
            if(i < params.length-1)
            {
                results += "+";
            }
        }
        return "?q="+results;
    }

}
