<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" rel="stylesheet">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link href="css/Login.css" rel="stylesheet">

    <title>AsegurAPP</title>
</head>
<body class="fondo-login" >

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
                        <a class="nav-link active" aria-current="page" href="home">Home</a>
                    </li>
	                <c:if test="${empty logueado}">    
	                    <li class="nav-item">
	                        <a class="nav-link" href="login">Login</a>
	                    </li>
	                    <li class="nav-item">
	                        <a class="nav-link" href="ir-a-registrarme">Registrarte</a>
	                    </li>
	                </c:if>    
                    <c:if test="${empty logueado}">
	                    <li class="nav-item">
	                        <a class="nav-link" href="mensajeErrorSuscripcion">Suscripción</a>
	                    </li>
	                </c:if> 
	                <c:if test="${not empty logueado}">
	                    <li class="nav-item">
	                        <a class="nav-link" href="traerEspecialidades">Contratar</a>
	                    </li>
	                </c:if>        
                    <c:if test="${not empty logueado}">
    					 <li class="nav-item">
                        	<a class="nav-link" href="perfilUsuario">Perfil</a>
                    	</li>
					</c:if>  
	                <c:if test="${not empty logueado}">
	                    <li class="nav-item">
	                        <a class="nav-link" href="suscripcion">Suscripción</a>
	                    </li>
	                </c:if>   
	                      
                    <c:if test="${not empty logueado}">
                    	<form:form action="cerrarSesion" method="POST">              
                        		<button>
                            		cerrarSesion
                        		</button>
                		</form:form>
					</c:if>
                </ul>
            </div>
        </div>
    </nav>
</header>

