package jmri.jmrit.ampmeter;

import java.awt.GraphicsEnvironment;
import jmri.util.JUnitUtil;
import jmri.util.ThreadingUtil;
import org.junit.After;
import org.junit.Assert;
import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Paul Bender Copyright (C) 2017	
 */
public class AmpMeterFrameTest {

    @Test
    public void testCTor() {
        Assume.assumeFalse(GraphicsEnvironment.isHeadless());
        AmpMeterFrame t = new AmpMeterFrame();
        Assert.assertNotNull("exists",t);
    }

    @Test
    public void testCurrentChange1Digit() {
        Assume.assumeFalse(GraphicsEnvironment.isHeadless());
        AmpMeterFrame t = new AmpMeterFrame();
        ThreadingUtil.runOnLayout(() -> {
             t.initComponents();
             jmri.InstanceManager.getDefault(jmri.MultiMeter.class).setCurrent(2.1f);
    	});
        t.dispose();
    }

    @Test
    public void testCurrentChange2Digit() {
        Assume.assumeFalse(GraphicsEnvironment.isHeadless());
        AmpMeterFrame t = new AmpMeterFrame();
        ThreadingUtil.runOnLayout(() -> {
             t.initComponents();
             jmri.InstanceManager.getDefault(jmri.MultiMeter.class).setCurrent(32.1f);
    	});
        t.dispose();
    }

    @Test
    public void testCurrentChange3Digit() {
        Assume.assumeFalse(GraphicsEnvironment.isHeadless());
        AmpMeterFrame t = new AmpMeterFrame();
        ThreadingUtil.runOnLayout(() -> {
             t.initComponents();
             jmri.InstanceManager.getDefault(jmri.MultiMeter.class).setCurrent(432.1f);
    	});
        t.dispose();
    }

    @Test
    public void testCurrentChange4Digit() {
        Assume.assumeFalse(GraphicsEnvironment.isHeadless());
        AmpMeterFrame t = new AmpMeterFrame();
        ThreadingUtil.runOnLayout(() -> {
             t.initComponents();
             jmri.InstanceManager.getDefault(jmri.MultiMeter.class).setCurrent(5432.1f);
    	});
        t.dispose();
    }

    // The minimal setup for log4J
    @Before
    public void setUp() {
        JUnitUtil.setUp();
        JUnitUtil.resetProfileManager();
        jmri.InstanceManager.setDefault(jmri.MultiMeter.class,new TestMeter());
    }

    @After
    public void tearDown() {
        JUnitUtil.tearDown();
    }

    private class TestMeter extends jmri.implementation.AbstractMultiMeter {
             public TestMeter(){
               super(0);
             }
             @Override
             public void initializeHardwareMeter(){
             }
             @Override
             public void requestUpdateFromLayout(){
             }
             @Override
             public void dispose(){
             }
             @Override
             public boolean hasCurrent(){
                return true;
             }
             @Override
             public boolean hasVoltage(){
                return false;
             }
             @Override
             public String getHardwareMeterName(){
                return "test";
             }
             @Override
             public void enable(){
             }
             @Override
             public void disable(){
             }
        }

    // private final static Logger log = LoggerFactory.getLogger(AmpMeterFrameTest.class);

}
