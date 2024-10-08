package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entities.NoteTaker;
import com.helper.FactoryProvider;


public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public DeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try
		{
			int noteId=Integer.parseInt(request.getParameter("note_id").trim());
			Session session=FactoryProvider.getFactory().openSession();	
			
			NoteTaker note=session.get(NoteTaker.class,noteId);
			Transaction tx=session.beginTransaction();
			session.delete(note);
			tx.commit();
			session.close();
			response.sendRedirect("all_notes.jsp");
		}
		catch(Exception e)
		{
			
		}
	}
	

	

}
