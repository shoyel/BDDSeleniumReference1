package com.shiftedtech.qa.junit.functional;

import org.junit.Test;
import org.junit.experimental.ParallelComputer;
import org.junit.runner.JUnitCore;

/**
 * Created by ShiftTeacher on 2/3/2018.
 */
public class ParallelSuite {

    @Test
    public void parallelTest(){
       Class[] cls = {SpreeLoginFunctionalityJUnit.class};

       // JUnitCore.runClasses(ParallelComputer.classes(),cls);
        JUnitCore.runClasses(new ParallelComputer(true,true),cls);

    }
}
