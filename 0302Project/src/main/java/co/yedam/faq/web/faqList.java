package co.yedam.faq.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.DbCommand;
import co.yedam.faq.serviceImpl.faqServiceImpl;
import co.yedam.faq.vo.faqVO;

public class faqList implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO 공지사항 전체보기
		faqServiceImpl dao = new faqServiceImpl();
		List<faqVO> list = new ArrayList<faqVO>();

		list = dao.noticeSelectList();
		request.setAttribute("faq", list);

		return "faq/faqList.tiles";
	}

}
