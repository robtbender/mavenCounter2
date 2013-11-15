package mavenCounter2;

import static org.junit.Assert.*;

import javax.ejb.EJB;
import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.bender.mavenCounter.Counter;
import com.bender.mavenCounter.CounterBean;

@RunWith(Arquillian.class)
public class CounterTest {
	
    @Deployment
    public static JavaArchive createDeployment() {
    	JavaArchive ja = ShrinkWrap.create(JavaArchive.class, "test.jar");
    	ja.addClasses(Counter.class,CounterBean.class);
    	ja.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    	return ja;
//        return ShrinkWrap.create(JavaArchive.class)
//            .addClass(Counter.class)
//            .addClass(CounterBean.class)
//            .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }
    
    @Inject
	private Counter counter;
    
    @EJB
    private CounterBean counterBean;

	@Test
	public void test() {
		assertTrue(counter.getHitCount()>0);
	}

}
