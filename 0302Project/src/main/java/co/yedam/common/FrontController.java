package co.yedam.common;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.event.web.Event;
import co.yedam.faq.ajaxweb.AjaxFaqInsert;
import co.yedam.faq.ajaxweb.AjaxFaqList;
import co.yedam.faq.web.faq;
import co.yedam.faq.web.faqForm;
import co.yedam.faq.web.faqList;
import co.yedam.faq.web.faqListPaging;
import co.yedam.faq.web.faqWrite;
import co.yedam.store.web.Store;
import co.yedam.store.web.selectstore;
import co.yedam.thiscompany.web.thiscompany;

//@WebServlet("/FrontController")
public class FrontController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private HashMap<String, DbCommand> map = new HashMap<String, DbCommand>();

	public FrontController() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {
		// TODO 호출명 저장소
		map.put("/main.do", new MainPage()); // 시작페이지
		map.put("/store.do", new Store()); // 스토어페이지
		map.put("/event.do", new Event());// 이벤트페이지
		map.put("/about.do", new thiscompany()); //ABOUT 페이지
		map.put("/selectstore.do", new selectstore()); // 제품 선택시 페이지

		// faq 단.
		map.put("/faq.do", new faq()); // 공지사항 내용보기
		map.put("/faqList.do", new faqList()); // 공지사항 목록
		map.put("/faqListPaging.do", new faqListPaging()); // 공지사항 목록
		map.put("/faqForm.do", new faqForm()); // 공지사항 등록 폼 호출
		map.put("/faqWrite.do", new faqWrite()); // 공지사항 저장

		
		map.put("/faq.do", new faq()); //FAQ 페이지
		map.put("/ajax/faqList.do", new AjaxFaqList()); // ajax 공지사항 목록
		map.put("/ajax/faqInsert.do", new AjaxFaqInsert()); // ajax 등록
//		map.put("/noticeListAjax.do", new noticeListAjax());
		
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO 실제처리할 command를 호출하고, 결과를 돌려줄 페이지를 작성하는 곳
		request.setCharacterEncoding("utf-8");
		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String path = uri.substring(contextPath.length());

		DbCommand dbCommand = map.get(path);
		String viewPage = dbCommand.execute(request, response);

		if (viewPage != null) {
			// ajax 응답
			if (viewPage.startsWith("ajax:")) {
				response.setContentType("text/plain; charset=UTF-8");
				response.getWriter().append(viewPage.substring(5));
				return;
			}

			// 뷰페이지 포워드
			if (viewPage.endsWith(".jsp"))
				viewPage = "WEB-INF/jsp/" + viewPage;

			System.out.println(viewPage);
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response);
		}
	}

}
