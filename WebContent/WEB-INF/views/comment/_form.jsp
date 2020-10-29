<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<label for="">日付</label><br />
<input type="date" name="comment_date" value="<fmt:formatDate value='${comment.comment_date}' pattern='yyyy-MM-dd' />" />
<br /><br />

<label for="name">氏名</label><br />
<%-- <c:out /> --%>
<br /><br />

<label for="content">内容</label><br />
<textarea name="content" rows="10" cols="50"></textarea>
<br /><br />

<input />
<button type="submit">投稿</button>