<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" rel="stylesheet">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link href="css/Login.css" rel="stylesheet">
    <title>Editar</title>
</head>
<body class="fondo-login ">
<header>
    <nav class="navbar navbar-expand-sm navbar-dark bg-dark">
        <div class="container-fluid">
            <a class="navbar-brand" href="home">AsegurApp</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
                    aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link" aria-current="page" href="home">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="traerEspecialidades">Contratar</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" href="perfilUsuario">Perfil</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="suscripcion">Suscripción</a>
                    </li>
                    <form:form action="cerrarSesion" method="POST">
                        <button>
                            cerrarSesion
                        </button>
                    </form:form>
                </ul>
            </div>
        </div>
    </nav>
</header>

<main>
    <div class="container">
        <div class="container-fluid  mt-5 rounded-3 ">
            <div class="row w-100 bg-light m-auto p-1 justify-content-md-center mb-5" style="max-width: 1250px;">
                <form:form action="editar-usuario" modelAttribute="request" method="post">
                    <!-- Nombre -->
                    <label for="nombre" class="form-label">Nombre</label>
                    <form:input path="nombre" id="nombre" type="text" cssClass="form-control" value="${usuario.nombre}" />

                    <!-- Apellido -->
                    <label for="apellido" class="form-label mt-3">Apellido</label>
                    <form:input path="apellido" id="apellido" type="text" cssClass="form-control" value="${usuario.apellido}" />

                    <!-- Email -->
                    <label for="email" class="form-label mt-3">Email</label>
                    <form:input path="email" id="email" type="text" cssClass="form-control" value="${usuario.email}" />

                    <!-- Provincia -->
                    <label for="provincia" class="form-label mt-3">Provincia</label>
                    <form:select path="provinciaId" id="provincia" cssClass="form-select">
                        <c:if test="${usuario.provincia != null}">
                            <option value="${usuario.provincia.id}" selected>${usuario.provincia.nombre}</option>
                        </c:if>
                        <c:if test="${usuario.provincia == null}">
                            <option value="-1" selected>Seleccione una provincia</option>
                        </c:if>
                        <c:forEach items="${provincias}" var="provincia">
                            <c:if test="${provincia.id != usuario.provincia.id}">
                                <option value="${provincia.id}">${provincia.nombre}</option>
                            </c:if>
                        </c:forEach>
                    </form:select>
                    <!-- Imagen -->
                    <%--<label class="form-labe mt-3" for="file-selector">Imagen de perfil</label>
                    <input type="file" id="file-selector" class="form-control" accept="image/*" onchange="encode()">
                    <form:input path="imagen" id="image" type="text" cssStyle="display:none;" />--%>

                    <input type="submit" class="btn btn-primary mt-5" value="Enviar">
                </form:form>
            </div>
        </div>
    </div>
</main>
<footer class="page-footer font-small color-light bg-dark text-light mt-5" style="width:100%; position: fixed; bottom: 0">
    <div>
        <div class="container">
            <div class="col-md-6 col-lg-7 text-center text-md-right">

                <a class="fb-ic">
                    <i class="fab fa-facebook-f white-text mr-4"> </i>
                </a>

                <a class="tw-ic">
                    <i class="fab fa-twitter white-text mr-4"> </i>
                </a>

                <a class="gplus-ic">
                    <i class="fab fa-google-plus-g white-text mr-4"> </i>
                </a>

                <a class="li-ic">
                    <i class="fab fa-linkedin-in white-text mr-4"> </i>
                </a>

                <a class="ins-ic">
                    <i class="fab fa-instagram white-text"> </i>
                </a>

            </div>


        </div>

    </div>

    <div class="container text-center text-md-left mt-5">


        <div class="row mt-3">


            <div class="col-md-3 col-lg-2 col-xl-2 mx-auto mb-4">

                <h6 class="text-uppercase font-weight-bold">Acceso directo</h6>
                <hr class="deep-purple accent-2 mb-4 mt-0 d-inline-block mx-auto" style="width: 60px;">
                <p>
                    <a href="#!">Login</a>
                </p>
                <p>
                    <a href="#!">Registro</a>
                </p>

                <p>
                    <a href="#!">Ayuda</a>
                </p>

            </div>

            <div class="col-md-4 col-lg-3 col-xl-3 mx-auto mb-md-0 mb-4">
                <h6 class="text-uppercase font-weight-bold">Contacto</h6>
                <hr class="deep-purple accent-2 mb-4 mt-0 d-inline-block mx-auto" style="width: 60px;">
                <p>
                    <i class="fas fa-home mr-3"></i> calle Siempre viva 742, Springfield</p>
                <p>
                    <i class="fas fa-envelope mr-3"></i> info@asegurapp.com</p>
                <p>
                    <i class="fas fa-phone mr-3"></i> +011 4444-4444 </p>
            </div>
        </div>
        <div class="footer-copyright text-center py-3">� 2021 Copyright: AsegurAPP</div>
    </div>

</footer>
</body>
<script>
    function encode() {
        const selectedfile = document.querySelector('#file-selector').files;
        if (selectedfile.length > 0) {
            const imageFile = selectedfile[0];
            const fileReader = new FileReader();
            fileReader.onload = function (fileLoadedEvent) {
                const srcData = fileLoadedEvent.target.result;
                document.querySelector('#image').value = srcData;

                console.log(srcData)
            }
            fileReader.readAsDataURL(imageFile);
        }
    }
</script>
</html>
