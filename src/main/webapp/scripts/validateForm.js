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
    return false;
}