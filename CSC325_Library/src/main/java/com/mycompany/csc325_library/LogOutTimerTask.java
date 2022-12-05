/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.csc325_library;

import java.util.TimerTask;

/**
 *
 * @author shameedjob
 */
public class LogOutTimerTask extends TimerTask{

    @Override
    public void run() {
        App.logOut();
    }
    
}
