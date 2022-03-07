package co.yedam.faq.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.DbCommand;
import co.yedam.common.Paging;
import co.yedam.faq.serviceImpl.faqServiceImpl;
import co.yedam.faq.vo.faqVO;

public class faqListPaging implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String page = request.getParameter("page");
		
		page = page == null ? "1" : page;
		int pageCnt = Integer.parseInt(page);

		faqServiceImpl service = new faqServiceImpl();
		List<faqVO> listTotal = service.noticeSelectList();

		service = new faqServiceImpl();
		List<faqVO> list = service.selectNoticeListPaging(pageCnt);

		Paging paging = new Paging();
		paging.setPageNo(pageCnt);
		paging.setPageSize(10);
		paging.setTotalCount(listTotal.size());

		request.setAttribute("faq", list);
		request.setAttribute("paging", paging);

		return "faq/faqListPaging.tiles";
	}

}
