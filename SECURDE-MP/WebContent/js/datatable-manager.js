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