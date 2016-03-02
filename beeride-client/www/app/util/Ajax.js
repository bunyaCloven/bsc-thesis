Ext.define('Beeride.util.Ajax', {
	singleton : true,
	load : function(form, url) {
		Ext.Ajax.request({
			url : url,
			success : function(response) {
				var data = JSON.parse(response.responseText);
				for ( var x in data.data) {
					var field = form.down('[name=' + x + ']');
					if(field){
						field.setValue(data.data[x]);
					}
				}
			}
		});
	}
});