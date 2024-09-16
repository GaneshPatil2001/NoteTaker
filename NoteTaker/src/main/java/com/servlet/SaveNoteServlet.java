package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.entities.NoteTaker;
import com.helper.FactoryProvider;

public class SaveNoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public SaveNoteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try
		{
			String title=request.getParameter("titledata");
			String content=request.getParameter("contentdata");
			
			NoteTaker note=new NoteTaker(title,content,new Date());
	
			
			Session session=FactoryProvider.getFactory().openSession();
			Transaction tx=session.beginTransaction();	
			session.save(note);
			tx.commit();
			session.close();
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			out.println("<h1 style='text-align:center;'>Note is added Successfully</h1>");
			out.println("<h1 style='text-align:center;'><a href='all_notes.jsp'>View all notes</a ></h1>");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
