package org.cejug.cct.frameworks.logica;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Logica {

	String executa(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException;
	
}
