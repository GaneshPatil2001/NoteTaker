package com.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entities.NoteTaker;
import com.helper.FactoryProvider;


public class updateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{
			String title=request.getParameter("titledata");
			String content=request.getParameter("contentdata");
			int noteId=Integer.parseInt(request.getParameter("noteId"));
			Session session=FactoryProvider.getFactory().openSession();
			Transaction tx=session.beginTransaction();
			
			NoteTaker note=session.get(NoteTaker.class,noteId);
			note.setTitle(title);
			note.setContent(content);
			note.setAddedDate(new Date());
			
			tx.commit();
			session.close();
			response.sendRedirect("all_notes.jsp");
		}
		catch(Exception e)
		{
			
		}
	}

}
