<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/head.jsp"%>
        <div class="right">
            <div class="location">
                <strong>你现在所在的位置是:</strong>
                <span>用户管理页面</span>
            </div>
            <div class="search">
           		<form method="post" action="${pageContext.request.contextPath }/user/uList">


					 <a href="${pageContext.request.contextPath}/user/add" >添加用户</a>
				</form>
            </div>
            <!--用户-->
            <table class="providerTable" border="1" cellpadding="0" cellspacing="0">
                <tr class="firstTr">
                    <th width="20%">用户名称</th>
                    <th width="20%">用户密码</th>
                    <th width="30%">图片上传</th>
                </tr>
                   <c:forEach var="user" items="${userList }" varStatus="status">
					<tr>

						<td>
						<span>${user.userName }</span>
						</td>
						<td>
							<span>${user.password }</span>
						</td>

						<td>
						<span>${user.idPicPath}</span>
						</td>

						<td>
							<span><a class="viewUser" href="javascript:;" userid=${user.id } username=${user.userName }><img src="${pageContext.request.contextPath }/statics/images/read.png" alt="查看" title="查看"/></a></span>
							<span><a class="modifyUser" href="javascript:;" userid=${user.id } username=${user.userName }><img src="${pageContext.request.contextPath }/statics/images/xiugai.png" alt="修改" title="修改"/></a></span>
							<span><a class="deleteUser" href="javascript:;" userid=${user.id } username=${user.userName }><img src="${pageContext.request.contextPath }/statics/images/schu.png" alt="删除" title="删除"/></a></span>
						</td>

					</tr>
				</c:forEach>
			</table>
        </div>
    </section>

<!--点击删除按钮后弹出的页面-->
<div class="zhezhao"></div>
<div class="remove" id="removeUse">
	<div class="removerChid">
		<h2>提示</h2>
		<div class="removeMain">
			<p>你确定要删除该用户吗？</p>
			<a href="#" id="yes">确定</a>
			<a href="#" id="no">取消</a>
		</div>
	</div>
</div>

<%@include file="/WEB-INF/jsp/common/foot.jsp" %>
<script src="${pageContext.request.contextPath }/statics/js/userlist.js"></script>
