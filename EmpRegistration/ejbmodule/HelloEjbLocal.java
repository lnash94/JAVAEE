package com.emp.ejb;

import javax.ejb.Local;

@Local

public interface HelloEjbLocal {
	public String sayHello();

}
