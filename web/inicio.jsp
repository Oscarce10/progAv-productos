<body class="text-center">
	<form class="form-signin" action="#" method="post">
		<div class="mb-4 logo">
			<a href="#" title="Login"><i class="fab fa-critical-role fa-7x"></i></a>
		</div>
		<div>
								
		<h1 class="h3 mb-3 font-weight-normal">Sistema de Anteproyectos UD V 1.0</h1>
		<?php if(isset($_GET['auth'])){?>
							<div class="alert alert-danger" role="alert">
							Correo o clave incorrectos.
							</div>
						<?php }?>
		<!--Campo de correo-->
		<div class="input-group mb-3">
			<div class="input-group-prepend email">
				<span class="input-group-text"><i class="fas fa-user-tie"></i></span>
			</div>
			<input type="email" name="correo" id="inputEmail" class="form-control" placeholder="Correo electronico" required autofocus="" title="Ingrese correo" />
		</div>

		<!--Campo de contrase�a-->
		<div class="input-group mb-3 contr">
			<div class="input-group-prepend pass">
				<span class="input-group-text"><i class="fas fa-key"></i></span>
			</div>
			<input type="password" name="clave" id="inputEmail" class="form-control" placeholder="Contrase�a" required autofocus="" title="Ingrese Contrase�a" />
		</div>

		
		<button class="btn btn-lg btn-primary btn-block btn-ingreso" type="submit">
			Ingresar
		</button>
		
		</div>
		
    </form>    
</body>
