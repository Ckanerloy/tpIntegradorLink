# tpIntegrador
Ejemplos de uso de la API:
Crear una promocion utilice un repo (@RepositoryRestResource): 
Hacer un post "http://localhost:8080/medioDePagos" y el body: 
{"tipo":"3","medioDePago":"TARJETA_DEBITO","porcentaje":10}

Para ver la promocion creada: http://localhost:8080/promociones

Para crear un item de compra (POST): "http://localhost:8080/itemsDeCompras"
Con body (tener en cuenta que el producto 2 ya viene creado por el initData):
{"producto":"http://localhost:8080/productos/2","cantidad":1}

Para crear un rol,por ejemplo un cliente, utilice un repositorio (@RepositoryRestResource). Para crearlo, hacer un POST a "http://localhost:8080/clientes" , con el siguiente body:

{"nombreYApellido":"Juan Perez","comprasRealizadas":[],"fechaDeNacimiento":"1999-11-11","tipoDeDocumento":"DNI","nroDeDocumento":"40976081","telefono":48760011,"mail":"juanperez@gmail.com"}

Y para crearle un usuario a este cliente,necesito hacer un post a "http://localhost:8080/usuarios" y en el body
{"user":"Juan","contra":"abcgtysf","rol":Aca mandarle el link al rol que acabamos de crear}

Para saber cual es el link del rol,necesitamos hacer un get a "http://localhost:8080/clientes" y buscar al cliente que se llame Juan Perez.

Ahora para agregar el item de compra al carrito de compra,utilice un controller complementario (@RestController) que se llama CarritoControllerComplement, que utiliza "/{clienteID}/carritoDeCompras/items/{productoID}/{cantidad}". En donde en este controller se crea el nuevo item de compra y se guarda en el repositorio de items de compra,el cual es un (@RepositoryRestResource)
