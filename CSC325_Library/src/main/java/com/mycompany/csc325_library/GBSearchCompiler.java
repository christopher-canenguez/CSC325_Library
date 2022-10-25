/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.csc325_library;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author shameedjob
 */
public class GBSearchCompiler {
    private ArrayList searchData;
    
    public GBSearchCompiler()
    {
        searchData = new ArrayList<GBSearchParameter>();        
    }
    
    public void AddParameter(GBSearchParameterType type, String search)
    {
        searchData.add(new GBSearchParameter(type, search));
    }
    
    public GBSearchCompiler addAuthorParameter(String search)
    {
        AddParameter(GBSearchParameterType.inauthor, search);
        return this;
    }
    
    public GBSearchCompiler addPublisherParameter(String search)
    {
        AddParameter(GBSearchParameterType.inpublisher, search);
        return this;
    }
    
    public GBSearchCompiler addTitleParameter(String search)
    {
        AddParameter(GBSearchParameterType.intitle, search);
        return this;
    }
    
    public GBSearchCompiler addSubjectParameter(String search)
    {
        AddParameter(GBSearchParameterType.subject, search);
        return this;
    }
    
    public GBSearchCompiler addOCLCParameter(String search)
    {
        AddParameter(GBSearchParameterType.oclc, search);
        return this;
    }
    
    public GBSearchCompiler addISBNParameter(String search)
    {
        AddParameter(GBSearchParameterType.isbn, search);
        return this;
    }
    
    public GBSearchCompiler addLCCNParameter(String search)
    {
        AddParameter(GBSearchParameterType.lccn, search);
        return this;
    }
    
    public GBSearchCompiler addGenericParameter(String search)
    {
        AddParameter(GBSearchParameterType.none, search);
        return this;
    }
    
    public GBSearchObject compile()
    {
        return new GBSearchObject(searchData);
    }
}
