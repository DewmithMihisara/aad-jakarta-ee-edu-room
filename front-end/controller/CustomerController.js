$('#cusGetAll').click(function () {
    $.ajax({
        url : "http://localhost:8080/app/customers",
        method : "GET",
        success : function (resp) {
            console.log("Success: ", resp);
            for (const customer of resp) {
                console.log(customer.id);
                console.log(customer.name);
                console.log(customer.address);

                const row = `<tr>
                                <td>${customer.id}</td>
                                <td>${customer.name}</td>
                                <td>${customer.address}</td>
                            </tr>`;
                $('#tblBody').append(row);
            }

        },
        error : function (error) {
            console.log("error: ", error);
        }
    })
});

$('#btnSave').click(function () {

    const id = $('#txt-id').val();
    const name = $('#txt-name').val();
    const address = $('#txt-address').val();

    const customerObj = {
        id:id,
        name:name,
        address:address
    };

    const jsonObj = JSON.stringify(customerObj);

    $.ajax({
        url: "http://localhost:8080/app/customers",
        method: "POST",
        data: jsonObj,
        success: function (resp) {
            console.log("success: ", resp);
        },
        error: function (error) {
            console.log("error: ", error);
        }
    })
});