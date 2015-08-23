<!--
/*********************************************************************
 *<p>处理内容：demo列表</p>
 *<p>Copyright: Copyright (c) 2011</p>
 * @author 方立文 改版履历<br>
 * @version Rev - Date ------- Name ---------- Note<br>
 * @------- 1.0 --2013.3.2---- 方立文 --------- 新规作成<br>
 ***********************************************************************/
-->
<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<%@ include file="/global.jsp"%>
<head>
	<script type="text/javascript">
	var wsuri ="ws://localhost:8080/zpf/UI/action/websocket/WebSocket.action";
    var sock = null;
         window.onload = function() {
            console.log("onload");
            sock = new WebSocket(wsuri);
            sock.onopen = function() {
               console.log("connected to " + wsuri);
            }
            sock.onclose = function(e) {
               console.log("connection closed (" + e.code + ")");
            }
            sock.onmessage = function(e) {
               console.log("message received: " + e.data);
            }
         };
         function send() {
            var msg = document.getElementById('message').value;
            sock.send(msg);
         };
      </script>
   


</head>
<body class="bodystyle"> 
   <h1>WebSocket Echo Test</h1>
      <form>
         <p>
            Message: <input id="message" type="text" value="Hello, world!">
         </p>
      </form>
      <button onclick="send();">Send Message</button>
</body></html>
