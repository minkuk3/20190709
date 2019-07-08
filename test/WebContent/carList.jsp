<%@page import="kr.co.te.CarVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% List<CarVO> list = (List<CarVO>)request.getAttribute("carList");  %>

<%if(list != null && list.size() > 0) {%>
	<div class="carTable_wrap">
		<table>
			<tr>
				<th>등록번호</th>
				<th>차량이름</th>
				<th>출시일자</th>
				<th>차량가격</th>
			</tr>
			<%for(CarVO vo : list){ %>
			<tr>
				<td><%=vo.getC_no() %></td>
				<td><%=vo.getC_name() %></td>
				<td><%=vo.getC_regdate() %></td>
				<td><%=vo.getC_price() %></td>
			</tr>
			<%} %>
		</table>
	</div>
<% } %>