<div class="w-100">
    <div class="fondo-login container-fluid px-2 h-100 w-100 d-flex justify-content-centerfondo-login container-fluid px-2 h-100 w-100 d-flex justify-content-center">
        <div id="loginbox" style="margin-top:50px;" class="mainbox col-md-10 col-md-offset-3 col-sm-8 col-sm-offset-2">

            <section class="about" data-aos="fade-up">
                <div class="container">
                    <div class="row">
                        <div class="col-12 col-md-6 bg-danger d-none d-md-flex rounded-3 p-0">
                            <img src="imagenes/about.jpg" class="h-100 w-100 rounded-3" alt="">
                        </div>

                        <div class="col-12 col-md-6 p-5 pb-0 p-md-1 bg-white rounded-3">

                            <div class="text-center text-decoration-none text-dark fw-bold">
                                <h3>Sobre Nosotros</h3>
                            </div>

                            <br>
                            <br>

                            <div class="fst-italic">
                                <ul>
                                    <li><i class="bi bi-check2-circle"></i> Somos una compañía de seguros con más de 75
                                        años en el mercado acompañando a nuestros clientes, brindándoles tranquilidad y
                                        seguridad en todas las etapas de su vida.
                                    </li>
                                    <li><i class="bi bi-check2-circle"></i> Desde 1939 estamos construyendo una historia
                                        de cercanía y respaldo.
                                    </li>
                                    <li><i class="bi bi-check2-circle"></i> Hoy somos la aseguradora con mayor
                                        patrimonio neto de la Argentina.
                                    </li>
                                    <li><i class="bi bi-check2-circle"></i> Contamos con cobertura para cada una de tus
                                        necesidades.
                                    </li>
                                </ul>
                            </div>

                            <br>
                            <br>

                            <div class="text-center text-decoration-none text-dark fw-bold">
                                <p>
                                    Compará las opciones que te brinda AsegurAPP
                                </p>
                            </div>

                        </div>
                    </div>
                </div>
            </section>

            <br>
            
			<c:if test="${not empty mensaje}">
				<h1>${mensaje}</h1>
			</c:if>
            <br>

            <section class="services">
                <div class="container">

                            <div class="text-center text-decoration-none text-dark fw-bold">
                            <h3 >Suscripcion Básica</h3>
                                <!-- Button trigger modal -->
                                <button type="button" class="btn btn-dark " data-toggle="modal" data-target="#myModal">
                                    Contratar Suscripción Básica
                                </button>

                                <!-- Modal -->
                                <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                    <div class="modal-dialog" role="document">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <h5 class="modal-title text-primary fw-bold" id="exampleModalLabel">Contratar Suscripcíón</h5>
                                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                    <span aria-hidden="true">&times;</span>
                                                </button>
                                            </div>
                                            <div class="modal-body ">

                                               <p>Para contratar la suscripción y acceder a los servicios incluidos debes estar Logueado.</p>
                                               <p>Si aún no estas registrado podes hacerlo desde <a href="ir-a-registrarme">Aqui.</a></p>
                                               <p>Si estas registrado, pero no te logueaste podes hacerlo desde <a href="login">Aquí.</a></p>
                                                <p>Accede a la Suscripción desde <a href="suscripcion">Aquí.</a></p>

                                            </div>
                                            <div class="modal-footer">
                                                <button type="button" class="btn btn-primary" data-dismiss="modal">Cerrar</button>

                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="row" style="margin-left: 0.05em;margin-top: 3em;margin-bottom: 3em">
                            <div class="card border-dark  col-md-4 col-lg-4 mb-4"  >
                                <div class="card-header text-dark text-center fw-bold">
                                    <i class="fas fa-truck-pickup"></i> Servicio de Grúa</div>
                                <div class="card-body text-dark">
                                    <img class="card-img-top h-100" src="imagenes/grua.jpg" alt="Card image cap">
                                </div>
                                <button type="button" class="btn btn-dark" data-toggle="modal" data-target="#myModalGrua">
                                    + Info
                                </button>
                                <br>
                                <!-- Modal -->
                                <div class="modal fade" id="myModalGrua" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabelGrua" aria-hidden="true">
                                    <div class="modal-dialog" role="document">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <h5 class="modal-title text-primary fw-bold" id="exampleModalLabelGrua">Servicio de Grúa</h5>
                                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                    <span aria-hidden="true">&times;</span>
                                                </button>
                                            </div>
                                            <div class="modal-body ">
                                                <p>Servicio de Auxilio de Grúas plancha para autos-Camionetas 4x4-Combis y Autoelevadores las 24 Hs todo el año.</p>
                                                <p>Para contratar la suscripción y acceder a los servicios incluidos debes estar Logueado. <a href="login">Aquí.</a></p>
                                                <p class="card-text"><small class="text-muted">Servicio incluido en la Suscripción Básica</small></p>
                                            </div>
                                            <div class="modal-footer">
                                                <button type="button" class="btn btn-primary" data-dismiss="modal">Cerrar</button>

                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="card border-dark  col-md-4 col-lg-4 mb-4" >
                                <div class="card-header text-dark text-center fw-bold">
                                    <i class="fab fa-old-republic"></i></i> Asistencia Policial</div>
                                <div class="card-body text-dark">
                                    <img class="card-img-top h-100" src="imagenes/patrullero.jpg" alt="Card image cap">
                                </div>
                                <button type="button" class="btn btn-dark" data-toggle="modal" data-target="#myModalpatrullero">
                                    + Info
                                </button>
                                <br>
                                <!-- Modal -->
                                <div class="modal fade" id="myModalpatrullero" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabelpatrullero" aria-hidden="true">
                                    <div class="modal-dialog" role="document">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <h5 class="modal-title text-primary fw-bold" id="exampleModalLabelpatrullero">Asistencia Policial</h5>
                                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                    <span aria-hidden="true">&times;</span>
                                                </button>
                                            </div>
                                            <div class="modal-body ">
                                                <p>Asistencia Policíal de forma inmediata en caso de emergencia.</p>
                                                <p>Para contratar la suscripción y acceder a los servicios incluidos debes estar Logueado. <a href="login">Aquí.</a></p>
                                                <p class="card-text"><small class="text-muted">Servicio incluido en la Suscripción Básica</small></p>
                                            </div>
                                            <div class="modal-footer">
                                                <button type="button" class="btn btn-primary" data-dismiss="modal">Cerrar</button>

                                            </div>
                                        </div>
                                    </div>
                                </div>

                            </div>
                            <div class="card border-dark  col-md-4 col-lg-4 mb-4">
                                <div class="card-header text-dark text-center fw-bold">
                                    <i class="fas fa-ambulance"></i></i> Servicio Medico</div>
                                <div class="card-body text-dark">
                                    <img class="card-img-top h-100" src="imagenes/ambulancia.jpg" alt="Card image cap">
                                </div>
                                <button type="button" class="btn btn-dark" data-toggle="modal" data-target="#myModalMedico">
                                    + Info
                                </button>
                                <br>

                                <!-- Modal -->
                                <div class="modal fade" id="myModalMedico" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabelMedico" aria-hidden="true">
                                    <div class="modal-dialog" role="document">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <h5 class="modal-title text-primary fw-bold" id="exampleModalLabelMedico">Servicio Médico</h5>
                                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                    <span aria-hidden="true">&times;</span>
                                                </button>
                                            </div>
                                            <div class="modal-body ">
                                                <p>Te ofrecemos un cuerpo médico que puede atenderte rápidamente de forma presencial.</p>
                                                <p>Para contratar la suscripción y acceder a los servicios incluidos debes estar Logueado. <a href="login">Aquí.</a></p>
                                                <p class="card-text"><small class="text-muted">Servicio incluido en la Suscripción Básica</small></p>
                                            </div>
                                            <div class="modal-footer">
                                                <button type="button" class="btn btn-primary" data-dismiss="modal">Cerrar</button>

                                            </div>
                                        </div>
                                    </div>
                                </div>

                            </div>
                            </div>

                            <div class="text-center text-decoration-none text-dark fw-bold">
                                <h3>Suscripción Premium</h3>
                                <button type="button" class="btn btn-dark " data-toggle="modal" data-target="#myModal">
                                    Contratar Suscripción Premium
                                </button>
                            </div>

                            <br>
                            <br>
                            <br>
                            <br>
                        <div class="row" style="margin-left: 0.05em;margin-top: 3em;margin-bottom: 3em">
                            <div class="card border-dark  col-md-3 col-lg-3 mb-3" >
                                <div class="card-header text-dark text-center fw-bold">
                                    <i class="fas fa-wrench"></i> Servicio Mecanico
                                </div>
                                <div class="card-body text-dark">
                                    <img class="card-img-top h-100" src="imagenes/mecanico.jpg" alt="Card image cap">
                                </div>
                                <button type="button" class="btn btn-dark" data-toggle="modal" data-target="#myModalMecanico">
                                    + Info
                                </button>
                                <br>

                                <div class="modal fade" id="myModalMecanico" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabelMecanico" aria-hidden="true">
                                    <div class="modal-dialog" role="document">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <h5 class="modal-title text-primary fw-bold" id="exampleModalLabelMecanico">Servicio Mecanico</h5>
                                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                    <span aria-hidden="true">&times;</span>
                                                </button>
                                            </div>
                                            <div class="modal-body ">
                                                <p>Encontra el profesional que se ajuste a las necesidades de tu vehiculo.</p>
                                                <p>Para contratar la suscripción y acceder a los servicios incluidos debes estar Logueado. <a href="login">Aquí.</a></p>
                                                <p class="card-text"><small class="text-muted">Servicio incluido en la Suscripción Premium</small></p>
                                            </div>
                                            <div class="modal-footer">
                                                <button type="button" class="btn btn-primary" data-dismiss="modal">Cerrar</button>

                                            </div>
                                        </div>
                                    </div>
                                </div>



                            </div>

                            <div class="card border-dark  col-md-3 col-lg-3 mb-3" >
                                <div class="card-header text-dark text-center fw-bold">
                                    <i class="fas fa-tools"></i> Chofer
                                </div>
                                <div class="card-body text-dark">
                                    <img class="card-img-top h-100" src="imagenes/chofer.jpg" alt="Card image cap">
                                </div>
                                <button type="button" class="btn btn-dark" data-toggle="modal" data-target="#myModalChofer">
                                    + Info
                                </button>
                                <br>
                                <div class="modal fade" id="myModalChofer" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabelChofer" aria-hidden="true">
                                    <div class="modal-dialog" role="document">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <h5 class="modal-title text-primary fw-bold" id="exampleModalLabelChofer">Chofer</h5>
                                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                    <span aria-hidden="true">&times;</span>
                                                </button>
                                            </div>
                                            <div class="modal-body ">
                                                <p>Contrate un chófer privado para su comodidad, seguridad y en tiempo record ... calidad de servicio a prueba de una larga lista de clientes satisfechos.</p>
                                                <p>Para contratar la suscripción y acceder a los servicios incluidos debes estar Logueado. <a href="login">Aquí.</a></p>
                                                <p class="card-text"><small class="text-muted">Servicio incluido en la Suscripción Premium</small></p>
                                            </div>
                                            <div class="modal-footer">
                                                <button type="button" class="btn btn-primary" data-dismiss="modal">Cerrar</button>

                                            </div>
                                        </div>
                                    </div>
                                </div>

                            </div>

                            <div class="card border-dark  col-md-3 col-lg-3 mb-3" >
                                <div class="card-header text-dark text-center fw-bold">
                                    <i class="fas fa-cogs"></i> Repuestos Livianos
                                </div>
                                <div class="card-body text-dark">
                                    <img class="card-img-top h-100" src="imagenes/repuestos.jpg" alt="Card image cap">
                                </div>
                                <button type="button" class="btn btn-dark" data-toggle="modal" data-target="#myModalRepuestos">
                                    + Info
                                </button>
                                <br>
                                <div class="modal fade" id="myModalRepuestos" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabelRepuestos" aria-hidden="true">
                                    <div class="modal-dialog" role="document">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <h5 class="modal-title text-primary fw-bold" id="exampleModalLabelRepuestos">Repuestos Livianos</h5>
                                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                    <span aria-hidden="true">&times;</span>
                                                </button>
                                            </div>
                                            <div class="modal-body ">
                                                <p>Nuestros socios cuentan con una flota de auxilio mecánico en todo el país para ayudarlo en todo tipo de incidentes.</p>
                                                <p>Para contratar la suscripción y acceder a los servicios incluidos debes estar Logueado. <a href="login">Aquí.</a></p>
                                                <p class="card-text"><small class="text-muted">Servicio incluido en la Suscripción Premium</small></p>
                                            </div>
                                            <div class="modal-footer">
                                                <button type="button" class="btn btn-primary" data-dismiss="modal">Cerrar</button>

                                            </div>
                                        </div>
                                    </div>
                                </div>


                            </div>

                            <div class="card border-dark  col-md-3 col-lg-3 mb-3" >
                                <div class="card-header text-dark text-center fw-bold">
                                    <i class="fas fa-balance-scale"></i> Asistencia Legal
                                </div>
                                <div class="card-body text-dark">
                                    <img class="card-img-top h-100" src="imagenes/legales.png" alt="Card image cap">
                                </div>
                                <button type="button" class="btn btn-dark" data-toggle="modal" data-target="#myModalLegal">
                                    + Info
                                </button>
                                <br>

                                <div class="modal fade" id="myModalLegal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabelLegal" aria-hidden="true">
                                    <div class="modal-dialog" role="document">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <h5 class="modal-title text-primary fw-bold" id="exampleModalLabelLegal">Asistencia Legal</h5>
                                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                    <span aria-hidden="true">&times;</span>
                                                </button>
                                            </div>
                                            <div class="modal-body ">
                                                <p>Asistencia legal en el momento ante un litigio.</p>
                                                <p>Para contratar la suscripción y acceder a los servicios incluidos debes estar Logueado. <a href="login">Aquí.</a></p>
                                                <p class="card-text"><small class="text-muted">Servicio incluido en la Suscripción Premium</small></p>
                                            </div>
                                            <div class="modal-footer">
                                                <button type="button" class="btn btn-primary" data-dismiss="modal">Cerrar</button>

                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                </div>
            </section>
            <br>
            <br>
        </div>
    </div>
</div>


<footer class="page-footer font-small color-light bg-dark text-light">

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
                    <a href="login">Login</a>
                </p>
                <p>
                    <a href="ir-a-registrarme">Registro</a>
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
        <div class="footer-copyright text-center py-3"> 2021 Copyright: AsegurAPP
        </div>
    </div>
</footer>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>

</body>
</html>