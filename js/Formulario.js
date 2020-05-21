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

// UI Constructor
class UI {
  addempleado(empleado) {
    const empleadoList = document.getElementById("empleado-list");
    const element = document.createElement("div");
    element.innerHTML = `
            <div class="card text-center mb-4">
                <div class="card-body">
                    <strong>AFPP (8%)</strong>:$ ${empleado.afp} <br>
                    <strong>ISSS (11%)</strong>:$ ${empleado.isss} <br> 
                    <strong>Renta (6%)</strong>:$ ${empleado.renta} <br>
                    <hr>
                    <strong>Total: $ ${empleado.total}</strong>
                </div>
            </div>
        `;
    empleadoList.appendChild(element);
  }

  showMessage(message, cssClass) {
    const div = document.createElement("div");
    div.className = `alert alert-${cssClass} mt-2`;
    div.appendChild(document.createTextNode(message));
    // Muestra mensaje en el DOM
    const container = document.querySelector(".container");
    const app = document.querySelector("#App");
    // Inserta mensaje en el UI
    container.insertBefore(div, app);
    // borra el mensaje despues de 3 segundos
    setTimeout(function () {
      document.querySelector(".alert").remove();
    }, 3000);
  }
}

// DOM Events, al escucha el boton submit captura los valores de los campos
document
  .getElementById("empleado-form")
  .addEventListener("submit", function (e) {
    const dui = document.getElementById("dui").value,
      nombre = document.getElementById("nombre").value,
      departamento = document.getElementById("departamento").value,
      salario = document.getElementById("salario").value,
      estadoCivil = document.getElementById("estadoCivil").value,
      nit = document.getElementById("nit").value,
      estado = document.getElementById("estado").value;
    afp = (salario * 8) / 100;
    isss = (salario * 11) / 100;
    renta = (salario * 6) / 100;
    total = afp + isss + renta;
    e.preventDefault();

    // validar checkbox

    if (estado.checked) {
      this.estado = "true";
    } else {
      this.estado = "false";
    }
    // Crea un nuevo UI
    const ui = new UI();
    // Validacion de Input de usuario
    if (nit == null || nombre == null || salario.length == 0) {
      ui.showMessage("Por favor inserte datos en todos los campos", "danger");
    }

    // Crea un nuevo objecto para mostrar salario y guardar en bd
    const empleado = new Empleado(
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
    );
    console.log(empleado);

    // Guardar el objeto empleado para mostrar descuentos del salario y total
    ui.addempleado(empleado);

    // Enviar a la base de datos
    const options = {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(empleado),
    };
    fetch("http://localhost:8080/api/v1/empleado/nuevo", options);

    // Mensaje de Satisfactorio
    ui.showMessage("Empleado agregado Satisfactoriamente", "success");
  });
