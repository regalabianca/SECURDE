function showError(message){
	new PNotify({
		title: 'Oh No!',
		text: message,
		type: 'error'
	});
}