jQuery(function($) {
	$('.phone-js').mask("(99) 99999-9999");
});

jQuery(function($) {
	$('.cep-js').mask("99999-999");
});


$(document).ready(function() {

	$('.compra-js').change(function() {
		var v1 = parseFloat($('.compra-js').val());
		var v2 = parseFloat($('.venda-js').val());
		if (v2 != 0) {
			var soma = (v1 + v2) * 100;
			$('.lucro-js').val(soma);
		}
	});

	$('.venda-js').change(function() {
		var v1 = parseFloat($('.venda-js').val());
		var v2 = parseFloat($('.compra-js').val());
		if (v2 != 0) {
			var soma = (v1 + v2) * 100;
			$('.lucro-js').val(soma);
		}
	});
});