<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script>
	function goPage(page) {
		location.href = "faqListPaging.do?page=" + page;
	}
</script>

<div align="center">
	<div>
		<h1>자주하는 질문.</h1>
		
		<!-- 나중에 지우기. 아직은 그대로 두기. -->
	</div>
	<form id="frm" name="frm" action="faq.do" method="post">
		<input type="hidden" id="id" name="id">
	</form>
	<div>
		<table class="table">
			<tr>
				<th width="100">순번</th>
				<th width="200">제목</th>
				<th width="100">작성일자</th>
				
			</tr>
			<c:forEach var="vo" items="${notices }">
				<tr onclick="formSubmit(${vo.id})">
					<td align="center">${vo.id }</td>
					<td align="center">${vo.title }</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<br />
	<div>
		<button type="button" onClick="location.href='main.do'">홈</button>
		<!-- 관리자 만 사용할수 있게. -->
		<%-- <c:if test="${id eq 'admin' }"> --%>
			<button type="button" onClick="location.href='noticeForm.do'">등록</button>
		<%-- </c:if> --%>

 </div>
	<div>
		<div class="paginate">
			<a href="javascript:goPage(${paging.firstPageNo})" class="first">처음 페이지</a>
			<a href="javascript:goPage(${paging.prevPageNo})" class="prev">이전 페이지</a>
			<span>
				<c:forEach var="i" begin="${paging.startPageNo}" end="${paging.endPageNo}" step="1">
					<c:choose>
						<c:when test="${i eq paging.pageNo}">
							<a href="javascript:goPage(${i})" class="choice">${i}</a>
						</c:when>
						<c:otherwise>
							<a href="javascript:goPage(${i})">${i}</a>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</span>
			<a href="javascript:goPage(${paging.nextPageNo})" class="next">다음 페이지</a>
			<a href="javascript:goPage(${paging.finalPageNo})" class="last">마지막 페이지</a>
		</div>
	</div>
</div>