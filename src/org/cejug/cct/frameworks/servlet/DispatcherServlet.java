package org.cejug.cct.frameworks.servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/")
public class DispatcherServlet extends HttpServlet {

	@Override
	@SuppressWarnings("unchecked")
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		
		try {
			String uri = req.getRequestURI();
			String[] urlSplit = uri.split("/");
			
			String acao = urlSplit[2] + "Logica";
			String pacote = "org.cejug.cct.frameworks.logica.";
			
			Class clazzLogica = Class.forName(pacote+acao);
			Method m = clazzLogica.getMethod(urlSplit[3], HttpServletRequest.class, 
					HttpServletResponse.class);
			Object retorno = m.invoke(clazzLogica.newInstance(), req, res);
			String[] tipoRetorno;
			
			if (retorno.toString().contains(":")) {
				tipoRetorno = retorno.toString().split(":");
			
				if (tipoRetorno[0].equals("redirect")) {
					res.sendRedirect("/"+urlSplit[1] 
							+ "/"+tipoRetorno[1]);
				} else {
					req.getRequestDispatcher("/"+tipoRetorno[1])
						.forward(req, res);
				}
			} else {
				req.getRequestDispatcher("/"+retorno + ".jsp")
				.forward(req, res);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
