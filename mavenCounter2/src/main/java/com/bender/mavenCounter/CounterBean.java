package com.bender.mavenCounter;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Startup
@Singleton
public class CounterBean {
    private int hits = 1;
    
    public CounterBean() {
    	super();
    	System.out.println("In constructor of CounterBean.");
    }
    
    @PostConstruct
    public void init(){
    	System.out.format("In post Construct of CounterBean, hits( %d )%n", this.hits);
    }
    
    // Increment and return the number of hits
    public int getHits() {
        return hits++;
    }
    /* A change to test branching. */
    /* A change on the master. */
}
