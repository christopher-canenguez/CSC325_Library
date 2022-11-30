/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.csc325_library;

/**
 *
 * @author shameedjob
 */
public class GBSearchParameter {

    public GBSearchParameterType paramType;
    public String search;

    public GBSearchParameter(GBSearchParameterType paramType, String search) {
        this.paramType = paramType;
        this.search = search;
    }

    public GBSearchParameter(String search) {
        this.search = search;
        this.paramType = GBSearchParameterType.none;
    }

    @Override
    public String toString() {
        String outSearch = HttpController.parameterFormat(search);
        if (paramType == GBSearchParameterType.none) {
            return outSearch;
        }

        return String.format("%s:%s", paramType.toString(), outSearch);
    }
}
