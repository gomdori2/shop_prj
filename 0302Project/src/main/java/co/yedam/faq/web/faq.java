package co.yedam.faq.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.DbCommand;
import co.yedam.faq.serviceImpl.faqServiceImpl;
import co.yedam.faq.vo.faqVO;


public class faq implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO 세부내역 보기
		faqServiceImpl dao = new faqServiceImpl();
		faqVO vo = new faqVO();
		vo.setId(Integer.parseInt(request.getParameter("id")));
		
		vo = dao.noticeSelect(vo);
		request.setAttribute("vo", vo);
		return "faq/faq.tiles";
	}

}
