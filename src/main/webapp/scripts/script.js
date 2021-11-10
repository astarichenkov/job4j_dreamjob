function validate() {
    let message = 'Не заполнены поля: ';
    let isEmptyFields = false;
    if ($('#name').val() === '') {
        isEmptyFields = true;
        message += 'name' + ', ';
    }
    if ($('#lastname').val() === '') {
        isEmptyFields = true;
        message += 'lastname' + ', ';
    }
    if ($('#sex').val() === '') {
        isEmptyFields = true;
        message += 'sex' + ', ';
    }
    if ($('#description').val() === '') {
        isEmptyFields = true;
        message += 'description';
    }
    if (isEmptyFields) {
        alert(message);
    }
    return !isEmptyFields;
}

function addRow() {
    if (validate()) {
        const name = $('#name').val();
        const lastname = $('#lastname').val();
        const sex = $('#sex').val();
        const description = $('#description').val();

        const Row = document.getElementById("tab");
        const Cells = Row.getElementsByTagName("th");
        let cell = Cells[Cells.length - 1];
        let num = cell.innerText;
        num++;

        $('#tab tr:last').after(
            '<tr>' +
            '<th>' + num + '</th>' +
            '<td>' + name + '</td>' +
            '<td>' + lastname + '</td>' +
            '<td>' + sex + '</td>' +
            '<td>' + description + '</td>' +
            '</tr>');
    }
}

