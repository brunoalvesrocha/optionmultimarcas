$('#confirmacaoExclusaoModalProvider').on('show.bs.modal', function(event) {
	
	var button = $(event.relatedTarget);
	
	var idProvider = button.data('id');
	var providerName = button.data('contact');
	
	var modal = $(this);
	var form = modal.find('form');
	var action = form.data('url-base');
	if(!action.endsWith('/')) {
		action += '/';
	}
	
	form.attr('action', action + idProvider);
	
	modal.find('.modal-body span').html('Tem certeza que deseja excluir o Fornecedor <strong>' + providerName + '</strong>?');
});

$('#confirmacaoExclusaoModalProduct').on('show.bs.modal', function(event) {
	
	var button = $(event.relatedTarget);
	
	var idProduct = button.data('id');
	var productName = button.data('name');
	
	var modal = $(this);
	var form = modal.find('form');
	var action = form.data('url-base');
	if(!action.endsWith('/')) {
		action += '/';
	}
	
	form.attr('action', action + idProduct);
	
	modal.find('.modal-body span').html('Tem certeza que deseja excluir o Produto <strong>' + productName + '</strong>?');
});

$('#confirmacaoExclusaoModalCustomer').on('show.bs.modal', function(event) {
	
	var button = $(event.relatedTarget);
	
	var idCustomer = button.data('id');
	var customerName = button.data('name');
	
	var modal = $(this);
	var form = modal.find('form');
	var action = form.data('url-base');
	if(!action.endsWith('/')) {
		action += '/';
	}
	
	form.attr('action', action + idCustomer);
	
	modal.find('.modal-body span').html('Tem certeza que deseja excluir o Cliente <strong>' + customerName + '</strong>?');
});

$(function() {
	
	$('[rel=tooltip]').tooltip();
	
	$('.js-currency').maskMoney({decimal: ',', thousands: '.', allowZero: true });
});