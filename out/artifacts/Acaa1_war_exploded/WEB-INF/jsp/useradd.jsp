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
                    <input type="file" id="picFile" name="pic">
                </div>
                <p><img id="img" style="width: 100px;height: 100px;display: none;" src="">
                    <input name="picPath" type="hidden" id="userPic">
                </p>
                <div class="providerAddBtn">
                    <input type="button" name="add" id="add" value="保存" >
					<input type="button" id="back" name="back" value="返回" >
                </div>
            </form>
        </div>
</div>
</section>
<%@include file="/WEB-INF/jsp/common/foot.jsp" %>
<script src="${pageContext.request.contextPath }/statics/js/jquery.form.js"></script>
<script src="${pageContext.request.contextPath }/statics/js/useradd.js"></script>
<script>
    var baseUrl = "${pageContext.request.contextPath }";
    $("#picFile").change(function () {
        $("#userForm").ajaxSubmit({
            url:baseUrl+"/user/upload",
            type:"post",
            dataType:"json",
            contentType:"application:json;charset=UTF-8",
            success:function (data) {
                console.log(data)
                if (data !=null && data.success=="true"){
                    $("#userPic").val(data.picPath);
                    $("#img").attr("src",data.picPath);
                    $("#img").show();
                }
            },
            error:function () {
                console.log("上传失败")
            }

        })

    })
    $("#userForm").ajaxForm({
        url:baseUrl+"/user/add_ajax",
        type:"post",
        dataType:"json",
        contentType:"application:json;charset=UTF-8",
        success:function (data) {
            console.log(data)
            if ( data.success=="1"){
                alert("添加成功")
                location.href=baseUrl+"/user/uList";
            }else {
                alert("添加失败")

            }
        },
        error:function () {
            alert("添加失败")
        }
    })

   </script>
