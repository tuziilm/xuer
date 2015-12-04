<%@include file="../include/common.jsp" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>后台系统登录</title>
    <link rel="icon" type="image/png" href="${basePath}static/common/favicon.png" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="${basePath}static/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="${basePath}static/theme/${_theme}/global.css" rel="stylesheet">
    <style type="text/css">
      body {
        padding-top: 40px;
        padding-bottom: 40px;
        background-color: #f5f5f5;
      }

      .form-signin {
        max-width: 300px;
        padding: 19px 29px 29px;
        margin: 0 auto 20px;
        background-color: #fff;
        border: 1px solid #e5e5e5;
        -webkit-border-radius: 5px;
           -moz-border-radius: 5px;
                border-radius: 5px;
        -webkit-box-shadow: 0 1px 2px rgba(0,0,0,.05);
           -moz-box-shadow: 0 1px 2px rgba(0,0,0,.05);
                box-shadow: 0 1px 2px rgba(0,0,0,.05);
      }
      .form-signin .form-signin-heading,
      .form-signin .checkbox {
        margin-bottom: 10px;
      }
      .form-signin input[type="text"],
      .form-signin input[type="password"] {
        font-size: 16px;
        height: auto;
        margin-bottom: 15px;
        padding: 7px 9px;
      }
	  #errors{
	  	padding-left: 0;
	  }
    </style>
    <link href="${basePath}static/bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet">

    <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
  </head>

  <body>
  <jsp:useBean id="personcount" class="com.dxj.xuer.domain.CountBean" scope="session"/>
  <!-- 这是整个服务器访问量的统计 -->
  <jsp:useBean id="totalcount" class="com.dxj.xuer.domain.CountBean" scope="application"/>

  您的访问次数:<jsp:getProperty name="personcount" property="count"/><br/>
  所有用户访问量统计:<jsp:getProperty name="totalcount" property="count"/><br/>
  <input type="button" value="刷    新" onClick="location.reload()"/> </fieldset>
    <div class="container">

      <form id="login_form" onsubmit="return checkLogin();" class="form-signin" action="${basePath}login" method="post">
        <h2 class="form-signin-heading">请登录</h2>
      	<div id="errors"></div>
        <label for="username">用户名:</label>
        <input name="username" type="text" class="input-block-level" placeholder="用户名">
        <label for="passwd">密码:</label>
        <input name="passwd" type="password" class="input-block-level" placeholder="密码">
        <button class="btn btn-large btn-primary" type="submit">登录</button>
      </form>

    </div> <!-- /container -->
    <script type="text/javascript" src="${basePath}static/jquery/jquery-1.8.3.min.js"></script>
    <script type="text/javascript" src="${basePath}static/theme/${_theme}/global.js"></script>
  </body>
</html>
<!--  统计浏览量 单用户
<SCRIPT language=JavaScript>
  var caution = false;
  function setCookie(name, value, expires, path, domain, secure) {
    var curCookie = name + "=" + escape(value) +
            ((expires) ? "; expires=" + expires.toGMTString() : "") +
            ((path) ? "; path=" + path : "") +
            ((domain) ? "; domain=" + domain : "") +
            ((secure) ? "; secure" : "");
    if (!caution || (name + "=" + escape(value)).length <= 4000){
      document.cookie = curCookie;
    }else if (confirm("Cookie exceeds 4KB and will be cut!")){
      document.cookie = curCookie;
    }
  }
  function getCookie(name) {
    var prefix = name + "=";
    var cookieStartIndex = document.cookie.indexOf(prefix);
    if (cookieStartIndex == -1){
      return null;
    }
    var cookieEndIndex = document.cookie.indexOf(";", cookieStartIndex + prefix.length);
    if (cookieEndIndex == -1){
      cookieEndIndex = document.cookie.length;
    }
    return unescape(document.cookie.substring(cookieStartIndex + prefix.length, cookieEndIndex))
  }
  function deleteCookie(name, path, domain) {
    if (getCookie(name)) {
      document.cookie = name + "=" +
      ((path) ? "; path=" + path : "") +
      ((domain) ? "; domain=" + domain : "") +
      "; expires=Thu, 01-Jan-70 00:00:01 GMT";
    }
  }
  function fixDate(date) {
    var base = new Date(0);
    var skew = base.getTime();
    if (skew > 0){
      date.setTime(date.getTime() - skew);
    }
  }
  var now = new Date();
  fixDate(now);
  now.setTime(now.getTime() + 365 * 24 * 60 * 60 * 1000);
  var visits = getCookie("counter");
  if (!visits) {
    visits = 1;
  }else{
    visits = parseInt(visits) + 1;}  //改为1000，增加好快，^_^
  setCookie("counter", visits, now);
  document.write("您是第" + visits + "位");
</SCRIPT>
-->
