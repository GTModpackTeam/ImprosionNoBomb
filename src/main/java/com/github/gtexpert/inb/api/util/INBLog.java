package com.github.gtexpert.inb.api.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.github.gtexpert.inb.api.INBValues;

public class INBLog {

    private INBLog() {}

    public static Logger logger = LogManager.getLogger(INBValues.MODNAME);
}
