const API_URL = 'http://localhost:5000/api/admin';

function showTab(tabName) {
    document.querySelectorAll('.tab-content').forEach(tab => tab.classList.remove('active'));
    document.querySelectorAll('.tab').forEach(tab => tab.classList.remove('active'));
    
    document.getElementById(tabName).classList.add('active');
    event.target.classList.add('active');

    if (tabName === 'empleados') {
        cargarAreasSelect();
        cargarEmpleados();
    } else if (tabName === 'areas') {
        cargarAreas();
    } else if (tabName === 'servicios') {
        cargarServiciosAdmin();
    } else if (tabName === 'reportes') {
        cargarEstadisticas();
    }
}

function showAlert(message, type) {
    const alertDiv = document.createElement('div');
    alertDiv.className = `alert ${type}`;
    alertDiv.textContent = message;
    alertDiv.style.display = 'block';
    
    const container = document.getElementById('alertContainer');
    container.innerHTML = '';
    container.appendChild(alertDiv);
    
    setTimeout(() => alertDiv.style.display = 'none', 5000);
}

// GESTIÓN DE EMPLEADOS
async function cargarAreasSelect() {
    try {
        const response = await fetch(`${API_URL}/areas`);
        const areas = await response.json();
        
        const select = document.getElementById('areaEmp');
        select.innerHTML = '<option value="">Seleccione un área</option>';
        
        areas.forEach(a => {
            select.innerHTML += `<option value="${a.idArea}">${a.nombreArea}</option>`;
        });
    } catch (error) {
        console.error('Error al cargar áreas');
    }
}

document.getElementById('formEmpleado').addEventListener('submit', async (e) => {
    e.preventDefault();

    const telefonos = document.getElementById('telefonosEmp').value
        .split(',')
        .map(t => t.trim())
        .filter(t => t);

    const data = {
        persona: {
            cedulaPer: document.getElementById('cedulaEmp').value,
            primerNom: document.getElementById('primerNomEmp').value,
            segundoNom: '',
            primerApell: document.getElementById('primerApellEmp').value,
            segundoApell: '',
            calle: document.getElementById('calleEmp').value,
            carrera: document.getElementById('carreraEmp').value,
            numero: document.getElementById('numeroEmp').value,
            complemento: ''
        },
        cargo: document.getElementById('cargoEmp').value,
        idArea: parseInt(document.getElementById('areaEmp').value),
        telefonos: telefonos
    };

    try {
        const response = await fetch(`${API_URL}/empleados`, {
            method: 'POST',
            headers: {'Content-Type': 'application/json'},
            body: JSON.stringify(data)
        });

        if (response.ok) {
            showAlert('Empleado registrado exitosamente', 'success');
            e.target.reset();
            cargarEmpleados();
        } else {
            const error = await response.text();
            showAlert('Error: ' + error, 'error');
        }
    } catch (error) {
        showAlert('Error de conexión: ' + error, 'error');
    }
});

async function cargarEmpleados() {
    try {
        const response = await fetch(`${API_URL}/empleados`);
        const empleados = await response.json();
        
        let html = '<table class="data-table"><thead><tr><th>Cédula</th><th>Nombre</th><th>Cargo</th><th>Área</th><th>Acciones</th></tr></thead><tbody>';
        
        empleados.forEach(e => {
            const nombre = e.persona ? 
                `${e.persona.primerNom} ${e.persona.primerApell}` : 
                'N/A';
            const area = e.area ? e.area.nombreArea : 'N/A';
            
            html += `<tr>
                <td>${e.cedulaPer}</td>
                <td>${nombre}</td>
                <td>${e.cargo}</td>
                <td>${area}</td>
                <td>
                    <button class="btn btn-danger" onclick="eliminarEmpleado('${e.cedulaPer}')">Eliminar</button>
                </td>
            </tr>`;
        });
        
        html += '</tbody></table>';
        document.getElementById('listaEmpleados').innerHTML = html;
    } catch (error) {
        showAlert('Error al cargar empleados', 'error');
    }
}

async function eliminarEmpleado(cedula) {
    if (!confirm('¿Está seguro de eliminar este empleado?')) return;

    try {
        const response = await fetch(`${API_URL}/empleados/${cedula}`, {
            method: 'DELETE'
        });

        if (response.ok) {
            showAlert('Empleado eliminado exitosamente', 'success');
            cargarEmpleados();
        } else {
            const error = await response.text();
            showAlert('Error: ' + error, 'error');
        }
    } catch (error) {
        showAlert('Error al eliminar empleado', 'error');
    }
}

// GESTIÓN DE ÁREAS
document.getElementById('formArea').addEventListener('submit', async (e) => {
    e.preventDefault();

    const data = {
        idArea: parseInt(document.getElementById('idArea').value),
        nombreArea: document.getElementById('nombreArea').value
    };

    try {
        const response = await fetch(`${API_URL}/areas`, {
            method: 'POST',
            headers: {'Content-Type': 'application/json'},
            body: JSON.stringify(data)
        });

        if (response.ok) {
            showAlert('Área creada exitosamente', 'success');
            e.target.reset();
            cargarAreas();
        } else {
            const error = await response.text();
            showAlert('Error: ' + error, 'error');
        }
    } catch (error) {
        showAlert('Error de conexión: ' + error, 'error');
    }
});

