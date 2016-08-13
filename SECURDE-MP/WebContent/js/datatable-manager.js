$(document).ready(function() {
	var dataSet = [
    [ "1", "2", "P200.00", "3", "P600.00" ],
    [ "1", "2", "P200.00", "3", "P600.00" ],
	];
	changeAccManContext(dataSet);
} );

function changeAccManContext( dataSet ){
	 $('#acc-man-table').DataTable( {
        data: dataSet,
        columns: [
            { title: "Product ID" },
            { title: "Category ID" },
            { title: "Unit Price" },
            { title: "Quantity" },
            { title: "Total Price" }
        ]
    } );
}