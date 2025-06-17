package com.javaex.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javaex.dao.PhonebookDAO;
import com.javaex.vo.PersonVO;


@WebServlet("/pbc")
public class PhonebookController extends HttpServlet {
	//필드
	private static final long serialVersionUID = 1L;
       
	//생성자 기본생성자 사용 그래서 삭제했음

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//작동했는지 확인용
		System.out.println("PhonebookController");
		
		//action 파라미터의 값이 뭔지 알아야됨
		String action = request.getParameter("action");
		System.out.println(action); //업무구분
				
		if("list".equals(action)) {
			//리스트//////////////////////////////////////////////////////////////
			
			//db데이터가져온다  --> list
			PhonebookDAO phonebookDAO = new PhonebookDAO();
			List<PersonVO> personList = phonebookDAO.personSelect();
			
			System.out.println(personList);
			
			//저밑에 있는 list.jsp에게 후반일 html을 만들고 응답문서 만들어 보낸다
			//1)request객체에 데이터를 넣어준다
			request.setAttribute("pList", personList);
			
			//2)list.jsp에 request객체와 response객체를 보낸다
			//*포워드
			RequestDispatcher rd = request.getRequestDispatcher("/list.jsp");
			rd.forward(request, response);
			
			////////////////////////////////////////////////////////////////////
		
		}else if("wform".equals(action)) {
			
			//등록폼//////////////////////////////////////////////////////////////
			System.out.println("등록폼");
			
			//등록폼을 응답해야한다
			/////////////////////////////////////////////////////////////////////
		
		}else if(action == "mform") {
			
			//수정폼
		}
		
		
		
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
