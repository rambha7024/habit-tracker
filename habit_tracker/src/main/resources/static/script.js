const apiUrl = '/api/habits';
const tableBody = document.getElementById('habitTableBody');
const form = document.getElementById('habitForm');
const chartCtx = document.getElementById('progressChart').getContext('2d');

let chart;

async function loadHabits() {
    const res = await fetch(apiUrl);
    const habits = await res.json();
    renderTable(habits);
    updateChart(habits);
}

function renderTable(habits) {
    tableBody.innerHTML = '';
    habits.forEach((habit, i) => {
        const row = document.createElement('tr');
        row.innerHTML = `
            <td>${i + 1}</td>
            <td>${habit.name}</td>
            <td>${habit.description}</td>
            <td><input type="checkbox" ${habit.completed ? 'checked' : ''} onchange="toggleCompleted(${habit.id}, this.checked)"></td>
            <td>
                <button class="btn btn-danger btn-sm" onclick="deleteHabit(${habit.id})">Delete</button>
            </td>
        `;
        tableBody.appendChild(row);
    });
}

form.addEventListener('submit', async e => {
    e.preventDefault();
    const habit = {
        name: document.getElementById('name').value,
        description: document.getElementById('description').value,
    };
    await fetch(apiUrl, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(habit),
    });
    form.reset();
    loadHabits();
});

async function toggleCompleted(id, completed) {
    const res = await fetch(`${apiUrl}/${id}`);
    const habit = await res.json();
    habit.completed = completed;
    await fetch(`${apiUrl}/${id}`, {
        method: 'PUT',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(habit),
    });
    loadHabits();
}

async function deleteHabit(id) {
    await fetch(`${apiUrl}/${id}`, { method: 'DELETE' });
    loadHabits();
}

function updateChart(habits) {
    const completedCount = habits.filter(h => h.completed).length;
    const total = habits.length;
    const percentage = total === 0 ? 0 : (completedCount / total) * 100;

    if (chart) chart.destroy();

    chart = new Chart(chartCtx, {
        type: 'doughnut',
        data: {
            labels: ['Completed', 'Pending'],
            datasets: [{
                data: [completedCount, total - completedCount],
                backgroundColor: ['#28a745', '#dc3545']
            }]
        },
        options: {
            plugins: {
                title: {
                    display: true,
                    text: `Progress: ${percentage.toFixed(1)}%`
                }
            }
        }
    });
}

loadHabits();
