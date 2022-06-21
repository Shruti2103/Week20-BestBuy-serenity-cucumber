package com.localhost.swagger.bestbuyiinfo;


import com.localhost.swagger.productinfo.UtilitiesSteps;

import com.localhost.swagger.testbase.TestBase;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;

public class UtilitiesCURDTestWithSteps extends TestBase {
@Steps
UtilitiesSteps utilitiesSteps;
    @Test
    public void test001() {
        utilitiesSteps.getVersiondetal().statusCode(200);
        utilitiesSteps.getHealthcheckupDetail().statusCode(200);
    }


}
