"use strict";

// Empleado Constructor
class Empleado {
  constructor(
    dui,
    nombre,
    departamento,
    salario,
    estadoCivil,
    nit,
    estado,
    afp,
    isss,
    renta,
    total
  ) {
    this.dui = dui;
    this.nombre = nombre;
    this.departamento = departamento;
    this.salario = salario;
    this.estadoCivil = estadoCivil;
    this.nit = nit;
    this.estado = estado;
    this.afp = afp;
    this.isss = isss;
    this.renta = renta;
    this.total = total;
  }
}

var content = document.querySelector("#content");

// Listado de empleados
function ObtenerEmpleados() {
  return fetch("http://localhost:8080/api//v1/empleado/lista");
}
ObtenerEmpleados()
  .then((res) => res.json())
  .then((data) => {
    tabla(data);
  });

// Mostrar datos en la tabla
function tabla(data) {
  for (let valor of data) {
    content.innerHTML += `
        <tr>
            <td>${valor.nombre}</td>
            <td>${valor.dui}</td>
            <td>${valor.salario}</td>
            <td> ${
              valor.estado
                ? "<input type='checkbox' checked>"
                : "<input type='checkbox'>"
            }</td>
            <td><button type="button" class="btn btn-danger" 
            value="${valor.dui}" data-id="${
      valor.dui
    }" id="eliminar">Eliminar</button>
            <button type="button" class="btn btn-warning" href="formulario.html?${
              valor.dui
            }"
            >Editar</button>
            </td>
        </tr>
    `;
  }

  // Actualizar Empleado
  actualizarEmpleado()
    .then((res) => res.json())
    .then((data) => {
      console.log(data);
    });

  function actualizarEmpleado() {
    return fetch("http://localhost:8080/api/v1/empleado/eliminar/1", {
      method: "POST",
      body: JSON.stringify({
        fakeData: 200,
        id: 1,
      }),
      headers: {
        "Content-type": "application/json",
      },
    });
  }

  // Eliminar Empleado
  const eliminar = document.getElementById("eliminar");
  eliminar.addEventListener("click", function (e) {
    // const dui = document.getElementById("eliminar").value;
    // let dui = event.target.parentElement.dataset.id;
    // console.log(dui);
    let botonEliminarPresionado = e.target.className === "btn btn-danger";
    if (botonEliminarPresionado) {
      eliminarEmpleado()
        .then((res) => res.json())
        .then((data) => {
          console.log(data);
        });

      function eliminarEmpleado() {
        let dui = e.target.parentElement.dataset.id;
        console.log(dui);
        return fetch(`http://localhost:8080/api/v1/empleado/eliminar/${dui}`, {
          method: "PATCH",
        });
      }
    }
  });

  // DataTable
  $(document).ready(function () {
    $("#empleado").DataTable();
  });
}
