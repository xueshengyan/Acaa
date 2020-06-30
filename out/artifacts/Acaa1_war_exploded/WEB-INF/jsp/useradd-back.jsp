<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/head.jsp"%>

<div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>用户管理页面 >> 用户添加页面</span>
        </div>
        <div class="providerAdd">
            <form id="userForm"  enctype="multipart/form-data"
                  name="userForm" method="post" action="${pageContext.request.contextPath }/user">
				<input type="hidden" name="method" value="add">
                <!--div的class 为error是验证错误，ok是验证成功-->

                <div>
                    <label for="userName">用户名称：</label>
                    <input type="text" name="userName" id="userName" value=""> 
					<font color="red"></font>
                </div>
                <div>
                    <label for="userPassword">用户密码：</label>
                    <input type="password" name="password" id="userPassword" value="">
					<font color="red"></font>
                </div>


                <div>
                    <label>请上传你的证件照：</label>
                    <input type="file" name="pic">
                </div>
                <div class="providerAddBtn">
                    <input type="button" name="add" id="add" value="保存" >
					<input type="button" id="back" name="back" value="返回" >
                </div>
            </form>
        </div>
</div>
</section>
<%@include file="/WEB-INF/jsp/common/foot.jsp" %>
<script src="${pageContext.request.contextPath }/statics/js/useradd.js"></script>

