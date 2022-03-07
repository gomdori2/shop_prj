package co.yedam.faq.web;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.DbCommand;
import co.yedam.faq.serviceImpl.faqServiceImpl;
import co.yedam.faq.vo.faqVO;

public class faqWrite implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO 저장하기
		faqServiceImpl dao = new faqServiceImpl();
		faqVO vo = new faqVO();
		vo.setTitle(request.getParameter("title"));
		vo.setContent(request.getParameter("content"));
		dao.insertNotice(vo);
		//
		/*
		 * try { response.sendRedirect("faqList.do"); } catch (IOException e) {
		 * System.out.println(); e.printStackTrace(); }
		 */
		return "faqList.do";

	}

}