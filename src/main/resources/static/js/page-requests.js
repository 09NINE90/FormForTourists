tableContainer = document.querySelector('.table-container');
table = document.createElement('table');
thead = document.createElement('thead');
tbody = document.createElement('tbody');

const theadRow = thead.insertRow();
theadRow.innerHTML ='<th>Пользователь</th>\n'+
    '            <th>Телефон для связи</th>\n'+
    '            <th>Количество ночей</th>\n'+
    '            <th>Пожелания</th>\n'+
    '            <th>Бюджет (руб.)</th>\n'+
    '            <th>Количество взрослых</th>\n'+
    '            <th>Возраст детей</th>'+
    '            <th>Дата начала отпуска</th>'

table.appendChild(thead);
getRequests();
function getRequests() {
    fetch('/grand_tour/form/getAllRequest')
        .then(response => response.json())
        .then(data => {

            // Заполнение tbody
            data.forEach(request => {
                const row = tbody.insertRow();
                row.innerHTML =`<td>${request.userEntity.lastName} ${request.userEntity.name}</td>
                               <td><a href='tel:${request.userEntity.phoneNumber}'>${request.userEntity.phoneNumber}</a></td>
                               <td>${request.numberOfNights}</td>
                               <td>${request.preferences}</td>
                               <td>${request.budget}</td>
                                <td>${request.numberOfAdults}</td>
                                <td>${request.ageOfChildren}</td>
                                <td >${request.startDate}</td>`
                ;
            });

            table.appendChild(tbody);
            tableContainer.appendChild(table);
        })
        .catch(error => console.error('Ошибка получения данных:', error));

}