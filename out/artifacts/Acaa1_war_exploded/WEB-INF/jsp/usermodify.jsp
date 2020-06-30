<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/head.jsp"%>

    <div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>用户管理页面 >> 用户修改页面</span>
        </div>
        <div class="providerAdd">
        <form id="userForm" name="userForm" method="post" action="${pageContext.request.contextPath }/user">
            <input type="hidden" name="_method" value="put">
            <%--<input type="hidden" name="method" value="modifyexe">--%>
			<input type="hidden" name="uid" value="${user.id }"/>
			 <div>
                    <label for="userName">用户名称：</label>
                    <input type="text" name="userName" id="userName" value="${user.userName }"> 
					<font color="red"></font>
             </div>


			 <div class="providerAddBtn">
                    <input type="button" name="save" id="save" value="保存" />
                    <input type="button" id="back" name="back" value="返回"/>
                </div>
            </form>
        </div>
    </div>
</section>
<%@include file="/WEB-INF/jsp/common/foot.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath }/statics/js/usermodify.js"></script>
