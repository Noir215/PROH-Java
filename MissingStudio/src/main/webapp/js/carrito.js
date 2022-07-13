// Variable Global
carrito = new Object();

class ItemCarrito {
    constructor (codigo = null, descripcion = null, precio = null, cantidad = null) {
        if (codigo === null || descripcion === null || precio === null || cantidad === null) {
            throw new Error ('Algún parámetro es nulo');
        }
        
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.cantidad = cantidad;
    }
}

function eliminarCarrito () {
	localStorage.removeItem("pedido");
}

function addProducto (codigo, descripcion, precio, cantidad) {
    let cadena = localStorage.getItem("pedido");
    let existe = false;

    if (!(cadena === null)) {
        carrito = JSON.parse(cadena);
    }

    let item = new ItemCarrito(codigo, descripcion, precio, cantidad)

    for (var i in carrito) {
        if (codigo == carrito[i].codigo) {
            existe = true
        }
    }

    if (existe == true) {
        parseInt(carrito[codigo].cantidad++);
        alert("Se ha aumentado en uno la cantidad de " + descripcion);
    }
    else {
        carrito[item.codigo] = item;
        alert("El producto " + descripcion + " se ha añadido al carrito."); 
    }   

    cadena = JSON.stringify(carrito);
    localStorage.setItem("pedido", cadena);

    //pintaTabla ();
}

function incrementaCantidad (codigo) {
    let cadena = localStorage.getItem("pedido");
    if (!(cadena === null)) {
        carrito = JSON.parse(cadena);
    }

    let item = carrito[codigo];
    let nuevoValor = parseInt(item.cantidad) + 1;

    /*  Implementar más adelante para comprobr Stock
    if (nuevoValor>5) {
        throw new Error('La valoración debe ser un número entre 0 y 5')
    } */

    item.cantidad = nuevoValor;

    cadena = JSON.stringify(carrito);
    localStorage.setItem("pedido", cadena);

    pintaTabla ();
}

function decrementaCantidad(codigo) {
    let cadena = localStorage.getItem("pedido");
    if (!(cadena === null)) {
        carrito = JSON.parse(cadena);
    }

    let item = carrito[codigo];
    let nuevoValor = parseInt(item.cantidad) - 1;
    if (nuevoValor < 1) {
        delete carrito[codigo];
    } else {    
        item.cantidad = nuevoValor;
    }

    let contador = 0;
    for (var key in carrito) {
        contador++;
    }

    if (contador > 0) {
        cadena = JSON.stringify(carrito);
        localStorage.setItem("pedido", cadena);
    } else {
        localStorage.removeItem("pedido");
    }

    pintaTabla();
}

function eliminaProducto(codigo) {
    delete carrito[codigo];

    let contador = 0;
    for (var key in carrito) {
        contador++;
    }

    if (contador > 0) {
        cadena = JSON.stringify(carrito);
        localStorage.setItem("pedido", cadena);
    } else {
        localStorage.removeItem("pedido");
    }

    pintaTabla();
}

function createIncreaseButton(idCantidad) {
    return '<a href="#" onclick="incrementaCantidad(\'' + idCantidad + '\')"><i style="font-size:24px" class="fa">&#xf0aa;</i></a>';
}

function createDecreaseButton(idCantidad) {
    return "  " + '<a href="#" onclick="decrementaCantidad(\'' + idCantidad +'\')"><i style="font-size:24px" class="fa">&#xf0ab;</i></a>';
}

function createEliminateButton(idCantidad) {
    return '<button type="button" onclick="eliminaProducto(\'' + idCantidad + '\')">Eliminar</button>';
}

function pintaTabla() {
    let cuerpo = document.getElementById('CuerpoTabla');

    // Borramos tabla
    let rowCount = cuerpo.rows.length;
    while (rowCount > 0) {
        cuerpo.deleteRow(0);
        rowCount = cuerpo.rows.length;
    }

    let cadena = localStorage.getItem("pedido");
    let carrito = JSON.parse(cadena);
    let total = 0;
    for (var codigo in carrito) {
        // Pintamos tabla
        item = carrito[codigo];
        let row = cuerpo.insertRow(0);
        let cell1 = row.insertCell(0); cell1.innerHTML = item.descripcion;
        let cell2 = row.insertCell(1); cell2.innerHTML = item.precio;
        let cell3 = row.insertCell(2); cell3.innerHTML = item.cantidad;
        let cell4 = row.insertCell(3); cell4.innerHTML = createIncreaseButton(item.codigo) + createDecreaseButton(item.codigo);
        let cell5 = row.insertCell(4); cell5.innerHTML = createEliminateButton(item.codigo);
        total += item.precio * parseInt(item.cantidad);
    }
    let pie = document.getElementById('PrecioTotal');
    pie.innerHTML = total;
}