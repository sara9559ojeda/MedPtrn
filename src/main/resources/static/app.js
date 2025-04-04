const API_URL = 'http://localhost:8080/api/medicine';

async function fetchMedicines() {
  const res = await fetch(API_URL);
  const data = await res.json();
  const table = document.getElementById('medicine-list');
  table.innerHTML = '';

  data.forEach(med => {
    const row = `
      <tr>
        <td>${med.id}</td>
        <td>${med.name}</td>
        <td>${med.price}</td>
        <td>${med.quantity}</td>
        <td>
          <button class="edit" onclick="editMedicine(${med.id}, '${med.name}', ${med.price}, ${med.quantity})">Editar</button>
          <button class="delete" onclick="deleteMedicine(${med.id})">Eliminar</button>
        </td>
      </tr>
    `;
    table.innerHTML += row;
  });
}

async function saveMedicine() {
  const id = document.getElementById('medicine-id').value;
  const name = document.getElementById('name').value;
  const price = parseFloat(document.getElementById('price').value);
  const quantity = parseInt(document.getElementById('quantity').value);

  const medicine = { name, price, quantity };

  if (id) {
    // PUT
    await fetch(`${API_URL}/${id}`, {
      method: 'PUT',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(medicine)
    });
  } else {
    // POST
    await fetch(API_URL, {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(medicine)
    });
  }

  clearForm();
  fetchMedicines();
}

function editMedicine(id, name, price, quantity) {
  document.getElementById('medicine-id').value = id;
  document.getElementById('name').value = name;
  document.getElementById('price').value = price;
  document.getElementById('quantity').value = quantity;
}

async function deleteMedicine(id) {
  await fetch(`${API_URL}/${id}`, { method: 'DELETE' });
  fetchMedicines();
}

function clearForm() {
  document.getElementById('medicine-id').value = '';
  document.getElementById('name').value = '';
  document.getElementById('price').value = '';
  document.getElementById('quantity').value = '';
}

fetchMedicines();
