<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script type="text/javascript">
    function checkForm() {
        var oldPassword = $("#oldPassword").val();
        var newPassword1 = $("#newPassword1").val();
        var newPassword2 = $("#newPassword2").val();
        if (oldPassword == null || oldPassword == "") {
            alert("请输入原密码！");
            return false;
        }
        if (oldPassword != '${currentUser.password}') {
            alert("原密码错误，请重新输入");
            return false;
        }
        if (newPassword1 == null || newPassword1 == "") {
            alert("请输入新密码！");
            return false;
        }
        if (newPassword2 == null || newPassword2 == "") {
            alert("请输入确认新密码！");
            return false;
        }
        if (newPassword1 != newPassword2) {
            alert("确认新密码填写错误，请重新输入！");
            return false;
        }
        return true;
    }
</script>

<div class="data_list">
    <div class="data_info">
        <p>修改个人密码</p>
    </div>
    <div class="data_content">
        <form action="studentUpdatePassword" method="post" onsubmit="return checkForm()">
            <table width="40%" align="center">
                <tr>
                    <td><label>用户名：</label></td>
                    <td>
                        <input type="text" value="${currentUser.id }" name="student.id" readonly="readonly"/>
                    </td>
                </tr>
                <tr>
                    <td><label>原密码：</label></td>
                    <td>
                        <input type="password" id="oldPassword"/>
                    </td>
                </tr>
                <tr>
                    <td><label>新密码：</label></td>
                    <td>
                        <input type="password" id="newPassword1" name="student.password"/>
                    </td>
                </tr>
                <tr>
                    <td><label>确认新密码：</label></td>
                    <td>
                        <input type="password" id="newPassword2"/>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">&nbsp;</td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" class="btn  btn-primary" value="修改密码"/>
                    </td>
                </tr>
            </table>
        </form>
    </div>
</div>
