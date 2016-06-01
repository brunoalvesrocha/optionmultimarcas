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

$(function() {
	
	$('[rel=tooltip]').tooltip();
	
	$('.js-currency').maskMoney({decimal: ',', thousands: '.', allowZero: true });
	
	$('.js-atualizar-status').on('click', function(event) {
		
		event.preventDefault();
		var botaoReceber = $(event.currentTarget);
		var urlReceber = botaoReceber.attr('href');
		
		console.log('urlReceber', urlReceber);
		
		var response = $.ajax({
			url: urlReceber,
			type: 'PUT'
		});
		
		response.done(function(e) {
			var codigoTitulo = botaoReceber.data('codigo');
			$('[data-role=' + codigoTitulo + ']').html('<span class="label label-success">Recebido</span>');
			botaoReceber.hide();
		});
		
		response.fail(function(e) {
			console.log(e);
			alert('Erro recebendo cobrança');
		});
	});
});