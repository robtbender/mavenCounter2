package com.bender.mavenCounter;


import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class Counter implements Serializable {

    @EJB
	private CounterBean counterBean;

	private static final long serialVersionUID = 1L;
	private int hitCount;

    public Counter() {
    	System.out.println("In Constructor for Counter().");
        this.hitCount = 0;
    }

	public int getHitCount() {
		if (counterBean == null) {
			System.out.println("Failure");
			this.hitCount = -1;
		} else {
			this.hitCount = counterBean.getHits();
		}
		return this.hitCount;
	}

    public void setHitCount(int hitCount) {
        this.hitCount = hitCount;
    }
}
