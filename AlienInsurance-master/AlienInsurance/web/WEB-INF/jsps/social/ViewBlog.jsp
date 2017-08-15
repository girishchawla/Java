<%-- 
    Document   : ViewBlog
    Created on : Apr 26, 2016, 4:39:33 PM
    Author     : Trent
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:include page="/WEB-INF/includes/pagetop.jsp" />
        <div class="blogHeader">
            <h1><c:out value="${blog.title}" /></h1> 
            <p>Created By: ${blog.createdBy} ${blog.dateCreated}</p>
        </div>
        <div class="blogContent">
            <p><c:out value="${blog.content}" /></p>
        </div>
        <div>
            <c:choose>
                <c:when test="${!blog.disableComments}">
                    <form method="POST" class="blogCommentForm">
                        <div>
                            <label for="content">Add Comment</label>
                            <input type="text" name="content" /><br />
                            <input type="submit" value="Submit" />
                        </div>
                    </form>
                    <br />
                </c:when>
                <c:otherwise>
                    <p>Commenting has been disabled for this blog.</p>
                </c:otherwise>
            </c:choose>
            <div class="blogComments">
                <c:choose>
                    <c:when test="${fn:length(blog.blogComments) > 0}">
                        <c:forEach var="blogComment" items="${blog.blogComments}">
                            <div class="blogComment">
                                <p><c:out value="${blogComment.content}" /></p>
                                <div>
                                    <p>~ ${blogComment.createdBy} ${blogComment.dateCreated}</p>
                                </div>
                            </div>
                        </c:forEach>
                    </c:when>
                    <c:otherwise>
                        <c:if test="${!blog.disableComments}">
                            <p>No comments made.</p>
                        </c:if>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
<jsp:include page="/WEB-INF/includes/pagebottom.jsp" />
