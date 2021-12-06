<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: sebas
  Date: 12/5/2021
  Time: 1:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <form:form action="editarUsuario" modelAttribute="request" method="post">
      <form:input path="nombre" id="nombre" type="text" />
      <input type="file" id="file-selector" onchange="encode()">
      <form:input path="imagen" id="image" type="text" cssStyle="display:none;"/>
      <input type="submit" value="Enviar">
  </form:form>
</body>
<script>
    function encode() {
        const selectedfile = document.querySelector('#file-selector').files;
        if (selectedfile.length > 0) {
            const imageFile = selectedfile[0];
            const fileReader = new FileReader();
            fileReader.onload = function(fileLoadedEvent) {
                const srcData = fileLoadedEvent.target.result;
                document.querySelector('#image').value = srcData;

                console.log(srcData)
            }
            fileReader.readAsDataURL(imageFile);
        }
    }
</script>
</html>