async function cargarAreas() {
    try {
        const response = await fetch(`${API_URL}/areas`);
        const areas = await response.json();
        
        let html = '<table class="data-table"><thead><tr><th>ID</th><th>Nombre</th></tr></thead><tbody>';
        
        areas.forEach(a => {
            html += `<tr>
                <td>${a.idArea}</td>
                <td>${a.nombreArea}</td>
            </tr>`;
        });
        
        html += '</tbody></table>';
        document.getElementById('listaAreas').innerHTML = html;
    } catch (error) {
        showAlert('Error al cargar áreas', 'error');
    }
}

// GESTIÓN DE SERVICIOS
document.getElementById('formServicio').addEventListener('submit', async (e) => {
    e.preventDefault();

    const data = {
        idServicio: parseInt(document.getElementById('idServicio').value),
        nombre: document.getElementById('nombreServicio').value,
        contenido: document.getElementById('contenidoServicio').value,
        costo: parseFloat(document.getElementById('costoServicio').value)
    };

    try {
        const response = await fetch(`${API_URL}/servicios`, {
            method: 'POST',
            headers: {'Content-Type': 'application/json'},
            body: JSON.stringify(data)
        });

        if (response.ok) {
            showAlert('Servicio creado exitosamente', 'success');
            e.target.reset();
            cargarServiciosAdmin();
        } else {
            const error = await response.text();
            showAlert('Error: ' + error, 'error');
        }
    } catch (error) {
        showAlert('Error de conexión: ' + error, 'error');
    }
});

async function cargarServiciosAdmin() {
    try {
        const response = await fetch(`${API_URL}/servicios`);
        const servicios = await response.json();
        
        let html = '<table class="data-table"><thead><tr><th>ID</th><th>Nombre</th><th>Descripción</th><th>Costo</th><th>Acciones</th></tr></thead><tbody>';
        
        servicios.forEach(s => {
            html += `<tr>
                <td>${s.idServicio}</td>
                <td>${s.nomServicio}</td>
                <td>${s.contenidoServicio}</td>
                <td>$${s.costoServicio.toFixed(2)}</td>
                <td>
                    <button class="btn btn-danger" onclick="eliminarServicio(${s.idServicio})">Eliminar</button>
                </td>
            </tr>`;
        });
        
        html += '</tbody></table>';
        document.getElementById('listaServiciosAdmin').innerHTML = html;
    } catch (error) {
        showAlert('Error al cargar servicios', 'error');
    }
}

async function eliminarServicio(idServicio) {
    if (!confirm('¿Está seguro de eliminar este servicio?')) return;

    try {
        const response = await fetch(`${API_URL}/servicios/${idServicio}`, {
            method: 'DELETE'
        });

        if (response.ok) {
            showAlert('Servicio eliminado exitosamente', 'success');
            cargarServiciosAdmin();
        } else {
            const error = await response.text();
            showAlert('Error: ' + error, 'error');
        }
    } catch (error) {
        showAlert('Error al eliminar servicio', 'error');
    }
}

// REPORTES
async function cargarEstadisticas() {
    try {
        const [clientes, reservas, empleados] = await Promise.all([
            fetch(`${API_URL}/reportes/clientes`).then(r => r.json()),
            fetch(`${API_URL}/reportes/reservas`).then(r => r.json()),
            fetch(`${API_URL}/empleados`).then(r => r.json())
        ]);

        document.getElementById('totalClientes').textContent = clientes.length;
        document.getElementById('totalReservas').textContent = reservas.length;
        document.getElementById('totalEmpleados').textContent = empleados.length;
    } catch (error) {
        console.error('Error al cargar estadísticas');
    }
}

async function cargarServiciosPopulares() {
    try {
        const response = await fetch(`${API_URL}/reportes/servicios-populares`);
        const servicios = await response.json();
        
        let html = '<table class="data-table"><thead><tr><th>Servicio</th><th>Veces Consumido</th></tr></thead><tbody>';
        
        servicios.forEach(([servicio, count]) => {
            html += `<tr>
                <td>${servicio.nomServicio}</td>
                <td>${count}</td>
            </tr>`;
        });
        
        html += '</tbody></table>';
        document.getElementById('reporteServicios').innerHTML = html;
    } catch (error) {
        showAlert('Error al cargar reporte', 'error');
    }
}

async function cargarTodasReservas() {
    try {
        const response = await fetch(`${API_URL}/reportes/reservas`);
        const reservas = await response.json();
        
        let html = '<table class="data-table"><thead><tr><th>Cliente</th><th>Habitación</th><th>Llegada</th><th>Salida</th></tr></thead><tbody>';
        
        reservas.forEach(r => {
            html += `<tr>
                <td>${r.cedulaPer}</td>
                <td>${r.numeroHab}</td>
                <td>${r.fechaLlegada}</td>
                <td>${r.fechaSalida}</td>
            </tr>`;
        });
        
        html += '</tbody></table>';
        document.getElementById('reporteReservas').innerHTML = html;
    } catch (error) {
        showAlert('Error al cargar reservas', 'error');
    }
}

// Inicializar
document.addEventListener('DOMContentLoaded', () => {
    cargarAreasSelect();
    cargarEmpleados();
});