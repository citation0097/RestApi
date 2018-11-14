package com.kimhank.control;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class Controller
 */
@WebServlet(
		description = "property", 
		urlPatterns = { "/Controller" }, 
		initParams = { 
				@WebInitParam(name = "propertyConfig", value = "command properties")
		})
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private Map<String, Object> commandMap = new HashMap<String, Object>();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		String props = config.getInitParameter("propertyConfig");
		String realFolder = "/property";
		ServletContext context = config.getServletContext();
		String realPath = context.getRealPath(realFolder) +"\\" + props;
		Properties pr = new Properties();
		FileInputStream file = null;
		try {
			file = new FileInputStream(realPath);
			pr.load(file);
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			if (file != null) try {
				file.close();
			} catch (IOException e2) {
				// TODO: handle exception
			}
		}
		
		Iterator<?> keyIter = pr.keySet().iterator();
		while( keyIter.hasNext()) {
			String command = (String)keyIter.next();
			String className = pr.getProperty(command);
			try {
				Class<?> commandClass = Class.forName(className);
				Object commandInstance = commandClass.newInstance();
				commandMap.put(command, commandInstance);
			}catch(ClassNotFoundException e) {
				throw new ServletException(e);
			} catch (InstantiationException e) {
                throw new ServletException(e);
            } catch (IllegalAccessException e) {
                throw new ServletException(e);
            }
		}
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		requestPro(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		requestPro(request, response);
	}

	private void requestPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String view = null;
		CommandProcess com = null;
		try {
			String command = request.getParameter("command");
			com =(CommandProcess)commandMap.get(command);
			view = com.requestPro(request, response);
		} catch (Throwable e) {
			// TODO: handle exception
			 throw new ServletException(e);
		}
		RequestDispatcher dispatcher =request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
	}
	
}
